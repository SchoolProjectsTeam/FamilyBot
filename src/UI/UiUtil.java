package UI;

import familybot.logic.core.Board;
import familybot.logic.core.Coordinate;
import javax.swing.JPanel;

public class UiUtil
{

    public Coordinate generateRandomCoordinate(int a, int b, Board board)
    {
        int x = (int) (Math.random() * a);
        int y = (int) (Math.random() * b);
        return board.makePosition(x, y);
    }

    public void updateInterface(JPanel contentPane)
    {
        contentPane.updateUI();
    }
}
