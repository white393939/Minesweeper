import java.util.*;
import java.io.*;

public class Minesweeper
{
    private Block[][] grid;
    
    public Minesweeper()
    {
        grid = new Block[12][12];
        initialize(22);
    }

    public Minesweeper(int nRows, int nCols)
    {
        grid = new Block[nRows][nCols];
        initialize((int) (nRows * nCols * 0.15));
    }

    public Minesweeper(int nRows, int nCols, int nMines)
    {
        grid = new Block[nRows][nCols];
        initialize((int) (nMines));
    }

    public Block[][] getGrid()
    {
        return grid;
    }

    public void sweep(int row, int col)
    {
        grid[row][col].show();
        if (grid[row][col].isEmpty())
        {
            for (int i = row - 1; i < row + 2; i++)
            {
                for (int j = col - 1; j < col + 2; j++)
                {
                    if (i > -1 && j > -1 && i < grid.length && j < grid[0].length) //try
                    {
                        if (!grid[i][j].isShown())
                        {
                            sweep(i, j);
                        }
                    }
                    //catch (IndexOutOfBoundsException e){} //may be causing bugs
                }
            }
        }
    }
    
    private void initialize(int nOfMine)
    {
        int gRow = grid.length;
        int gCol = grid[0].length;
        for (int row = 0; row < gRow; row++)
        {
            for (int col = 0; col < gCol; col++)
            {
                grid[row][col] = new Block();
            }
        }
        for (int i = 0; i < nOfMine; i++)
        {
            int row ;
            int col;
            do
            {
                row = (int) (Math.random() * gRow);
                col = (int) (Math.random() * gCol);
            }
            while (grid[row][col].isMine());
            grid[row][col].setMine();
            for (int j = row - 1; j < row + 2; j++) //changing numbers of block
            {
                for (int k = col - 1; k < col + 2; k++)
                {
                    if (j > -1 && k > -1 && j < gRow && k < gCol) //try
                    {
                        grid[j][k].incrimentAdjMine();
                    }
                    //catch(IndexOutOfBoundsException e){} //may be causing bug
                }
            }
        }
    }
}