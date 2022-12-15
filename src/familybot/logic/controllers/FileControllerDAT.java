package familybot.logic.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import familybot.logic.core.Family;

class FileControllerDAT extends AbstractFileController{
	
	public static void main(String[] args) {
		FileController dat = new FileControllerDAT();
		
	}
	
	public void writeTest(String[] array) {
		open(FileMode.optimalWrite);
		
	}
	
	//////////////////////////////////////////////////////////////////////
	
	public FileControllerDAT() {
		
	}

	@Override
	public Family[] read() {
		ensureDirectory();
		
		return null;
	}

	@Override
	public void write(Family[] array) {
		ensureDirectory();
		
	}
	
}
