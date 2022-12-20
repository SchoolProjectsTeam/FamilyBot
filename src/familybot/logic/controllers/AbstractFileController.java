package familybot.logic.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class AbstractFileController implements FileController {

	protected String path;
	protected String fileName;
	protected File file;
	
	ObjectInputStream reader;
	ObjectOutputStream writer;

	public AbstractFileController() {
		path = System.getProperty("user.home") + "/Documents/CUJAE.FamilyBot";
		fileName = "record.dat";
		file = new File(path + "/" + fileName);
	}
	
	protected void ensureRequirements() {
		File directory = new File(path);
		if(!directory.exists()) {
			directory.mkdirs();
		}
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			writer = new ObjectOutputStream(new FileOutputStream(file));
			reader = new ObjectInputStream(new FileInputStream(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
