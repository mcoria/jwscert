package jwscert.rest.services;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest1")
public class MyApplication extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<Class<?>>();
		s.add(MyTest.class);
		s.add(MyEjbResource1.class);
		s.add(MyEjbResource2.class);
		//s.add(PathAnnotation.class);
		//s.add(MediaTypeAnnotation.class);
		//s.add(JsonResources.class);
		//s.add(SearchBooks.class);		
		return s;
	}

}
