package cu.edu.cujae.ceis.familybot.logic.controllers;

import cu.edu.cujae.ceis.familybot.logic.core.Family;
import java.io.IOException;
import java.util.List;

public interface FileController
{

    public static final int MODE_READ = 1;
    public static final int MODE_WRITE = 2;
    
    public void close();

    public List<Family> read() throws IOException, ClassNotFoundException;

    public void write(List<Family> array) throws IOException;

    public void reopen(int newMode);
    
}
