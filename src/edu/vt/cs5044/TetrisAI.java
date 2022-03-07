package edu.vt.cs5044;

import edu.vt.cs5044.tetris.AI;
import edu.vt.cs5044.tetris.Board;
import edu.vt.cs5044.tetris.Placement;
import edu.vt.cs5044.tetris.Rotation;
import edu.vt.cs5044.tetris.Shape;

public class TetrisAI implements AI {
	
	private int[] BoardHeights = null;
	
	private int[] getHeights(Board board)
	{
		if(this.BoardHeights!=null)
		{
			return this.BoardHeights;
		}
		
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
		
		this.BoardHeights = heights;
		
		return heights;
	}
	
	private int getTotalCost(Board Board)
	{
		int[] weights = {4,0,8,12};
		int[] costs = {
				this.getAverageColumnHeight(Board),
				this.getColumnHeightRange(Board),
				this.getColumnHeightVariance(Board),
				this.getTotalGapCount(Board)
				};
		
		int ans = 0;
		for(int i=0;i<weights.length;i++)
		{
			ans += weights[i]*costs[i];
		}

		return ans;
	}

	@Override
	public Placement findBestPlacement(Board currentBoard, Shape shape) {
		
		Placement minPlacement = null;
		int minCost = Integer.MAX_VALUE;
		
		for(Rotation rot: shape.getValidRotationSet())
		{
			for(int col=0; col+shape.getWidth(rot) <= Board.WIDTH; col++)
			{
				Placement currentPlacement = new Placement(rot,col);
				Board nextBoard = currentBoard.getResultBoard(shape, currentPlacement);
				this.BoardHeights = null;
				int currentCost = this.getTotalCost(nextBoard);
				
				if(currentCost<minCost)
				{
					minCost = currentCost;
					minPlacement = currentPlacement;
				}
			}
		}
		
		this.BoardHeights = null;
		return minPlacement;
	}

	@Override
	public int getAverageColumnHeight(Board board) {
		int[] heights = this.getHeights(board);
		
		int total = 0;
		for (int col=0;col<Board.WIDTH;col++)
		{
			total += heights[col];
		}
		
		return total/heights.length;
	}

	@Override
	public int getColumnHeightRange(Board board) {
		int[] heights = this.getHeights(board);
		
		int maxi = heights[0];
		int mini = heights[0];
		for (int col = 1; col < Board.WIDTH; col++) 
		{
			
			if (heights[col]>maxi)
				maxi=heights[col];
			if (heights[col]<mini)
				mini=heights[col];
			
		}
		
		return (maxi-mini);
	}

	@Override
	public int getColumnHeightVariance(Board board) {

		int[] heights = this.getHeights(board);
		
		int abssum = 0;
		for (int col =1;col<Board.WIDTH;col++)
		{
			abssum += Math.abs(heights[col]-heights[col-1]);
		}
		
		return abssum;
	}

	@Override
	public int getTotalGapCount(Board board) {
		int[] heights = this.getHeights(board);
		boolean[][] boolBoard = board.getFixedBlocks();
		
		int gapcount=0;
		
		for (int col = 0; col < Board.WIDTH; col++) 
		{
			for(int row = heights[col]-1;row>=0;row--)
			{
				if (!boolBoard[col][row])
					gapcount += 1;
			}
		}
		
		return gapcount;
	}

}