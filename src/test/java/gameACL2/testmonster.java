package gameACL2;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ensem.gameACL2.Hero;
import ensem.gameACL2.Monster;

class testmonster {

	@Test
	public void testgetposX() {
		Monster monster = new Monster(0,0);
		assertEquals(monster.getPosX(),0,0.000001);
	}
	public void testposY() {
		Monster monster = new Monster(0,0);
		assertEquals(monster.getPosY(),0,0.000001);
	}
	}


