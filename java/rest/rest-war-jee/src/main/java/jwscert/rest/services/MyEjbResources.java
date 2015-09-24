package jwscert.rest.services;


import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import jwscert.rest.services.book.JsonResources;
import jwscert.rest.services.book.SearchBooksImp;


@ApplicationPath("/jaxrs")
public class MyEjbResources extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<Class<?>>();
		s.add(HelloWorld.class);
		s.add(QueryParamAnnotation.class);
		s.add(PathAnnotation.class);
		s.add(MediaTypeAnnotation.class);
		s.add(JsonResources.class);
		s.add(SearchBooksImp.class);		
		return s;
	}
}
