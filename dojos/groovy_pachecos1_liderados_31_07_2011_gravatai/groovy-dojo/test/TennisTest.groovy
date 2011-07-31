import static org.junit.Assert.*

import org.junit.Test

class TennisTest {
	
	@Test
	def void testP10xP215(){
		Tennis tennis = new Tennis()
		tennis.playGame 0, 15
		assertEquals tennis.toString() , "P1[0]   X P2[15]  "
	}
	
	@Test
	def void testP115xP215() {
		Tennis tennis  = new Tennis()
		tennis.playGame 15 , 15
		assertEquals tennis.toString() , "P1[15]   X P2[15]  "
	}
	
	@Test
	def void testP115xP230(){
		Tennis tennis = new Tennis()
		tennis.playGame 15 , 30
		assertEquals tennis.toString(), "P1[15]   X P2[30]  "
	}
	
	@Test
	def void testP130xP230(){
		Tennis tennis = new Tennis()
		tennis.playGame 30, 30
		assertEquals tennis.toString(), "P1[30]   X P2[30]  "
	}
	
	@Test
	def void testP140xP240(){
		Tennis tennis = new Tennis()
		tennis.playGame 40, 40
		assertEquals tennis.toString(), "P1[40]   X P2[40]  "
	}
	
	@Test
	def void testAdvantageP1(){
		Tennis t = new Tennis()
		t.playGame 40, 40, 1
		assertEquals t.toString(), "P1[40] A X P2[40]  " 
	}
	
	@Test
	def void testAdvantageP2(){
		Tennis t = new Tennis()
		t.playGame 40, 40, 2
		assertEquals t.toString(), "P1[40]   X P2[40] A"
	}
	
	@Test
	def void testDifferentsPlayers(){
		Tennis t = new Tennis(player1:"Cuervo", player2:"Poletto")
		t.playGame 40, 40
		assertEquals t.toString(), "Cuervo[40]   X Poletto[40]  "
	}
	
	@Test
	def void testP1WonGame1(){
		Tennis t = new Tennis()
		def s = t.playSet 1, 0
		assertEquals s, "P1[1] X P2[0]"
	}
	
	@Test
	def void testP1DrawGameP2() {
		Tennis t = new Tennis()
		def s = t.playSet 1,1
		assertEquals s, "P1[1] X P2[1]"
	}
	
	@Test
	def void testP1WonGame2() {
		Tennis t = new Tennis();
		def s = t.playSet 2, 1
		assertEquals s, "P1[2] X P2[1]"
	}
	
}
