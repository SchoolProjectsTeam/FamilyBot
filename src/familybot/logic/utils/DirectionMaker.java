/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package familybot.logic.utils;

import familybot.logic.core.Direction;
import java.util.Random;

/**
 *
 * @author Rog
 */
public class DirectionMaker {
    private static Random generator = new Random();

    public static Direction get() {
        Direction result;
        switch (generator.nextInt(4)) {
            case 0:
                result = Direction.Down;
                break;
            case 1:
                result = Direction.Up;
                break;
            case 2:
                result = Direction.Left;
                break;
            case 3:
                result = Direction.Right;
                break;
            default:
                result = Direction.Down;
                break;
        }
        //generator = new Random();
        return result;
    }

    public static Direction get(Direction one, Direction two) {
        return (generator.nextInt() % 2 == 0) ? one : two;
    }
}
