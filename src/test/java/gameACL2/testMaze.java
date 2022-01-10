package gameACL2;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import ensem.gameACL2.BoxType;
import ensem.gameACL2.Maze;

class testMaze {

	@Test
	public void testgetboxtype() throws FileNotFoundException {
		Maze maze = new Maze("src/test/java/gameACL2/text");
		assertEquals(maze.getBoxType(0,0),BoxType.WALL);
		
	}
	@Test
	public void testismovevalid() throws FileNotFoundException {
		Maze maze = new Maze("src/test/java/gameACL2/text");
		assertEquals(maze.isMoveValid(1,1),true);
		
	}
	}

