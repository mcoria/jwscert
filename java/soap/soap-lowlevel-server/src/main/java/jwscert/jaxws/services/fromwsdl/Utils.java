package jwscert.jaxws.services.fromwsdl;

import java.io.PrintStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class Utils {
	
	private JAXBContext context = null;
	private Marshaller marshaller = null;
	private Unmarshaller unmarshaller;
	
	public Utils(){
		try {
			setJAXBContext(JAXBContext.newInstance("net.webservicex"));
			
            marshaller = getJAXBContext().createMarshaller();
            
            
            //for pretty-print XML in JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            
            
            unmarshaller = getJAXBContext().createUnmarshaller();
            
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	

    public void jaxbObjectToXML(Object object, PrintStream out) {
        try {

            out.println("Class:" + object.getClass());
            
            // Write to File
            marshaller.marshal(object, out);
            
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }	
    
    public void sourceToXML(Source result, PrintStream out) {
        try {
           TransformerFactory factory = TransformerFactory.newInstance();
           Transformer transformer = factory.newTransformer();
           transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
           transformer.setOutputProperty(OutputKeys.METHOD, "xml");
           transformer.setOutputProperty(OutputKeys.INDENT, "yes");
           //OutputStream out = new ByteArrayOutputStream();
           StreamResult streamResult = new StreamResult();
           streamResult.setOutputStream(out);
           transformer.transform(result, streamResult);
        } catch (TransformerException e) {
           e.printStackTrace();
        }
     }
    
	public Object unmarshall(Source input) {
		try {
			return unmarshaller.unmarshal(input);
		} catch (JAXBException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	} 

	public Document toDocument(Object input){
		try {
        // Create the Document
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        
        Document output = db.newDocument();

        // Marshal the Object to a Document
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(input, output);
        
        return output;
        
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public Source toJAXBSource(Object input) {
		// TODO Auto-generated method stub
		try {
			return new JAXBSource(context, input);
		} catch (JAXBException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}	
	
	
	public JAXBContext getJAXBContext() {
		return context;
	}


	public void setJAXBContext(JAXBContext context) {
		this.context = context;
	}

    
}
