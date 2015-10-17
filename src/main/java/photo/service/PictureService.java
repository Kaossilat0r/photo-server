package photo.service;

import javax.inject.Inject;

import photo.model.Picture;
import photo.persistence.PictureDao;

public class PictureService {

	@Inject
	private PictureDao pictureDao;
	
	public void testService() {
		
		System.out.println("testService");
	}
	
	public void savePicture(String fullURL, String thumbURL, Long userId) {
		
		System.out.println("Saving Picture");
		
		Picture picture = new Picture(fullURL, thumbURL, userId);
		
		pictureDao.persistPicture(picture);
		
		System.out.println("Picture saved");
	}
}
