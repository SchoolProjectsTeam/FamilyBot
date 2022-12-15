package familybot.logic.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;

import familybot.logic.core.Family;

abstract class AbstractFileController implements FileController {

	protected enum FileMode {read, write, synchronusWrite, optimalWrite}

	protected static String path = System.getProperty("user.home") + "/Documents/CUJAE.FamilyBot";
	protected static String fileName = "record.dat";
	protected static File file = new File(path + "/" + fileName);
	protected static RandomAccessFile access;

	@Override
	public abstract Family[] read();

	@Override
	public abstract void write(Family[] array);

	protected void ensureDirectory() {
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
	}

	private String fileMode(FileMode mode) {
		String result;
		switch (mode) {
		case read: result = "r"; break;
		case write: result = "w"; break;
		case rwd: result = "rwd"; break;
		case rws: result = "rws"; break;
		default: throw new IllegalArgumentException("Unexpected value: " + mode);
		}
		return result;
	}

	protected void open(FileMode mode) {
		try {
			access = new RandomAccessFile(file, fileMode(mode));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void close() {
		try {
			access.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
