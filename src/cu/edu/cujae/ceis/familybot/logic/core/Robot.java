package cu.edu.cujae.ceis.familybot.logic.core;

import cu.edu.cujae.ceis.familybot.logic.utils.DirectionMaker;
import cu.edu.cujae.ceis.familybot.logic.utils.ID;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Robot implements Cloneable, Serializable
{

    private static final long serialVersionUID = -1144261484009192695L;
    private Coordinate position;
    private ID id;
    private List<Coordinate> path;
    private List<Direction> moveRecord;
    private Queue<Direction> movements;
    private boolean ended;

    public Robot(Board map, ID id)
    {
        this.id = id;
        position = map.startPosition();
        path = new LinkedList<Coordinate>();
        path.add((Coordinate) position.clone());
        movements = new LinkedList<>();
        for (int i = 0; i < map.maxSteps(); i++)
        {
            movements.add(DirectionMaker.get());
        }
        moveRecord = new ArrayList<Direction>(movements.size());
        for (Direction dir : movements)
        {
            moveRecord.add(dir);
        }
        ended = false;
    }

    public Robot(Board map, ID id, Robot mother, Robot father)
    {
        position = map.startPosition();
        this.id = id;
        path = new LinkedList<Coordinate>();
        path.add(position);
        movements = new LinkedList<Direction>();
        for (int i = 0; i < map.maxSteps(); i++)
        {
            Direction a = DirectionMaker.get(father.getMoveRecord().get(i), mother.getMoveRecord().get(i));
            movements.add(a);
        }
        moveRecord = new ArrayList<Direction>(movements.size());
        for (Direction dir : movements)
        {
            moveRecord.add(dir);
        }
        ended = false;
    }

    @SuppressWarnings ("unchecked")
    public void restart()
    {
        this.position.restart();
        this.movements.clear();
        this.movements.addAll(moveRecord);
        path = new LinkedList<Coordinate>();
        path.add(position);
        ended = false;
    }

    public boolean walkStep()
    {
        Coordinate pastPosition = (Coordinate) position.clone();
        Direction next = movements.poll();
        if (next == null)
        {
            return false;
        }
        else
        {
            position.translate(next);
            path.add((Coordinate) position.clone());
        }
        return true;
    }

    public Coordinate getPosition()
    {
        return position;
    }

    public List<Coordinate> getPath()
    {
        return path;
    }

    public boolean isWinner()
    {
        return ended;
    }

    public void setWinner()
    {
        this.ended = true;
    }

    public ID getID()
    {
        return id;
    }

    public List<Direction> getMoveRecord()
    {
        return this.moveRecord;
    }

}
