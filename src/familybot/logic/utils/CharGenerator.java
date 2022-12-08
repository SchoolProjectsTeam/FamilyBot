/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package familybot.logic.utils;

/**
 *
 * @author Rog
 */
public class CharGenerator {
    private char character;

    public CharGenerator(){
        character = 'A';
    }

    public void restart(){
        character = 'A';
    }

    public Character get(){
        return character++;
    }
}
