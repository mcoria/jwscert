package jwscert.jaxws.client;

import java.io.PrintWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Utils {

    public void jaxbObjectToXML(Object object, PrintWriter out) {

        try {
            JAXBContext context = JAXBContext.newInstance("com.cdyne.weather.types");
            Marshaller m = context.createMarshaller();
            //for pretty-print XML in JAXB
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Write to System.out for debugging
            // m.marshal(emp, System.out);
            
            out.println("Class:" + object.getClass());
            
            // Write to File
            m.marshal(object, out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }	
}
