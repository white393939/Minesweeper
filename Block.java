public class Block {
    private boolean isMine;
    private boolean isShown;
    private int adjMine;
    
    public Block()
    {
        isMine = false;
        isShown = false;
        adjMine = 0;
    }

    public Block(boolean mine)
    {
        isMine = mine;
        isShown = false;
        adjMine = 0;
    }

    public boolean isShown()
    {
        return this.isShown;
    }

    public boolean isMine()
    {
        return this.isMine;
    }

    public void setAdjMine(int aMine)
    {
        if (isMine)
        {
            return;
        }
        adjMine = aMine;
    }

    public void incrimentAdjMine()
    {
        if (isMine)
        {
            return;
        }
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

    public boolean isEmpty()
    {
        return !isMine() && adjMine == 0;
    }
}