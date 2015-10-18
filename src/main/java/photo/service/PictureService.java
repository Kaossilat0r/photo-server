package photo.service;

import java.util.List;

import javax.inject.Inject;

import photo.model.Picture;
import photo.persistence.PictureDao;

public class PictureService {

	@Inject
	private PictureDao pictureDao;
	
	public Picture pingService(final Long userId) {
		Picture p = new Picture("/full/url", "/thumb/url", 0L);
		p.setUserId(userId);
		return p;
	}
	
	public void addPicture(final Picture picture, final Long userId) {
		picture.setUserId(userId);
		pictureDao.persistPicture(picture);
	}
	
	public void removePicture(final Long pictureId) {
		pictureDao.removePicture(pictureId);
	}

	public List<Picture> getPhotos(final Long userId) {
		return pictureDao.getPhotos(userId);
	}
}
