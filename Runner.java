public class Runner
{
   public static void start()
    {
        scan = new Scanner(System.in);
        int iRow = scan.next();
        int iCol = scan.next();
        Minesweeper m = new Minesweeper(iRow, iCol);
        do
        {
            int row = scan.nextInt();
            int col = scan.nextInt();
            m.sweep(row, col);
            MinesweeperDisplayer.printBoard();
        }
        while(!MinesweeperDisplayer.ending());
    }
}