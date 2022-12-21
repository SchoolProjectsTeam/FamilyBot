package familybot.logic.controllers;

import java.util.ArrayList;

import javax.naming.OperationNotSupportedException;

import familybot.logic.core.Family;

public interface FileController {
	public ArrayList<Family> read() throws OperationNotSupportedException;
	public void write(ArrayList<Family> array);
}
