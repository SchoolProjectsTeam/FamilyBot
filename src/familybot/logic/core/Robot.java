package familybot.logic.core;

import familybot.logic.utils.DirectionMaker;
import familybot.logic.utils.ID;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Robot {
    private Coordinate position;
    private ID id;
    private List<Coordinate> path;
    private List<Direction> moveRecord;
    private Queue<Direction> movements;
    private boolean ended;
    
    public Robot(Board map, ID id){
        this.id = id;
        position = map.startPosition();
        path = new LinkedList<>();
        path.add(position);
        movements = new LinkedList<>();
        for(int i = 0; i < map.maxSteps(); i++){
            movements.add(DirectionMaker.get());
        }
        moveRecord = new ArrayList<>(movements);
        ended = false;
    }
    
    public Robot(Board map, ID id, Robot father, Robot mother){
        this.id = id;
        position = map.startPosition();
        path = new LinkedList<>();
        path.add(position);
        movements = new LinkedList<>();
        for(int i = 0; i < map.maxSteps(); i++){
            movements.add(DirectionMaker.get(father.moveRecord.get(i), mother.moveRecord.get(i)));
        }
        ended = false;
    }
    
    public boolean walkStep(){
        Direction next = movements.poll();
        if(next == null){
            return false;
        }
        if(!position.equals(position.translate(next))){
            path.add(position);
        }
        return true;
    }
    
    public Coordinate getPosition(){return position;}
    public List<Coordinate> getPath(){return path;}
    public boolean isWinner(){return ended;}
    public void setWinner(){this.ended = true;}
    public ID getID(){return id;}
}
