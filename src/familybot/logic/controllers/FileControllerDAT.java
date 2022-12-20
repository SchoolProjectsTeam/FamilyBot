package familybot.logic.controllers;

import java.io.IOException;
import java.util.ArrayList;

import familybot.logic.core.Family;

class FileControllerDAT extends AbstractFileController{
	
	public FileControllerDAT() {
		super();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Family> read() {
		ensureRequirements();
		ArrayList<Family> content = null;
		
		try {
			content = (ArrayList<Family>)reader.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return content;
	}

	@Override
	public void write(ArrayList<Family> array) {
		ensureRequirements();
		try {
			writer.writeObject(array);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
