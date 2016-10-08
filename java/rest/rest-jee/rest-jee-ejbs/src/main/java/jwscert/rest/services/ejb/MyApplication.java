package jwscert.rest.services.ejb;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest2")
public class MyApplication extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<Class<?>>();
		s.add(EjbBean.class);
		//s.add(PathAnnotation.class);
		//s.add(MediaTypeAnnotation.class);
		//s.add(JsonResources.class);
		//s.add(SearchBooks.class);		
		return s;
	}

}
