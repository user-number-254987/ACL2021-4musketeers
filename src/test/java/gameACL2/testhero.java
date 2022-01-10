package gameACL2;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import ensem.gameACL2.Hero;
import ensem.gameACL2.Maze;
import ensem.gameACL2.Move;
import ensem.gameACL2.MoveDirection;

public class testhero {

	@Test
	public void testposx() {
		Hero hero = new Hero(0,0);
		assertEquals(hero.getPosX(),0,0.000001);
	}
	@Test
	public void testposy() {
		Hero hero = new Hero(0,0);
		assertEquals(hero.getPosY(),0,0.000001);
	}
	@Test
	public void testdeplacementenhaut() throws FileNotFoundException {
		Hero hero = new Hero(2,2);
		Maze maze = new Maze("src/test/java/gameACL2/text");
		Move pos1 = hero.getNextMove(MoveDirection.UP);
		boolean state=	(pos1.getX()==2) && (pos1.getY()==1) && 
				(maze.isMoveValid(pos1.getX(),pos1.getY()));
		assertEquals(state,true);
		
	}
	@Test
	public void testdeplacementenbas() throws FileNotFoundException {
		Hero hero = new Hero(0,0);
		Maze maze = new Maze("src/test/java/gameACL2/text");
		Move pos1 = hero.getNextMove(MoveDirection.DOWN);
		boolean state=	(pos1.getX()==0) && (pos1.getY()==1) && 
				(maze.isMoveValid(pos1.getX(),pos1.getY()));
		
		assertEquals(state,true);
		
	}
	
	@Test
	public void testdeplacementagauches() throws FileNotFoundException {
		Hero hero = new Hero(2,2);
		Maze maze = new Maze("src/test/java/gameACL2/text");
		Move pos1 = hero.getNextMove(MoveDirection.LEFT);
		boolean state=	(pos1.getX()==1) && (pos1.getY()==2) && 
				(maze.isMoveValid(pos1.getX(),pos1.getY()));
		assertEquals(state,true);
		
	}
	@Test
	public void testdeplacementadroites() throws FileNotFoundException {
		Hero hero = new Hero(2,2);
		Maze maze = new Maze("src/test/java/gameACL2/text");
		Move pos1 = hero.getNextMove(MoveDirection.RIGHT);
		boolean state=	(pos1.getX()==3) && (pos1.getY()==2) && 
				(maze.isMoveValid(pos1.getX(),pos1.getY()));
		assertEquals(state,true);
		
	}
	@Test
	public void testdeplacementadroite() {
		Hero hero = new Hero(1,1);
		Move pos1 = hero.getNextMove(MoveDirection.RIGHT);
		assertEquals(pos1.getX(),2,0.0001);
		assertEquals(pos1.getY(),1,0.0001);	

}}
