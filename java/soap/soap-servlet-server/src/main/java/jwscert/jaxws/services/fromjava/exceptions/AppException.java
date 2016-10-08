package jwscert.jaxws.services.fromjava.exceptions;

public class AppException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String myfield;
	
	
	public AppException(String string) {
		super(string);
		myfield = string.toUpperCase();
	}


	/**
	 * @return the myfield
	 */
	public String getMyfield() {
		return myfield;
	}


	/**
	 * @param myfield the myfield to set
	 */
	public void setMyfield(String myfield) {
		this.myfield = myfield;
	}


}
