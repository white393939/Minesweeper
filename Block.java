public class Block {
    private boolean isMine;
    private boolean isShown;
    private int adjMine;
    private boolean isFlagged;

    public Block()
    {
        isMine = false;
        isShown = false;
        isFlagged = false;
        adjMine = 0;
    }

    public boolean isShown()
    {
        return isShown;
    }

    public boolean isMine()
    {
        return isMine;
    }

    public void incrimentAdjMine()
    {
        adjMine++;
    }

    public int getAdjMine()
    {
        return adjMine;
    }

    public void show()
    {
        isShown = true;
    }
    
    public void setMine()
    {
        isMine = true;
    }

    public void flag()
    {
        isFlagged = !isFlagged;
    }

    public boolean isFlagged()
    {
        return isFlagged;
    }

    public boolean isEmpty()
    {
        return !isMine() && !isFlagged && adjMine == 0;
    }
}