package edu.vt.cs5044;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.vt.cs5044.tetris.Board;

public class TetrisAITest {

	@Test
	public void testAverageHeightB1() {
		Board board = new Board();
		TetrisAI tai = new TetrisAI();
		assertEquals(0,tai.getAverageColumnHeight(board));
	}
	
	@Test
	public void testAverageHeightB2() {
		Board board = new Board("##########");
		TetrisAI tai = new TetrisAI();
		assertEquals(1,tai.getAverageColumnHeight(board));
	}
	
	@Test
	public void testAverageHeightB3() {
		Board board = new Board(
				"#######   ",
				"########  ",
				"######### ",
				"##########");
		TetrisAI tai = new TetrisAI();
		assertEquals(3,tai.getAverageColumnHeight(board));
	}

	@Test
	public void testAverageHeightT1() {
		Board board = new Board(
				" ##  ## # ",
				" ### # #  ",
				"######### ");
		TetrisAI tai = new TetrisAI();
		assertEquals(2,tai.getAverageColumnHeight(board));
	}

	@Test
	public void testAverageHeightT2() {
		Board board = new Board(
				"###   # ##",
				" ### ## ##",
				"## #######");
		TetrisAI tai = new TetrisAI();
		assertEquals(2,tai.getAverageColumnHeight(board));
	}
	
	@Test
	public void testAverageHeightT3() {
		Board board = new Board(
				"##  ######",
				"######  ##",
				"##  ######");
		TetrisAI tai = new TetrisAI();
		assertEquals(2,tai.getAverageColumnHeight(board));
	}
	
	@Test
	public void testAverageHeightT4() {
		Board board = new Board(
				"### ##   #",
				"### ### ##",
				"##   #####");
		TetrisAI tai = new TetrisAI();
		assertEquals(2,tai.getAverageColumnHeight(board));
	}
	
	@Test
	public void testAverageHeightT5() {
		Board board = new Board(
				"#     # # ",
				"##   ## ##",
				"### ### ##");
		TetrisAI tai = new TetrisAI();
		assertEquals(1,tai.getAverageColumnHeight(board));
	}
	
	@Test
	public void testgapcountB1() {
		Board board = new Board();
		TetrisAI tai = new TetrisAI();
		assertEquals(0,tai.getTotalGapCount(board));
	}
	
	@Test
	public void testgapcountB2() {
		Board board = new Board("##########");
		TetrisAI tai = new TetrisAI();
		assertEquals(0,tai.getTotalGapCount(board));
	}
	
	@Test
	public void testgapcountB3() {
		Board board = new Board("####### ##");
		TetrisAI tai = new TetrisAI();
		assertEquals(0,tai.getTotalGapCount(board));
	}
	
	@Test
	public void testgapcountB4() {
		Board board = new Board(
				"##########",
				"####### ##");
		TetrisAI tai = new TetrisAI();
		assertEquals(1,tai.getTotalGapCount(board));
	}
	
	@Test
	public void testgapcountT1() {
		Board board = new Board(
				" ##  ## # ",
				" ### # #  ",
				"######### ");
		TetrisAI tai = new TetrisAI();
		assertEquals(2,tai.getTotalGapCount(board));
	}

	@Test
	public void testgapcountT2() {
		Board board = new Board(
				"###   # ##",
				" ### ## ##",
				"## #######");
		TetrisAI tai = new TetrisAI();
		assertEquals(2,tai.getTotalGapCount(board));
	}
	
	@Test
	public void testgapcountT3() {
		Board board = new Board(
				"##  ######",
				"######  ##",
				"##  ######");
		TetrisAI tai = new TetrisAI();
		assertEquals(4,tai.getTotalGapCount(board));
	}
	
	@Test
	public void testgapcountT4() {
		Board board = new Board(
				"### ##   #",
				"### ### ##",
				"##   #####");
		TetrisAI tai = new TetrisAI();
		assertEquals(2,tai.getTotalGapCount(board));
	}
	
	@Test
	public void testgapcountT5() {
		Board board = new Board(
				"#     # # ",
				"##   ## ##",
				"### ### ##");
		TetrisAI tai = new TetrisAI();
		assertEquals(0,tai.getTotalGapCount(board));
	}
	
	@Test
	public void testHeightRangeB1() {
		Board board = new Board();
		TetrisAI tai = new TetrisAI();
		assertEquals(0,tai.getColumnHeightRange(board));
	}
	
