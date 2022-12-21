package cu.edu.cujae.ceis.familybot.logic.controllers;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import cu.edu.cujae.ceis.familybot.logic.core.Family;

public class FileControllerDAT {
	
	private final String path = PathConstants.APP_DIRECTORY.getAbsolutePath();;
    private final String fileName = "data.dat";
    private final File file;

    public FileControllerDAT()
    {
        file = new File(PathConstants.APP_DIRECTORY, fileName);
    }

    @SuppressWarnings("unchecked")
	public List<Family> read(){
    	ensureRequirements();
    	List<Family> array = new ArrayList<>();
    	
    	ObjectInputStream reader;
		try {
			reader = new ObjectInputStream(new FileInputStream(file));
			array = (List<Family>)reader.readObject();
			reader.close();
		} catch (EOFException e) {
			//
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	
    	return array;
    }

    public void write(List<Family> array) {
        ensureRequirements();
        
        try {
			ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file));
			writer.writeObject(array);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private void ensureRequirements()
    {
        File directory = new File(path);
        if (!directory.exists())
        {
            directory.mkdirs();
        }
        if (!file.exists())
        {
            try
            {
                file.createNewFile();
            }
            catch (IOException e)
            {
            	System.out.println("requirements");
            }
        }
    }
}
