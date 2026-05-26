public class Util
{
    public static boolean isValid(Minesweeper m, int row, int col)
    {
        int mRow = m.getNRows();
        int mCol = m.getNCols();
        if (row >= 0 && row < mRow && col >= 0 && col < mCol)
        {
            return !m.getSquareAt(row, col).isShown();
        }
        return false;
    }

    public static boolean isValid(int row, int col, int mRow, int mCol)
    {
        return row >= 0 && row < mRow && col >= 0 && col < mCol;
    }

    public static boolean isValid(int i, int j)
    {
        return i >= 0 && i < j;
    }

    public static boolean isWithinAdjMineRange(int row, int col, int pRow, int pCol)
    {
        return row > pRow-2 && row < pRow+2 && col > pCol-2 && col < pCol+2;
    }

    public static boolean isInt(String s)
    {
        return s != null && s.matches("\\d+");
    }

    public static boolean isFlagging(String s)
    {
        return s.equals("f");
    }
}