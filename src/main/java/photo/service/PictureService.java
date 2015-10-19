package photo.service;

import javax.inject.Inject;

import photo.model.Picture;
import photo.model.User;
import photo.persistence.PictureDao;
import photo.persistence.UserDao;

public class PictureService {

	@Inject
	private PictureDao pictureDao;

	@Inject
	private UserDao userDao;
	
	
	public void addPicture(final Picture picture, final Long userId) {
		User user = userDao.getUser(userId);
		if (user != null) {
			picture.setUser(user);
			pictureDao.persistPicture(picture);
		}
	}

}
