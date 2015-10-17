package photo;

import org.glassfish.jersey.server.ResourceConfig;

public class App extends ResourceConfig {
	
	public App() {
		
		register(new PhotoApplicationBinder());		
		packages(true, "photo");
	}
	
}
