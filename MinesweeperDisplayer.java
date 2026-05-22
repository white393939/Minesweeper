public class MinesweeperDisplayer
{
    private static final String hide = "▣";
    private static final String empty = "□";
    private static final String mine = "*";
    private static final String space = " ";
    private static boolean end = false;

    public static void printGrid(Block[][] grid)
    {
        for (Block[] row : grid)
        {
            for (Block b : row)
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

    public static boolean ending()
    {
        return end;
    }
}