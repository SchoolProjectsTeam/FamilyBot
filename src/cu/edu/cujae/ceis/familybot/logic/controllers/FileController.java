<<<<<<< HEAD:src/cu/edu/cujae/ceis/familybot/logic/controllers/FileController.java
package cu.edu.cujae.ceis.familybot.logic.controllers;

import cu.edu.cujae.ceis.familybot.logic.core.Family;
=======
package familybot.logic.controllers;

>>>>>>> 6582d1c9101b3002a58e356c610b80e8bf569527:src/familybot/logic/controllers/FileController.java
import java.util.ArrayList;

import javax.naming.OperationNotSupportedException;

import familybot.logic.core.Family;

public interface FileController {
	public ArrayList<Family> read() throws OperationNotSupportedException;
	public void write(ArrayList<Family> array);
}
