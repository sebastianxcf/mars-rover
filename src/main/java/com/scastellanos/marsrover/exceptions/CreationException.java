package com.scastellanos.marsrover.exceptions;

public class CreationException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8350088277683636392L;

	
	
	public CreationException(String message) {
		super(message);
	}
	
	public CreationException(String code,String message) {
		super(code,message);
	}
	
	@Override
    public String getMessage() {
        return super.getMessage();
    }
}
