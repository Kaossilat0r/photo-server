package photo.resource;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.validation.constraints.AssertFalse;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import photo.App;
import photo.model.Picture;

public class PictureResourceTest extends JerseyTest {

	private static final String BASE = "/user/1";
	
	private static final Picture NEW_PICTURE = new Picture("/full/url/new","/thumb/url/new",1L);
	private static final Entity<Picture> NEW_PICTURE_ENTITY = Entity.entity(NEW_PICTURE, MediaType.APPLICATION_JSON);
	private static final int NEW_PICTURE_ID = 7;
	
	private static final GenericType<List<Picture>> LIST_TYPE = new GenericType<List<Picture>>(){};
	
	@Override
	protected Application configure() {
		return new App();
	}

	@Test
	public void testPing() {
		Response response = target(BASE + "/ping").request().get();
		Picture picture = response.readEntity(Picture.class);
		response.close();

		assertEquals("/full/url", picture.getFullURL());
	}
	
	@Test
	public void testDbAccess() {
		List<Picture> pictures = getPictures();
		assertEquals(3, pictures.size());
	}
	
	@Test
	public void testAddRemove() {
		List<Picture> pictures = getPictures();
		assertEquals(3, pictures.size());
	
		Response responseAdd = target(BASE + "/photo").request().post(NEW_PICTURE_ENTITY);
		assertEquals(204, responseAdd.getStatus());
		responseAdd.close();

		pictures = getPictures();
		assertEquals(4, pictures.size());

		Response responseRemove = target(BASE + "/photo/" + NEW_PICTURE_ID).request().delete();
		responseRemove.close();
		assertEquals(204, responseRemove.getStatus());

		pictures = getPictures();
		assertEquals(3, pictures.size());
	}

	private List<Picture> getPictures() {
		Response response = target(BASE + "/photo").request().get();

		assertEquals(200, response.getStatus());

		List<Picture> pictures = response.readEntity(LIST_TYPE);
		response.close();
		
		return pictures;
	}
}
