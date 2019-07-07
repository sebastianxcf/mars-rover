package com.scastellanos.marsrover.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grid {
	
    private Coordinates bottomLeftCoordinates = new Coordinates(0,0);
    
    private Coordinates topRightCoordinates = new Coordinates(0,0);
    
    private Map<Coordinates,Obstacle> obstaclesMap = new HashMap<Coordinates,Obstacle>();
    
	
    public Grid(Coordinates bottomLeftCoordinates, Coordinates topRightCoordinates,List<Obstacle> obstacles) {
    	
    	for (Obstacle obstacle : obstacles) {
			this.obstaclesMap.put(obstacle.getCoordinate(), obstacle);
		}
    	
    	this.bottomLeftCoordinates = bottomLeftCoordinates;
		this.topRightCoordinates = topRightCoordinates;
	}


    public boolean hasObstacle(Coordinates coordinate) {
    	return this.obstaclesMap.containsKey(coordinate);
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





}
