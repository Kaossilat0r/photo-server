package photo.resource;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import photo.service.PictureService;

@ManagedBean
@Path("/")
public class PictureResource {
	
	@Inject
	private PictureService pictureService;
	
	@GET
	@Path("test")
	public final String test() {
		
		System.out.println("test()");
		
		pictureService.testService();
		pictureService.savePicture("full", "thumb", 1L);
		
		return "Hello Resource";
	}
}
