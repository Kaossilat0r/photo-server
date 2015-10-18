package photo.persistence;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import photo.model.Picture;

public class PictureDao {

	@Inject
	private EntityManager entityManager;

	public final void persistPicture(final Picture picture) {
		entityManager.getTransaction().begin();
		entityManager.persist(picture);
		entityManager.getTransaction().commit();
	}

	public final void removePicture(final Picture picture) {
		Picture managedPicture = entityManager.find(Picture.class, picture.getId());

		if (picture.equals(managedPicture)) {
			// delete on exact match
			entityManager.getTransaction().begin();
			entityManager.remove(managedPicture);
			entityManager.getTransaction().commit();
		}
	}

	public List<Picture> getPhotos(final Long userId) {
		String query = "select p from Picture p where p.userId = :id";
		return entityManager.createQuery(query, Picture.class).setParameter("id", userId).getResultList();
	}

}
