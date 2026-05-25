public class MinesweeperDisplayer
{
    private static final String hide = "▣";
    private static final String empty = "□";
    private static final String mine = "*";
    private static final String space = " ";
    private static final String flag = "⚑";
    private static boolean end = false;

    public static void printGrid(Minesweeper m)
    {
        int emptyBlocks = m.getNumberOfEmptyBlocks();
        System.out.println("empty blocks remaining: " + emptyBlocks);
        if (emptyBlocks == 0)
        {
            end = true;
        }
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
                if (b.isShown())
                {
                    if (b.isMine())
                    {
                        out = mine;
                        end = true;
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

    public static void printIniGrid(int row, int col) //first print
    {
        System.out.print(space + space);
        for (int n = 0; n < row; n++)
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

    public static boolean ending()
    {
        return end;
    }
}