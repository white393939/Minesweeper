import java.util.Scanner;
public class Runner
{
   public static void run()
    {
        Scanner scan = new Scanner(System.in);
        int iRow;
        int iCol;
        do
        {
            iRow = scan.nextInt();
            iCol = scan.nextInt();
        }
        while (iRow == 0 || iCol == 0);
        Minesweeper m = new Minesweeper(iRow, iCol);
        do
        {
            MinesweeperDisplayer.printGrid(m.getGrid()); //not displaying after initial setup
            int row = scan.nextInt();
            int col = scan.nextInt();
            m.sweep(row, col);
        }
        while(!MinesweeperDisplayer.ending());
    }
}