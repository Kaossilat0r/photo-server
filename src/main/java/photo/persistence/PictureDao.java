package photo.persistence;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import photo.model.Picture;
import photo.model.Tag;
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

		User user = getUserById(userId);
		
		String query = "select p from Picture p where p.user = :user";
		List<Picture> pictures = entityManager.createQuery(query, Picture.class)
				.setParameter("user", user).getResultList();

		entityManager.getTransaction().commit();

		return pictures;
	}

	public List<Picture> getPhotos(final Long userId, final List<Long> tagIds) {
		
		if (tagIds.isEmpty()) {
			return getPhotos(userId);
		}
		
		entityManager.getTransaction().begin();
		
		User user = getUserById(userId);
		List<Tag> tags = getTagsByIds(tagIds);
		
		String query = "select p from Picture p "
				+ " join p.tags t " 
				+ " where p.user = :user "
				+ " and t in :tags "
				+ " group by p "
				+ " having count(t) = :count";
		
		List<Picture> pictures = entityManager.createQuery(query, Picture.class)
				.setParameter("user", user)
				.setParameter("tags", tags)
				.setParameter("count", (long)tags.size())
				.getResultList();
		
		entityManager.getTransaction().commit();
		
		return pictures;
	}
	
	public List<Tag> getTags(final Long userId) {
		entityManager.getTransaction().begin();
		
		User user = getUserById(userId);
		// TODO return only tags for specified user
		String query = "select t from Tag t";
		List<Tag> tags = entityManager.createQuery(query, Tag.class).getResultList();
		
		entityManager.getTransaction().commit();
		return tags;
	}
	
	private User getUserById(final Long userId) {
		return entityManager.find(User.class, userId);
	}
	
	private List<Tag> getTagsByIds(final List<Long> tagIds) {
		return entityManager.createQuery("select t from Tag t where t.id in :tagIds", Tag.class)
				.setParameter("tagIds", tagIds).getResultList();
	}
}
