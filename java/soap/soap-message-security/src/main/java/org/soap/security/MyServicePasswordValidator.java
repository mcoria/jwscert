package org.soap.security;

import com.sun.xml.wss.impl.callback.PasswordValidationCallback;
import com.sun.xml.wss.impl.callback.PasswordValidationCallback.PasswordValidationException;
import com.sun.xml.wss.impl.callback.PasswordValidationCallback.PasswordValidator;
import com.sun.xml.wss.impl.callback.PasswordValidationCallback.Request;

public class MyServicePasswordValidator implements PasswordValidator {

	@Override
	public boolean validate(Request request) throws PasswordValidationException {
        PasswordValidationCallback.PlainTextPasswordRequest plainTextRequest 
        = (PasswordValidationCallback.PlainTextPasswordRequest) request;
      if ("myuserid".equals(plainTextRequest.getUsername())
            && "mypassword".equals(plainTextRequest.getPassword())) {
        return true;
    
    }else{
    	throw new PasswordValidationCallback.PasswordValidationException("Invalid credentials provided. Authentication failed");
    }
    
    //return false;
	}

}
