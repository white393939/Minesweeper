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
            System.out.println("index invalid");
            row = scan.nextInt();
            col = scan.nextInt();
        }
        
        Minesweeper m = new Minesweeper(iRow, iCol, row, col); //settingup game
        m.sweep(row, col);

        while(!MinesweeperDisplayer.ending())
        {
            MinesweeperDisplayer.printGrid(m);
            row = scan.nextInt();
            col = scan.nextInt();
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