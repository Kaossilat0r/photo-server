package photo.persistence;

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
	

	
}
