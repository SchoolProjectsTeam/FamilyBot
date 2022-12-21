package cu.edu.cujae.ceis.familybot.logic.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import cu.edu.cujae.ceis.familybot.ui.utils.MessageBox;

public abstract class AbstractFileController implements FileController
{


    private final String path;
    private final String fileName;
    private final File file;

    private ObjectInputStream reader;
    private ObjectOutputStream writer;

    private int mode;

    public AbstractFileController(int mode)
    {
        path = PathConstants.APP_DIRECTORY.getAbsolutePath();
        fileName = "record.dat";
        file = new File(PathConstants.APP_DIRECTORY, fileName);

        reopen(mode);
    }

    @Override
    public void close()
    {
        try
        {
            if (reader != null)
            {
                reader.close();
            }
            if (writer != null)
            {
                writer.close();
            }
        }
        catch (IOException ex)
        {
        	System.out.println("close");
            MessageBox.showException(ex);
        }
    }

    protected void ensureRequirements()
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

    /**
     * @return the mode
     */
    public int getMode()
    {
        return mode;
    }

    @Override
    public final void reopen(int newMode)
    {
    	ensureRequirements();
        this.mode = newMode;
        try
        {
        	switch (mode) {
			case 1: {
				if(reader != null)
					reader.close();
				reader = new ObjectInputStream(new FileInputStream(file)); break;
			}
			case 2: {
				if(writer != null)
					writer.close();
				writer = new ObjectOutputStream(new FileOutputStream(file)); break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + mode);
			}
        }
        catch (IOException ex)
        {
            System.out.println("reopen");
        }
    }

    /**
     * @return the reader
     */
    public ObjectInputStream getReader()
    {
        return reader;
    }

    /**
     * @return the writer
     */
    public ObjectOutputStream getWriter()
    {
        return writer;
    }

    /**
     * @return the file
     */
    public File getFile()
    {
        return file;
    }

    /**
     * @return the fileName
     */
    public String getFileName()
    {
        return fileName;
    }

    /**
     * @return the path
     */
    public String getPath()
    {
        return path;
    }

}
