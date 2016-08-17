package jwscert.jaxws.client;

import java.io.PrintWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

public class Utils {
	
	private JAXBContext context = null;
	
	public Utils(){
		try {
			setJAXBContext(JAXBContext.newInstance("com.cdyne.weather.types"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	

    public void jaxbObjectToXML(Object object, PrintWriter out) {

        try {
            
            Marshaller m = getJAXBContext().createMarshaller();
            //for pretty-print XML in JAXB
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            
            out.println("Class:" + object.getClass());
            
            // Write to File
            m.marshal(object, out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }	
    
    public void sourceToXML(Source result, PrintWriter out) {
        try {
           TransformerFactory factory = TransformerFactory.newInstance();
           Transformer transformer = factory.newTransformer();
           transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
           transformer.setOutputProperty(OutputKeys.METHOD, "xml");
           transformer.setOutputProperty(OutputKeys.INDENT, "yes");
           //OutputStream out = new ByteArrayOutputStream();
           StreamResult streamResult = new StreamResult();
           streamResult.setWriter(out);
           transformer.transform(result, streamResult);
        } catch (TransformerException e) {
           e.printStackTrace();
        }
     }


	public JAXBContext getJAXBContext() {
		return context;
	}


	public void setJAXBContext(JAXBContext context) {
		this.context = context;
	}    
}
