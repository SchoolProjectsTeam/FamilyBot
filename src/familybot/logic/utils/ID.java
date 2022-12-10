
package familybot.logic.utils;

/**
 *
 * @author Rog
 */
public class ID {
    
    private char id; 
    private int generation;

    public ID(char id, int generation){
        this.id = id;
        this.generation = generation;
    }

    public char getName(){return id;}
    public int getGeneration(){return generation;}

    @Override
    public String toString(){
        return generation + " - " + id;
    }

}
