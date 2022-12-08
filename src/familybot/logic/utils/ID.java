/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
