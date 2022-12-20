package familybot.logic.controllers;

import java.util.ArrayList;

import familybot.logic.core.Family;

public interface FileController {
	public ArrayList<Family> read();
	public void write(ArrayList<Family> array);
}
