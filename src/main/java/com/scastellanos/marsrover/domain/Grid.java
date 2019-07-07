package com.scastellanos.marsrover.domain;

import java.util.LinkedList;
import java.util.List;

public class Grid {
	
    private Coordinates bottomLeftCoordinates = new Coordinates(0,0);
    
    private Coordinates topRightCoordinates = new Coordinates(0,0);
    
    private List<Obstacle> obstacles = new LinkedList<>();
    
	
    public Grid(Coordinates bottomLeftCoordinates, Coordinates topRightCoordinates,List<Obstacle> obstacles) {
    	
    	this.bottomLeftCoordinates = bottomLeftCoordinates;
		this.topRightCoordinates = topRightCoordinates;
	}


	/**
	 * @return the bottomLeftCoordinates
	 */
	public Coordinates getBottomLeftCoordinates() {
		return bottomLeftCoordinates;
	}

	/**
	 * @param bottomLeftCoordinates the bottomLeftCoordinates to set
	 */
	public void setBottomLeftCoordinates(Coordinates bottomLeftCoordinates) {
		this.bottomLeftCoordinates = bottomLeftCoordinates;
	}

	/**
	 * @return the topRightCoordinates
	 */
	public Coordinates getTopRightCoordinates() {
		return topRightCoordinates;
	}

	/**
	 * @param topRightCoordinates the topRightCoordinates to set
	 */
	public void setTopRightCoordinates(Coordinates topRightCoordinates) {
		this.topRightCoordinates = topRightCoordinates;
	}


	/**
	 * @return the obstacles
	 */
	public List<Obstacle> getObstacles() {
		return obstacles;
	}


	/**
	 * @param obstacles the obstacles to set
	 */
	public void setObstacles(List<Obstacle> obstacles) {
		this.obstacles = obstacles;
	}


}
