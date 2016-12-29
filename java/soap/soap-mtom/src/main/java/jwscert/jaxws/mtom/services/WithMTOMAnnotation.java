package jwscert.jaxws.mtom.services;

import java.awt.Image;
import java.io.IOException;

import javax.activation.DataHandler;
import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;

@WebService(endpointInterface= "jwscert.jaxws.mtom.services.ImageInterface")
@MTOM
public class WithMTOMAnnotation implements ImageInterface{
	public Image getImage(Image parametro) {
		Image result = null; 
		try {
			result = ImageIO.read(getClass().getResourceAsStream("PNG3486.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Image getGifImage(Image parametro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataHandler getDataHandler(DataHandler parametro) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	@Override
	public DataHandler getAttachmentRef(DataHandler parametro) {
		// TODO Auto-generated method stub
		return null;
	}*/
}
