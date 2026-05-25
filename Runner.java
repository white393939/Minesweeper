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
            System.out.println("input two positive non-zero integers for grid size");
            iRow = scan.nextInt();
            iCol = scan.nextInt();
        }
        while (iRow <= 0 || iCol <= 0);
        Minesweeper m = new Minesweeper(iRow, iCol); //settingup game
        while(!MinesweeperDisplayer.ending())
        {
            MinesweeperDisplayer.printGrid(m);
            int row = scan.nextInt();
            int col = scan.nextInt();
            if (Util.isValid(m, row, col)) //checking for indexOutOfBounds and already shown block
            {
                m.sweep(row, col);
            }
            else
            {
                System.out.println("index invalid");
            }
        } //still taking one input before ending
        System.out.println("game over");
    }
}