package com.scastellanos.marsrover.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.scastellanos.marsrover.exceptions.CreationException;
import com.scastellanos.marsrover.util.ErrorCodes;

/**
 * This class represent the grid in which the rove will move around. The planet.
 * It has bottoms and top coordinates in order to represent the dimensions.
 * @author scastellanos
 *
 */
public class Grid {
	
	/**
	 * It represents the minor coordinates possible of the grid.
	 */
    private Coordinates bottomLeftCoordinates;
    
    /**
     * Represents the coordinates of the top of the grid.
     */
    private Coordinates topRightCoordinates;
    
    /**
     * A map of obstacles that will be on the grid. The obstacles are in a map cause we can access it in o(1) complexity
     */
    private Map<Coordinates,Obstacle> obstaclesMap = new HashMap<Coordinates,Obstacle>();
    
	
    public Grid(Coordinates bottomLeftCoordinates, Coordinates topRightCoordinates,List<Obstacle> obstacles) throws CreationException {
    	this.bottomLeftCoordinates = bottomLeftCoordinates;
    	this.topRightCoordinates = topRightCoordinates;
    	
    	if(!validateGrid()) {
    		throw new CreationException(ErrorCodes.MR_CREATE_106.getValue(),ErrorCodes.MR_CREATE_106.getDescription());
    	}
    	
    	for (Obstacle obstacle : obstacles) {
    		validObstaclePosition(obstacle.getCoordinate());
    		this.obstaclesMap.put(obstacle.getCoordinate(), obstacle);
		}
    	
	}


    /**
	 * Validate that the grid coordinates are positive values and top coordinates are bigger than bottom
	 * @return
	 */
	private boolean validateGrid() {
		
		if(this.getBottomLeftCoordinates().getCordinateX() >=0 && this.getBottomLeftCoordinates().getCordinateY() >=0) {
			if(this.getTopRightCoordinates().getCordinateX() >= this.getBottomLeftCoordinates().getCordinateX() && this.getTopRightCoordinates().getCordinateY() >= this.getBottomLeftCoordinates().getCordinateY()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Validate if the obstacle position its inside the grid dimensions.
	 * @param obstacleCoordinate
	 * @throws CreationException
	 */
	private void validObstaclePosition(Coordinates obstacleCoordinate) throws CreationException{
			if(obstacleCoordinate!=null) {
				if(obstacleCoordinate.getCordinateX() > this.getTopRightCoordinates().getCordinateX()   ||
						obstacleCoordinate.getCordinateX() < this.getBottomLeftCoordinates().getCordinateX() ||
						obstacleCoordinate.getCordinateY() > this.getTopRightCoordinates().getCordinateY() ||
						obstacleCoordinate.getCordinateY() < this.getBottomLeftCoordinates().getCordinateY()) {
					throw new CreationException("Obstacle position outside grid");
				}
			}
	}
	
    /**
     * REturn true if there is an obstacle in the fiven coordinates.
     * @param coordinate
     * @return
     */
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


	/**
	 * @return the obstaclesMap
	 */
	public Map<Coordinates, Obstacle> getObstaclesMap() {
		return obstaclesMap;
	}


	/**
	 * @param obstaclesMap the obstaclesMap to set
	 */
	public void setObstaclesMap(Map<Coordinates, Obstacle> obstaclesMap) {
		this.obstaclesMap = obstaclesMap;
	}





}
