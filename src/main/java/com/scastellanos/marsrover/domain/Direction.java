package com.scastellanos.marsrover.domain;


public enum Direction {
		NORTH("N") {
			@Override
			public Direction turnLeft(){
				return WEST;
			}
	
			@Override
			public Direction turnRight(){
				return EAST;
			}
		},
		SOUTH("S") {
			@Override
			public Direction turnLeft(){
				return EAST;
			}
	
			@Override
			public Direction turnRight(){
				return WEST;
			}
		},
		EAST("E") {
			@Override
			public Direction turnLeft(){
				return NORTH;
			}
	
			@Override
			public Direction turnRight(){
				return SOUTH;
			}
		},
		WEST("W") {
			@Override
			public Direction turnLeft(){
				return SOUTH;
			}
	
			@Override
			public Direction turnRight(){
				return NORTH;
			}
		};
	
		public abstract Direction turnLeft();
	
		public abstract Direction turnRight();
	
		
		private String direction;
	
		Direction(String direction) {
			this.direction = direction;
		}


}
