package photo.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import photo.model.User;
import photo.persistence.UserDao;

@Path("/users")	// XXX otherwise this would clash with PictureResource, doh!
public class UserResource {

	@Inject
	private UserDao userDao;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public final List<User> getUsers() {
		return userDao.getUsers();
	}
	
	@GET
	@Path("{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public final User getUser(@PathParam("userId") final Long userId) {
		return userDao.getUser(userId);
	}
}
