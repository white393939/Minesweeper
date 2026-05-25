public class MinesweeperDisplayer
{
    private static final String hide = "▣";
    private static final String empty = "□";
    private static final String mine = "*";
    private static final String space = " ";
    private static final String flag = "⚑";

    public static void printGrid(Minesweeper m)
    {
        int nOfMineLeft = m.getNumberOfMinesLeft();
        System.out.println("mine remaining: " + nOfMineLeft);
        System.out.print(space + space);
        for (int i = 0; i < m.getNCols(); i++)
        {
            System.out.print(i % 10 + space); //printing col index
        }
        System.out.println();
        for (int row = 0; row < m.getNRows(); row++)
        {
            Block[] bRow = m.getRowAt(row);
            System.out.print(row % 10 + space); //printing row index
            for (Block b : bRow)
            {
                String out;
                if (b.isFlagged())
                {
                    out = flag;
                }
                else if (b.isShown())
                {
                    if (b.isMine())
                    {
                        out = mine;
                    }
                    else if (b.isEmpty())
                    {
                        out = empty;
                    }
                    else
                    {
                        out = Integer.toString(b.getAdjMine());
                    }
                }
                else
                {
                    out = hide;
                }
                System.out.print(out + space);
            }
            System.out.println();
        }
    }
    public static void printEndingGrid(Minesweeper m)
    {
        int nOfMineLeft = m.getNumberOfMinesLeft();
        System.out.println("full grid");
        System.out.print(space + space);
        for (int i = 0; i < m.getNCols(); i++)
        {
            System.out.print(i % 10 + space); //printing col index
        }
        System.out.println();
        for (int row = 0; row < m.getNRows(); row++)
        {
            Block[] bRow = m.getRowAt(row);
            System.out.print(row % 10 + space); //printing row index
            for (Block b : bRow)
            {
                String out;
                if (b.isMine())
                {
                    out = mine;
                }
                else if (b.isEmpty())
                {
                    out = empty;
                }
                else
                {
                    out = Integer.toString(b.getAdjMine());
                }
                System.out.print(out + space);
            }
            System.out.println();
        }
    }

    public static void printIniGrid(int row, int col) //first print
    {
        System.out.print(space + space);
        for (int n = 0; n < col; n++)
        {
            System.out.print(n % 10 + space); //printing col index
        }
        System.out.println();
        for (int i = 0; i < row; i++)
        {
            System.out.print(i % 10 + space);
            for (int j = 0; j < col; j++)
            {
                System.out.print(hide + space);
            }
            System.out.println();
        }
    }
}