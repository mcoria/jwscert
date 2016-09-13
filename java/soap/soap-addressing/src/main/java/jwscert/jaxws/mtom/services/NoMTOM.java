package jwscert.jaxws.mtom.services;

import java.io.IOException;
import java.io.InputStream;

import javax.jws.WebService;

import com.google.common.io.ByteStreams;

import jwscert.jaxws.mtom.types.Image;


@WebService(serviceName = "NoMTOM")
public class NoMTOM {
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
