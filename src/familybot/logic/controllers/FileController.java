package familybot.logic.controllers;

import familybot.logic.core.Family;

public interface FileController {
	public Family[] read();
	public void write(Family[] array);
}
