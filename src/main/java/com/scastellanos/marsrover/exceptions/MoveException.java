package com.scastellanos.marsrover.exceptions;

public class MoveException extends BaseException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1615145355380621354L;

	public MoveException(String message) {
		super(message);
	}
	
	public MoveException(String code,String message) {
		super(code,message);
	}
	
	@Override
    public String getMessage() {
        return super.getMessage();
    }

}
