package jwscert.jaxws.mtom.services;

import java.io.IOException;
import java.io.InputStream;

import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.MTOM;
import javax.xml.ws.soap.SOAPBinding;

import com.google.common.io.ByteStreams;

import jwscert.jaxws.mtom.types.Image;


@WebService(name = "Service")
@MTOM(enabled=true, threshold=1024)
@BindingType(value=SOAPBinding.SOAP11HTTP_MTOM_BINDING)
public class ServiceImp {
	public Image getImage() {
		Image result = new Image();
		result.setImageName("PNG3486.png");

		try {
			InputStream stream = getClass().getResourceAsStream("PNG3486.png");
			byte[] bytes = ByteStreams.toByteArray(stream);
			result.setImage(bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}
}