	@Test
	public void testHeightRangeB2() {
		Board board = new Board("##########");
		TetrisAI tai = new TetrisAI();
		assertEquals(0,tai.getColumnHeightRange(board));
	}
	
	@Test
	public void testHeightRangeB3() {
		Board board = new Board("######## #");
		TetrisAI tai = new TetrisAI();
		assertEquals(1,tai.getColumnHeightRange(board));
	}
	
	@Test
	public void testHeightRangeB4() {
		Board board = new Board(
				"####### ##",
				"####### ##");
		TetrisAI tai = new TetrisAI();
		assertEquals(2,tai.getColumnHeightRange(board));
	}
	
	@Test
	public void testHeightRangeB5() {
		Board board = new Board(
				"####### ##",
				"####### ##",
				"##########");
		TetrisAI tai = new TetrisAI();
		assertEquals(2,tai.getColumnHeightRange(board));
	}
	
	@Test
	public void testHeightRangeT1() {
		Board board = new Board(
				" ##  ## # ",
				" ### # #  ",
				"######### ");
		TetrisAI tai = new TetrisAI();
		assertEquals(3,tai.getColumnHeightRange(board));
	}

	@Test
	public void testHeightRangeT2() {
		Board board = new Board(
				"###   # ##",
				" ### ## ##",
				"## #######");
		TetrisAI tai = new TetrisAI();
		assertEquals(2,tai.getColumnHeightRange(board));
	}
	
	@Test
	public void testHeightRangeT3() {
		Board board = new Board(
				"##  ######",
				"######  ##",
				"##  ######");
		TetrisAI tai = new TetrisAI();
		assertEquals(1,tai.getColumnHeightRange(board));
	}
	
	@Test
	public void testHeightRangeT4() {
		Board board = new Board(
				"### ##   #",
				"### ### ##",
				"##   #####");
		TetrisAI tai = new TetrisAI();
		assertEquals(3,tai.getColumnHeightRange(board));
	}
	
	@Test
	public void testHeightRangeT5() {
		Board board = new Board(
				"#     # # ",
				"##   ## ##",
				"### ### ##");
		TetrisAI tai = new TetrisAI();
		assertEquals(3,tai.getColumnHeightRange(board));
	}
	
	@Test
	public void testHeightVariance() {
		Board board = new Board(
				"## ##    #",
				"# ##### ##",
				"#### #####");
		TetrisAI tai = new TetrisAI();
		assertEquals(6,tai.getColumnHeightVariance(board));
	}

	@Test
	public void testHeightVariance2() {
		Board board = new Board(
				"##########",
				"##########",
				"##########");
		TetrisAI tai = new TetrisAI();
		assertEquals(0,tai.getColumnHeightVariance(board));
	}
	
	@Test
	public void testHeightVariance3() {
		Board board = new Board(
				"#     #   ",
				"##   ###  ",
				"### ##### ");
		TetrisAI tai = new TetrisAI();
		assertEquals(9,tai.getColumnHeightVariance(board));
	}
	
	@Test
	public void testHeightVarianceT1() {
		Board board = new Board(
				" ##  ## # ",
				" ### # #  ",
				"######### ");
		TetrisAI tai = new TetrisAI();
		assertEquals(11,tai.getColumnHeightVariance(board));
	}

	@Test
	public void testHeightVarianceT2() {
		Board board = new Board(
				"###   # ##",
				" ### ## ##",
				"## #######");
		TetrisAI tai = new TetrisAI();
		assertEquals(8,tai.getColumnHeightVariance(board));
	}
	
	@Test
	public void testHeightVarianceT3() {
		Board board = new Board(
				"##  ######",
				"######  ##",
				"##  ######");
		TetrisAI tai = new TetrisAI();
		assertEquals(2,tai.getColumnHeightVariance(board));
	}
	
	@Test
	public void testHeightVarianceT4() {
		Board board = new Board(
				"### ##   #",
				"### ### ##",
				"##   #####");
		TetrisAI tai = new TetrisAI();
		assertEquals(10,tai.getColumnHeightVariance(board));
	}
	
	@Test
	public void testHeightVarianceT5() {
		Board board = new Board(
				"#     # # ",
				"##   ## ##",
				"### ### ##");
		TetrisAI tai = new TetrisAI();
		assertEquals(13,tai.getColumnHeightVariance(board));
	}
}
