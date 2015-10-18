package photo;

import org.glassfish.jersey.server.ResourceConfig;

public class App extends ResourceConfig {
	
	public App() {
		
		register(new AppBinder());		
		packages(true, "photo");
	}
	
}
