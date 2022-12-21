/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package familybot.logic.core;

import java.io.Serializable;

/**
 *
 * @author Rog
 */
public class Coordinate implements Serializable
{

    private static final long serialVersionUID = 498578587811232739L;
    private Integer x;
    private Integer y;
    private Board board;

    public Coordinate(int x, int y, Board board)
    {
        this.board = board;
        validate(x, y);
        this.x = x;
        this.y = y;
    }

    public void validate(int x, int y)
    {
        board.validatePosition(x, y);
    }

    public Coordinate translate(Direction dir)
    {
        switch (dir)
        {
            case Down:
                if (board.checkPosition(this.getX(), this.getY() - 1))
                {
                    y--;
                }
                break;
            case Up:
                if (board.checkPosition(this.getX(), this.getY() + 1))
                {
                    y++;
                }
                break;
            case Left:
                if (board.checkPosition(this.getX() - 1, this.getY()))
                {
                    x--;
                }
                break;
            case Right:
                if (board.checkPosition(this.getX() + 1, this.getY()))
                {
                    x++;
                }
                break;
            default:
                throw new IllegalArgumentException("Not supported direction.");
        }
        return this;
    }

    public void restart()
    {
        this.x = board.startPosition().getX();
        this.y = board.startPosition().getY();
    }

    public Integer getX()
    {
        return x;
    }

    public Integer getY()
    {
        return y;
    }

    @Override
    public Object clone()
    {
        return new Coordinate(x, y, board);
    }

    @Override
    public boolean equals(Object obj)
    {
        Coordinate comparable = (Coordinate) obj;
        return (this.getX() == comparable.getX() && this.getY() == comparable.getY());
    }

    @Override
    public String toString()
    {
        return new String("[ " + x + " , " + y + " ]");
    }
}
