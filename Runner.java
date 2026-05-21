import java.util.Scanner;
public class Runner
{
   public static void start()
    {
        Scanner scan = new Scanner(System.in);
        int iRow = scan.nextInt();
        int iCol = scan.nextInt();
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