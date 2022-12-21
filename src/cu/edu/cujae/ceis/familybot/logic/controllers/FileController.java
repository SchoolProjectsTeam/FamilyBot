package cu.edu.cujae.ceis.familybot.logic.controllers;

import cu.edu.cujae.ceis.familybot.logic.core.Family;
import java.util.ArrayList;

public interface FileController
{

    public ArrayList<Family> read();

    public void write(ArrayList<Family> array);
}
