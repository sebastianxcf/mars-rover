package com.scastellanos.marsrover.util;

public enum ErrorCodes {
	//1 System
	//2 Method
	//3 Number
	
	MR_MOVE_101("1101","Invalid move, outside grid range."),
	MR_MOVE_102("1102","Invalid move, there is an obstacle.");
	
	
	private String code;
	private final String description;
	
	

	ErrorCodes(String code,String desc) { this.code = code; this.description = desc;}

    
    public String getValue() { return code; }
    
    
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.code = value;
	}
	
	 @Override
	  public String toString() {
	    return code + ": " + description;
	  }
    

}
