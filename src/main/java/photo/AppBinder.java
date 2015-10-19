package photo;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.process.internal.RequestScoped;

import photo.persistence.EMFFactory;
import photo.persistence.EMFactory;
import photo.persistence.PictureDao;
import photo.persistence.UserDao;
import photo.resource.PictureResource;
import photo.resource.UserResource;
import photo.service.PictureService;

public class AppBinder extends AbstractBinder {

	@Override
	protected void configure() {
		
		bind(UserResource.class).to(UserResource.class);
		bind(UserDao.class).to(UserDao.class);
		
		bind(PictureResource.class).to(PictureResource.class);
		bind(PictureService.class).to(PictureService.class);
		bind(PictureDao.class).to(PictureDao.class);
		
		
		bindFactory(EMFFactory.class).to(EntityManagerFactory.class).in(Singleton.class);
		bindFactory(EMFactory.class).to(EntityManager.class).in(RequestScoped.class);
		
	}
}
