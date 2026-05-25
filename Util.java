public class Util
{
    public static boolean isValid(Minesweeper m, int row, int col)
    {
        int mRow = m.getNRows();
        int mCol = m.getNCols();
        if (row >= 0 && row < mRow && col >= 0 && col < mCol)
        {
            return !m.getBlockAt(row, col).isShown();
        }
        return false;
    }
}