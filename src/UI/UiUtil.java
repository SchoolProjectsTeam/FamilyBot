package UI;

import familybot.logic.core.Board;
import familybot.logic.core.Coordinate;

public class UiUtil {
	public Coordinate generateRandomCoordinate(int a, int b, Board board){
		int x = (int)(Math.random()*a);
		int y = (int)(Math.random()*b);	
		return board.makePosition(x, y);
	}
}
