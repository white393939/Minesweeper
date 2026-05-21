public MinesweeperDisplayer
{
    private static final String hide = "▣";
    private static final String empty = "□";
    private static final String mine = "*";
    private static final String space = " ";
    private static boolean end = false;

    public static void printBoard(block[][] grid)
    {
        for (block[] row : grid)
        {
            for (block b : row)
            {
                String out;
                if (b.isShown())
                {
                    if (b.isMine())
                    {
                        out = mine;
                        end = false;
                    }
                    else if (b.isEmpty())
                    {
                        out = empty;
                    }
                    else
                    {
                        out = b.getAdjMine();
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

    public boolean ending()
    {
        return end;
    }
}