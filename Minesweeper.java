import java.util.*;
import java.io.*;

public class Minesweeper
{
    private Block[][] grid;
    private int numberOfMines;
    private int numberOfUnshownBlocks;

    public Minesweeper(int nRows, int nCols, int pRow, int pCol)
    {
        grid = new Block[nRows][nCols];
        numberOfUnshownBlocks = getSize();
        numberOfMines = (int) (nRows * nCols * 0.15);
        initialize(numberOfMines, pRow, pCol);
    }

    public Block[][] getGrid()
    {
        return grid;
    }

    public Block[] getRowAt(int row)
    {
        return grid[row];
    }

    public Block getBlockAt(int row, int col)
    {
        return grid[row][col];
    }

    public int getSize()
    {
        return grid.length * grid[0].length;
    }

    public int getNRows()
    {
        return grid.length;
    }

    public int getNCols()
    {
        return grid[0].length;
    }

    public int getNumberOfMines()
    {
        return numberOfMines;
    }

    public int getNumberOfUnshownBlocks()
    {
        return numberOfUnshownBlocks;
    }

    public int getNumberOfEmptyBlocks()
    {
        return numberOfUnshownBlocks - numberOfMines;
    }

    public void sweep(int row, int col)
    {
        grid[row][col].show();
        numberOfUnshownBlocks--;
        if (grid[row][col].isEmpty())
        {
            for (int i = row - 1; i < row + 2; i++)
            {
                for (int j = col - 1; j < col + 2; j++)
                {
                    if (i > -1 && j > -1 && i < grid.length && j < grid[0].length)
                    {
                        if (!grid[i][j].isShown())
                        {
                            sweep(i, j);
                        }
                    }
                }
            }
        }
    }

    private void initialize(int nOfMine, int pRow, int pCol)
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
        for (int i = 0; i < nOfMine; i++) //setting mines
        {
            int row;
            int col;
            do
            {
                row = (int) (Math.random() * gRow); //update option: improve mine setup algorithem
                col = (int) (Math.random() * gCol);
            }
            while (grid[row][col].isMine() || Util.isWithinAdjMineRange(row, col, pRow, pCol));
            grid[row][col].setMine();
            for (int j = row - 1; j < row + 2; j++) //changing numbers of block
            {
                for (int k = col - 1; k < col + 2; k++)
                {
                    if (j > -1 && k > -1 && j < gRow && k < gCol)
                    {
                        grid[j][k].incrimentAdjMine();
                    }
                }
            }
        }
    }
}