package jwscert.rest.services;

import jwscert.rest.services.book.JsonResourcesTest;
import jwscert.rest.services.book.JsonSearchBooksTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ HelloWorldTest.class, MediaTypeAnnotationTest.class,
		JsonResourcesTest.class, JsonSearchBooksTest.class })
public class AllTests {

}
