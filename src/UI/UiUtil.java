package UI;

import familybot.logic.core.Board;
import familybot.logic.core.Coordinate;

public class UiUtil {
	public Coordinate generateRandomCoordinate(int a, int b, Board board){
		int x = (int)(Math.random()*a);
		int y = (int)(Math.random()*b);
		System.out.println(x + " "+ y + " " + a + " " + b);
		return new Coordinate(x, y, board);		
	}
}
