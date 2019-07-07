package com.scastellanos.marsrover.exceptions;

public class MoveException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8350088277683636392L;

	private String code;
	
	
	public MoveException(String message) {
		super(message);
	}
	
	public MoveException(String code,String message) {
		super(message);
		this.code = code;
	}
	
	@Override
    public String getMessage() {
        return super.getMessage();
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
