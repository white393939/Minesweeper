import java.util.Scanner;
public class Runner
{
   public static void run()
    {
        Scanner scan = new Scanner(System.in);
        int iRow;
        int iCol;
        boolean isFlagging = false;
        do
        {
            System.out.println("input two integers for grid size, cannot be smaller than 4*4");
            iRow = scan.nextInt();
            iCol = scan.nextInt();
        }
        while (iRow < 4 || iCol < 4);

        MinesweeperDisplayer.printIniGrid(iRow, iCol); //first input
        int row = scan.nextInt();
        int col = scan.nextInt();
        while(!Util.isValid(row, col, iRow, iCol))
        {
            System.out.println("invalid index");
            row = scan.nextInt();
            col = scan.nextInt();
        }
        
        Minesweeper m = new Minesweeper(iRow, iCol, row, col); //settingup game
        m.sweep(row, col);

        while(!m.getEndStatus())
        {
            MinesweeperDisplayer.printGrid(m);
            String s = scan.next();
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