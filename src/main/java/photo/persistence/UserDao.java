package photo.persistence;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import photo.model.User;

public class UserDao {

	@Inject
	private EntityManager entityManager;
	
	public final User getUser(final Long userId) {
		
		entityManager.getTransaction().begin();
		User user = entityManager.find(User.class, userId);
		entityManager.getTransaction().commit();
		
		return user;
	}
	
	public final List<User> getUsers() {
		entityManager.getTransaction().begin();
		
		String query = "select u from User u";
		List<User> users = entityManager.createQuery(query, User.class)
				.getResultList();
		
		entityManager.getTransaction().commit();
		return users;
	}
}
