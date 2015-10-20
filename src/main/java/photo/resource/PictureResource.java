package photo.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import photo.model.Picture;
import photo.persistence.PictureDao;
import photo.service.PictureService;

@Path("/user/{id}/photo")
public class PictureResource {
	
	@Inject
	private PictureService pictureService;
	
	@Inject
	private PictureDao pictureDao;
	
	/* all photos for a user */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public final List<Picture> getPhotos(@PathParam("id") final Long userId) {
		return pictureDao.getPhotos(userId);
	}
	
	/* all photos for a user by tag */
	@POST
	@Path("byTag")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public final List<Picture> getPhotos(@PathParam("id") final Long userId, List<Long> tagIds) {
		return pictureDao.getPhotos(userId, tagIds);
	}

	/* add photo */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public final void addPhoto(Picture picture, @PathParam("id") final Long userId) {
		pictureService.addPicture(picture, userId);
	}

	/* delete photo */
	@DELETE
	@Path("{pictureId}")
	public final void deletePhoto(@PathParam("pictureId") final Long pictureId) {
		pictureDao.removePicture(pictureId);
	}
	
}
