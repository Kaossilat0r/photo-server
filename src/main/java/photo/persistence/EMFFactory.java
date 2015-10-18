package photo.persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.glassfish.hk2.api.Factory;

public class EMFFactory implements Factory<EntityManagerFactory>{

	private final EntityManagerFactory emf;
	private static final String PERSISTENCE_UNIT = "photo";
	
    public EMFFactory (){
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
    }
	
	@Override
	public EntityManagerFactory provide() {
		return emf;
	}

	@Override
	public void dispose(EntityManagerFactory instance) {
		if(instance.isOpen()) {
			instance.close();
		}
	}

}
