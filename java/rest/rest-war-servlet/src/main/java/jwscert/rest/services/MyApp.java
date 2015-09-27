package jwscert.rest.services;


import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import jwscert.rest.services.HelloWorld;
import jwscert.rest.services.MediaTypeAnnotation;
import jwscert.rest.services.PathAnnotation;
import jwscert.rest.services.QueryParamAnnotation;
import jwscert.rest.services.book.JsonResources;
import jwscert.rest.services.book.SearchBooks;

public class MyApp extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<Class<?>>();
		s.add(HelloWorld.class);
		s.add(QueryParamAnnotation.class);
		s.add(PathAnnotation.class);
		s.add(MediaTypeAnnotation.class);
		s.add(JsonResources.class);
		s.add(SearchBooks.class);
		return s;
	}

}
