package cu.edu.cujae.ceis.familybot.logic.controllers;

import cu.edu.cujae.ceis.familybot.logic.core.Family;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileControllerDAT extends AbstractFileController
{

    private static final Logger LOGGER = LoggerFactory.getLogger(FileControllerDAT.class);

    public FileControllerDAT(int mode)
    {
        super(mode);
    }

    @Override
    public List<Family> read() throws IOException, ClassNotFoundException
    {
        ensureRequirements();
        reopen(MODE_READ);
        @SuppressWarnings ("unchecked")
        ArrayList<Family> content = (ArrayList<Family>) getReader().readObject();
        close();

        return content;
    }

    @Override
    public void write(List<Family> array) throws IOException
    {
        ensureRequirements();
        reopen(MODE_WRITE);

        ArrayList<Family> clone = new ArrayList<>(array);
        getWriter().writeObject(clone);

        close();
    }
}
