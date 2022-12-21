/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package familybot.logic.core;

import familybot.logic.exceptions.NotInitializedException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rog
 */
public class Board implements Serializable
{

    private static final long serialVersionUID = -1170328998116457244L;
    private int xSize;
    private int ySize;
    private boolean init;
    private Coordinate start;
    private Coordinate end;
    private List<Coordinate> blocked;

    public Board(int x, int y)
    {
        validateComponents(x, y);
        xSize = x;
        ySize = y;
        blocked = new ArrayList<>();
    }

    public void setStart(Coordinate start)
    {
        this.start = start;
    }

    public void setEnd(Coordinate end)
    {
        this.end = end;
    }

    public void setBlockeds(List<Coordinate> blocked)
    {
        this.blocked = blocked;
    }

    public void addBlocked(Coordinate pos)
    {
        blocked.add(pos);
    }

    private void validateComponents(int x, int y)
    {
        if (x < 0 || y < 0)
        {
            throw new IllegalArgumentException("Attempted to set a position with negative components.");
        }
    }

    private void validateInit()
    {
        if (start == null || end == null)
        {
            throw new NotInitializedException("Attempted to execute an action without initializing the board.");
        }
    }

    public boolean isEnd(Coordinate pos)
    {
        validateInit();
        return pos.equals(end);
    }

    public Coordinate startPosition()
    {
        validateInit();
        return new Coordinate(start.getX(), start.getY(), this);
    }

    public int maxSteps()
    {
        return (xSize * ySize) / 2;
    }

    public Coordinate makePosition(int x, int y)
    {
        validatePosition(x, y);
        if (blocked.contains(new Coordinate(x, y, this)))
        {
            throw new IllegalArgumentException("Attempted to generate a position in a blocked coordinate.");
        }
        return new Coordinate(x, y, this);
    }

    public int calculateDistance(Coordinate pos)
    {
        int xDist = pos.getX() - end.getX();
        int yDist = pos.getY() - end.getY();
        xDist = (xDist < 0) ? xDist * -1 : xDist;
        yDist = (yDist < 0) ? yDist * -1 : yDist;
        return xDist + yDist;
    }

    public boolean checkPosition(Integer x, Integer y)
    {
        try
        {
            validatePosition(x, y);
        }
        catch (IllegalArgumentException e)
        {
            return false;
        }
        return !blocked.contains(new Coordinate(x, y, this));
    }

    public boolean validatePosition(Integer x, Integer y)
    {
        validateComponents(x, y);
        if (x >= xSize || y >= ySize)
        {
            throw new IllegalArgumentException("Attempted to set a position out of the board's boundaries.");
        }
        return true;
    }

    public List<Coordinate> getBlocked()
    {
        return blocked;
    }

    public int getX()
    {
        return xSize;
    }

    public int getY()
    {
        return ySize;
    }

    public Coordinate getEnd()
    {
        return end;
    }

}
