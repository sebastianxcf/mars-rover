package com.scastellanos.marsrover.utils;

import java.util.ArrayList;
import java.util.List;

import com.scastellanos.marsrover.domain.Coordinates;
import com.scastellanos.marsrover.domain.Obstacle;
import com.scastellanos.marsrover.dto.ObstacleDTO;

/**
 * This class represent commons generic operations for all the project
 * @author scastellanos
 *
 */
public class Util {

	

	/**
	 * Convert from obstacle dto list to Obstacle business object, in order to avoid using business objects in controllers
	 * @param obstaclesParam
	 * @return
	 */
	public static List<Obstacle> convertObstacleDtoTOEntity(List<ObstacleDTO> obstaclesParam) {
		List<Obstacle> obstacles = new ArrayList();
		
		for (ObstacleDTO obstacleDto : obstaclesParam) {
			Obstacle obstacle = new Obstacle();
			Coordinates coordinate = new Coordinates(obstacleDto.getX(),obstacleDto.getY());
			obstacle.setCoordinate(coordinate);
			obstacles.add(obstacle);
		}
		return obstacles;
	}
}
