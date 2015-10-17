package photo.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import photo.model.Picture;

public class PictureDao {

	@PersistenceContext(unitName = "photo")
	private EntityManager entityManager;
	
	public final void persistPicture(final Picture picture) {
		entityManager.persist(picture);
	}
	

	
}
