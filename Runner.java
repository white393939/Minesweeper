import java.util.Scanner;

public class Runner
{
   public static void run()
    {
        Scanner scan = new Scanner(System.in);
        int iRow = -1;
        int iCol = -1;
        boolean isFlagging = false;
        System.out.println("input two integers for grid size, cannot be smaller than 4*4");
        do
        {
            iRow = -1;
            iCol = -1;
            String str = scan.next();
            if (Util.isInt(str))
            {
                iRow = Integer.parseInt(str);
                if (iRow < 4)
                {
                    System.out.println("grid cannot be smaller than 4*4");
                    continue;
                }
            }
            else
            {
                System.out.println("invalid input");
                continue;
            }
            str = scan.next();
            if (Util.isInt(str))
            {
                iCol = Integer.parseInt(str);
                if (iCol < 4)
                {
                    System.out.println("grid cannot be smaller than 4*4");
                    continue;
                }
            }
            else
            {
                System.out.println("invalid input");
                continue;
            }
        }
        while (iRow < 4 || iCol < 4);

        MinesweeperDisplayer.printIniGrid(iRow, iCol); //first input
        String s;
        int row;
        int col;
        do
        {
            s = scan.next();
            row = -1;
            col = -1;
           if (Util.isInt(s) && Util.isValid(Integer.parseInt(s), iRow))
            {
                row = Integer.parseInt(s);
            }
            else
            {
                if (Util.isFlagging(s))
                {
                    System.out.println("cannot flag on frist sweep");
                }
                else
                {
                    System.out.println("invalid input");
                }
                continue;
            }
            s = scan.next();
            if (Util.isInt(s) && Util.isValid(Integer.parseInt(s), iCol))
            {
                col = Integer.parseInt(s);
            }
            else
            {
                if (Util.isFlagging(s))
                {
                    System.out.println("cannot flag on frist sweep");
                }
                else
                {
                    System.out.println("invalid input");
                }
                continue;
            }
        }
        while(!Util.isValid(row, col, iRow, iCol));
        
        Minesweeper m = new Minesweeper(iRow, iCol, row, col); //settingup game
        m.sweep(row, col);

        while(!m.getEndStatus())
        {
            MinesweeperDisplayer.printGrid(m);
            s = scan.next();
            if (Util.isFlagging(s))
            {
                isFlagging = !isFlagging;
                System.out.println("Flagging: " + isFlagging);
                continue;
            }
            else if (Util.isInt(s))
            {
                row = Integer.parseInt(s);
            }
            else
            {
                System.out.println("invalid input");
                continue;
            }
            s = scan.next();
            if (Util.isInt(s))
            {
                col = Integer.parseInt(s);
            }
            else
            {
                System.out.println("invalid input");
                continue;
            }
            if (Util.isValid(m, row, col)) //checking for indexOutOfBounds and already shown square
            {
                if (isFlagging)
                {
                    m.flag(row, col);
                }
                else if(!m.getSquareAt(row, col).isFlagged())
                {
                    m.sweep(row, col);
                }
                else
                {
                    System.out.println("cannot sweep a flagged square");
                }
            }
            else
            {
                System.out.println("invalid index");
            }
        }
        MinesweeperDisplayer.printGrid(m);
        System.out.println();
        MinesweeperDisplayer.printEndingGrid(m);
        System.out.println("game over");
        scan.close();
    }
}