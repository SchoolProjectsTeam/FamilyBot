package familybot.logic.utils;

import java.io.Serializable;

/**
 *
 * @author Rog
 */
public class ID implements Serializable
{

    private static final long serialVersionUID = 3058474088062357084L;
    private char id;
    private int generation;

    public ID(char id, int generation)
    {
        this.id = id;
        this.generation = generation;
    }

    public char getName()
    {
        return id;
    }

    public int getGeneration()
    {
        return generation;
    }

    @Override
    public String toString()
    {
        return generation + " - " + id;
    }

}
