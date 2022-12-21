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
			System.out.println("Bytes : " + reader.available());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			if(reader.available() > 0) {
				content = (ArrayList<Family>)reader.readObject();
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			content = null;
		}

		return content;
	}

	@Override
	public void write(ArrayList<Family> array) {
		ensureRequirements();
		try {
			writer.writeObject(array);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
