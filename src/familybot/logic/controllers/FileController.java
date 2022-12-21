package familybot.logic.controllers;

import familybot.logic.core.Family;
import java.util.ArrayList;

public interface FileController
{

    public ArrayList<Family> read();

    public void write(ArrayList<Family> array);
}
