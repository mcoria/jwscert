package jwscert.jaxws.mtom.services;

import java.awt.Image;

import javax.activation.DataHandler;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlMimeType;

@WebService
public interface ImageInterface {
	public Image getImage(Image request);
	
	
	public @XmlMimeType("image/gif") Image getGifImage(@XmlMimeType("image/gif") Image parametro);
	
	
	public DataHandler getDataHandler(DataHandler parametro);
	
	
	//public @XmlAttachmentRef DataHandler getAttachmentRef(@XmlAttachmentRef DataHandler parametro);
}