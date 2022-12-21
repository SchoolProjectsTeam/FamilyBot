package cu.edu.cujae.ceis.familybot.logic.controllers;

import cu.edu.cujae.ceis.familybot.ui.utils.MessageBox;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static cu.edu.cujae.ceis.familybot.logic.controllers.FileController.MODE_READ;

public abstract class AbstractFileController implements FileController
{

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractFileController.class);

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
            LOGGER.error("", ex);
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
                LOGGER.error("no fue posible crear el archivo.", e);
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
        this.mode = newMode;
        try
        {
            if ((mode & MODE_READ) == MODE_READ)
            {
                if (writer != null)
                {
                    writer.close();
                }
                reader = new ObjectInputStream(new FileInputStream(file));
            }
            else if ((mode & MODE_WRITE) == MODE_WRITE)
            {
                if (reader != null)
                {
                    reader.close();
                }
                writer = new ObjectOutputStream(new FileOutputStream(file));
            }
        }
        catch (IOException ex)
        {
            MessageBox.showException(ex);
            LOGGER.error("Imposible reabrir el stream", ex);
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
