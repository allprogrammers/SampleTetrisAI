package edu.vt.cs5044;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.vt.cs5044.tetris.Board;

public class TetrisAITest {

	@Test
	public void testAverageHeight() {
		Board board = new Board();
		TetrisAI tai = new TetrisAI();
		assertEquals(0,tai.getAverageColumnHeight(board));
	}

	@Test
	public void testAverageHeight2() {
		Board board = new Board("##########");
		TetrisAI tai = new TetrisAI();
		assertEquals(1,tai.getAverageColumnHeight(board));
	}
	
	@Test
	public void testAverageHeight3() {
		Board board = new Board(
				"#######   ",
				"########  ",
				"######### ",
				"##########");
		TetrisAI tai = new TetrisAI();
		assertEquals(3,tai.getAverageColumnHeight(board));
	}
	
	@Test
	public void testgapcount() {
		Board board = new Board();
		TetrisAI tai = new TetrisAI();
		assertEquals(0,tai.getTotalGapCount(board));
	}
	
	@Test
	public void testgapcount2() {
		Board board = new Board("##########");
		TetrisAI tai = new TetrisAI();
		assertEquals(0,tai.getTotalGapCount(board));
	}
	
	@Test
	public void testgapcount3() {
		Board board = new Board("####### ##");
		TetrisAI tai = new TetrisAI();
		assertEquals(0,tai.getTotalGapCount(board));
	}
	
	@Test
	public void testgapcount4() {
		Board board = new Board(
				"##########",
				"####### ##");
		TetrisAI tai = new TetrisAI();
		assertEquals(1,tai.getTotalGapCount(board));
	}
	
	@Test
	public void testHeightRange() {
		Board board = new Board();
		TetrisAI tai = new TetrisAI();
		assertEquals(0,tai.getColumnHeightRange(board));
	}
	
	@Test
	public void testHeightRange1() {
		Board board = new Board("##########");
		TetrisAI tai = new TetrisAI();
		assertEquals(0,tai.getColumnHeightRange(board));
	}
	
	@Test
	public void testHeightRange2() {
		Board board = new Board("######## #");
		TetrisAI tai = new TetrisAI();
		assertEquals(1,tai.getColumnHeightRange(board));
	}
	
	@Test
	public void testHeightRange3() {
		Board board = new Board(
				"####### ##",
				"####### ##");
		TetrisAI tai = new TetrisAI();
		assertEquals(2,tai.getColumnHeightRange(board));
	}
	
	@Test
	public void testHeightRange4() {
		Board board = new Board(
				"####### ##",
				"####### ##",
				"##########");
		TetrisAI tai = new TetrisAI();
		assertEquals(2,tai.getColumnHeightRange(board));
	}

}
