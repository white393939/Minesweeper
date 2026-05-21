import java.util.*;
import java.io.*;

public class Minesweeper
{
    private block[][] grid;
    private Scanner scan;
    
    public Minesweeper()
    {
        grid = new block[12][12];
        initialize(22);
    }

    public Minesweeper(int nRows, int nCols)
    {
        grid = new block[nRows][nCols];
        initialize((int) (nRows * nCols * 0.15));
    }

    public Minesweeper(int nRows, int nCols, int nMines)
    {
        grid = new block[nRows][nCols];
        initialize((int) (nMines));
    }

    public void sweep(int row, int col)
    {
        grid[row][col].show();
        if (grid[row][col].isEmpty())
        {
            for (int i = row - 1; i < row + 2; row++)
            {
                for (int j = col - 1; j < col + 2; j++)
                {
                    try
                    {
                        if (!grid[i][j].isShown())
                        {
                            sweep(i, j);
                        }
                    }
                    catch (IndexOutOfBoundsException e){}
                }
            }
        }
    }
    
    private initialize(int nOfMine)
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
            do
            {
                int row = (int) (Math.random() * gRow);
                int col = (int) (Math.random() * gCol);
            }
            while (grid[row][col].isMine);
            grid[row][col].setMine();
            for (int j = row - 1; j < row + 2; j++) //changing numbers of block
            {
                for (int k = col - 1; k < col + 2; k++)
                {
                    try
                    {
                        grid[row][col].incrimentAdjMine();
                    }
                    catch(IndexOutOfBoundsException e){}}
                }
            }
        }
    }
}