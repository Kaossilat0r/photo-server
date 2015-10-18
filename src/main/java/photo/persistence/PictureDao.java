package photo.persistence;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import photo.model.Picture;
import photo.model.User;

public class PictureDao {

	@Inject
	private EntityManager entityManager;

	public final void persistPicture(final Picture picture) {
		entityManager.getTransaction().begin();
		entityManager.persist(picture);
		entityManager.getTransaction().commit();
	}

	public final void removePicture(final Long pictureId) {
		Picture managedPicture = entityManager.find(Picture.class, pictureId);

		if (managedPicture != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(managedPicture);
			entityManager.getTransaction().commit();
		}
	}

	public List<Picture> getPhotos(final Long userId) {
		entityManager.getTransaction().begin();

		User user = entityManager.find(User.class, userId);
		
		String query = "select p from Picture p where p.user = :user";
		List<Picture> pictures = entityManager.createQuery(query, Picture.class)
				.setParameter("user", user).getResultList();

		entityManager.getTransaction().commit();

		return pictures;
	}

}
