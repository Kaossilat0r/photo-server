package photo.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import photo.model.Tag;
import photo.model.User;
import photo.persistence.PictureDao;
import photo.persistence.UserDao;

@Path("/user")
public class UserResource {

	@Inject
	private UserDao userDao;
	
	@Inject
	private PictureDao pictureDao;
	
	/* get all users */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public final List<User> getUsers() {
		return userDao.getUsers();
	}
	
	/* get user */
	@GET
	@Path("{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public final User getUser(@PathParam("userId") final Long userId) {
		return userDao.getUser(userId);
	}
	
	// XXX RN: note that this resource is mapped to a user but currently gets all tags
	/* get all tags */
	@GET
	@Path("{userId}/tags")
	@Produces(MediaType.APPLICATION_JSON)
	public final List<Tag> getTags(@PathParam("userId") final Long userId) {
		return pictureDao.getAllTags(userId);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{userId}/tags")
	public final void addTag(final Tag tag) {
		pictureDao.addTag(tag);
	}
	
}
