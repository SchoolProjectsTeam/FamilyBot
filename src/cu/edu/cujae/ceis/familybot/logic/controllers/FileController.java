package cu.edu.cujae.ceis.familybot.logic.controllers;

import cu.edu.cujae.ceis.familybot.logic.core.Family;
import java.util.ArrayList;
import javax.naming.OperationNotSupportedException;

public interface FileController
{

    public ArrayList<Family> read() throws OperationNotSupportedException;

    public void write(ArrayList<Family> array);
}
