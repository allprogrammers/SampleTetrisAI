package edu.vt.cs5044;

import edu.vt.cs5044.tetris.AI;
import edu.vt.cs5044.tetris.Board;
import edu.vt.cs5044.tetris.Placement;
import edu.vt.cs5044.tetris.Rotation;
import edu.vt.cs5044.tetris.Shape;

public class TetrisAI implements AI {

	@Override
	public Placement findBestPlacement(Board currentBoard, Shape shape) {
		// TODO Auto-generated method stub
		//return null;
		//System.out.println(getAverageColumnHeight(currentBoard));
		return new Placement(Rotation.NONE,0);
	}

	@Override
	public int getAverageColumnHeight(Board board) {
		// TODO Auto-generated method stub
		boolean[][] boolBoard = board.getFixedBlocks();
		int[] heights = new int[Board.WIDTH];
		for (int col=0;col<Board.WIDTH;col++)
		{
			heights[col] = Board.HEIGHT;
			for (int row=Board.HEIGHT-1;row>=0;row--)
			{
				if(boolBoard[col][row])
					break;
				heights[col] -= 1;
			}
		}
		int total = 0;
		for (int col=0;col<Board.WIDTH;col++)
		{
			total += heights[col];
		}
		return total/heights.length;
	}

	@Override
	public int getColumnHeightRange(Board board) {
		// TODO Auto-generated method stub
		boolean[][] fixedboard = board.getFixedBlocks();
		int maxi;
		int mini;
		int height = 0;
		for(int row=Board.HEIGHT-1;row>=0;row--) {
			if(fixedboard[0][row])
			{
				height = row+1;
			}
		}
		maxi = height;
		mini = height;
		for (int col = 1; col < Board.WIDTH; col++) {
			height = Board.HEIGHT;
			for (int row = Board.HEIGHT-1; row >= 0 ; row--) {
				if (!fixedboard[col][row]) {
					height -= 1;
					break;
				}
			}
			if(maxi<height) maxi=height; 
			if(mini>height) mini=height;
		}
		
		return (maxi-mini);
	}

	@Override
	public int getColumnHeightVariance(Board board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalGapCount(Board board) {
		// TODO Auto-generated method stub
		boolean[][] fixedboard = board.getFixedBlocks();
		int gapcount=0;
		for (int col = 0; col < Board.WIDTH; col++) {
			boolean flag = false;
			for (int row = Board.HEIGHT-1; row >= 0 ; row--) {
				if (fixedboard[col][row]) {
					flag=true;
				}else if(flag)
				{
					gapcount += 1;
				}
				
				
			}
		}
		
		
		return gapcount;
	}

}
