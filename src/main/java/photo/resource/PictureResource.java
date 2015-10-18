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
import photo.service.PictureService;

@Path("/user/{id}")
public class PictureResource {
	
	@Inject
	private PictureService pictureService;
	
	// TODO testing only. remove
	@GET
	@Path("ping")
	@Produces(MediaType.APPLICATION_JSON)
	public final Picture pingResource(@PathParam("id") final Long userId) {
		
		Picture p = pictureService.pingService(userId);
		return p;
	}
	
	@POST
	@Path("photo")
	@Consumes(MediaType.APPLICATION_JSON)
	public final void addPhoto(Picture picture, @PathParam("id") final Long userId) {
		pictureService.addPicture(picture, userId);
	}
	
	@DELETE
	@Path("photo/{pictureId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public final void deletePhoto(@PathParam("pictureId") final Long pictureId) {
		pictureService.removePicture(pictureId);
	}
	
	@GET
	@Path("photo")
	@Produces(MediaType.APPLICATION_JSON)
	public final List<Picture> getPhotos(@PathParam("id") final Long userId) {
		return pictureService.getPhotos(userId);
	}
}
