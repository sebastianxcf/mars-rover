# mars-rover-wallapop

Develop an api that moves a rover around on a grid.

- You will have to provide the map size
- You will have to provide the number of obstacles and their position
- You will have to provide the initial starting point (x,y) of a rover and the direction (N,S,E,W) it is facing.
- The rover receives a character array of commands.
- Implement commands that move the rover forward/backward (f,b).
- Implement commands that turn the rover left/right (l,r).
- Implement wrapping from one edge of the grid to another. (planets are spheres after all)
- Implement obstacle detection before each move to a new square. If a given sequence of commands encounters an obstacle, the rover moves up to the last possible point and reports the obstacle.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

## Prerequisites

Java8

Docker (not mandatory)
https://docs.docker.com/install/linux/docker-ce/ubuntu/

## Configuration
Application-prod.properties for prod configuration.
Application-test.properties for test configuration.

## 3rd Party Libraries Used:
Build Tool: Apache Maven 3.1.1
Test Tool: JUnit
Jacoco for Coverage

## Installing

In order to deploy a new version of dev follow the next steps.

If you like to use docker, you can build a Docker image
```bash
mvn -U clean install docker:build
```
display the deployed images, you will find a mars-rover image
 ```bash
 docker images
 ```
Then just run the docker image

 ```bash
 docker run --rm -p 8080:8080 mars-rover
 ```
 
 Otherwise you can run just the jar

```bash
mvn -U clean install spring-boot:run
```

In all the scenarios the junits test will be executed

In order to verify the installation, make a post request using Swagger
http://localhost:8080/swagger-ui.html#/

find the endpoint 
/mars/move/


## Running the tests

In order to execute the Junit test please run : mvn test 

This will generate the coverage results at :
```target/site/jacoco/index.html```
You can see the % of coverage of all the classes.
Note that the GameServiceImpl is the core class and has a overage of 97%

## Deployment

In order to deploy a production version please run with ```active-profile = prod```

```bash 
docker run -e SPRING_PROFILES_ACTIVE=prod --rm -p 8080:8080 mars-rover  --rm -p 8080:8080 mars-rover 
```
In this case, the production version is not much different from dev, but in case that we add Data base support we can set the differents configuration in application-dev.properties and application-prod.properties files.

## Start playing

### Execute commands
Please use swagger or postman

http://localhost:8080/swagger-ui.html#/

find the endpoint 
```/mars/move

Request Body example
```bash
{
	
	"direction":"NORTH",
	"cordinateX":"0",
	"cordinateY":"0",
	
	"topRight":"10",
	"topLeft":"10",
	
	  "obstacles":[
  		{
  			"x":"4",
	  		"y":"0"
  		}
	],
	"commands":"RFFFLF"
}

 ```direction = represent the direction in which the rover start (N,E,S,W)```
 
 ```cordinateX = The x point of the grid in which the mars rover start```
 
  ```cordinateY = The y point of the grid in which the mars rover start```
  
  ```topRight = The top right length of the grid or planet```
   
  ```topLeft = The top left length of the grid or planet```
  
  
  ```obstacles = The list of obstacles objects that will putted in the grid.```
  
  ```commands = A list of characters in order to by exeuted as a commands (F = move forward, B = move backward, R= turn right, L = turn left )
  ```

As a result you will get the json bellow.
```bash
{
    "data": {
        "commands": "RFFFLF",
        "initCoordinateX": 0,
        "initCoordinateY": 0,
        "finalCoordinateX": 3,
        "finalCoordinateY": 1
    }
}
```


## Git
For new features please follow git flow.

For every now feature >
1) Create a new feature from development
``` git flow feature start feature_name```
2) Make your changes
```git flow feature finish feature_name ```
Finish feature - > Will auto merge on development
3) Push development

For UI in git client in linux I recommend [gitkraken](https://www.gitkraken.com/)
 

## Tech stack
Spring Boot with spring mvc

Spring Boot is an awesome framework to quickly build an Rest based Application.

## Design decisions

I start by identifying the entity objets that I would need, the (Plateau/Grid), Rover, Direction, Commands,Obstacle.
I starting with a very basic POJO design  then began looking at using Design Patterns and Test Driven Development.

I've implemented the Command design pattern for executing the commands that the Rover needed to execute.
https://blog.miyozinc.com/design-patterns/command-pattern/


## Notes

This is just a poc of the mars-rover. 
In another version I could persist the game using a least a in memory h2 DB and retrieve differents rovers and apply a move using it id.



## Authors

* **Sebastian Castellanos** - *Initial work* - [Sebastianxcf](https://github.com/sebastianxcf/mars-rover-wallapop)


## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
