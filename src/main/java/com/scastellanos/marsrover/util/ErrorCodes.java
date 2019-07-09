package com.scastellanos.marsrover.util;

public enum ErrorCodes {
	//1 System
	//2 Method
	//3 Number
	
	MR_CREATE_101("1101","Invalid direction"),
	MR_CREATE_102("1102","Invalid coordinates,out side bound"),
	MR_CREATE_103("1103","There is an obstacle in initial rover position"),
	MR_CREATE_104("1104","Negative Coordonates are not allowed"),
	MR_CREATE_105("1105","Null parser"),
	MR_CREATE_106("1106","Error creating grid,check coordinates"),
	MR_MOVE_201("1201","Invalid move, outside grid range"),
	MR_MOVE_202("1202","Invalid move, there is an obstacle in position"),
	MR_MOVE_203("1203","Invalid command,please review."),
	MR_MOVE_204("1204","Invalid state wrong direction");
	
	
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
