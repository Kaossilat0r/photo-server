package photo.persistence;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.glassfish.hk2.api.Factory;

public class EMFactory implements Factory<EntityManager> {

	private final EntityManager em;
	
    @Inject
    public EMFactory (EntityManagerFactory emf){
        em = emf.createEntityManager();
    }
	
	@Override
	public EntityManager provide() {
		return em;
	}

	@Override
	public void dispose(EntityManager instance) {
		if(instance.isOpen()) {
			instance.close();
		}
	}

}
