/*
 * The MIT License
 *
 * Copyright 2022 Javier Marrero.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package io;

import cu.edu.cujae.ceis.familybot.logic.controllers.FileController;
import cu.edu.cujae.ceis.familybot.logic.controllers.FileControllerDAT;
import cu.edu.cujae.ceis.familybot.logic.core.Board;
import cu.edu.cujae.ceis.familybot.logic.core.Family;
import java.io.IOException;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Javier Marrero
 */
public class WriteRead
{
	/*
    public static void main(String[] args)
    {
        FileControllerDAT dat = new FileControllerDAT(FileController.MODE_WRITE);
        
        Board lapinga = new Board(16, 16);
        lapinga.setStart(lapinga.makePosition(0, 0));
        lapinga.setEnd(lapinga.makePosition(2, 4));
        
        Family f1 = new Family(lapinga, "Pingersons");
        Family f2 = new Family(lapinga, "Boyosons");
        ArrayList<Family> array = new ArrayList<>();
        array.add(f1);
        array.add(f2);
        
        Logger logger = LoggerFactory.getLogger(WriteRead.class);
        
        try
        {
            dat.write(array);
            
            ArrayList<Family> elRabo = (ArrayList<Family>) dat.read();
            logger.info("el rabo? {}", elRabo);
        }
        catch (IOException | ClassNotFoundException ex)
        {
            logger.error("error de entrada/salida", ex);
        }
    }
	 */

    
    
}
