package cu.edu.cujae.ceis.familybot.logic.controllers;

import cu.edu.cujae.ceis.familybot.logic.core.Family;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.naming.OperationNotSupportedException;

public class FileControllerSCSV extends AbstractFileController
{

    @Override
    public ArrayList<Family> read() throws OperationNotSupportedException
    {
        throw new OperationNotSupportedException("Can't read a .csv file.");
    }

    @Override
    public void write(ArrayList<Family> array)
    {
        try
        {
            FileWriter csv = new FileWriter(file);
            StringBuilder line = new StringBuilder();
            for (Family fam : array)
            {
                line.append("Nombre de la Familia," + fam.getFrindlyID());
                csv.write(line.toString());
                line.append("Promedio de Pasos," + fam.getRecord().getAverage());
                csv.write(line.toString());
                //line.append("Mejor Camino," + fam.getRecord().getLastGeneration().get(0).getMoveRecord());

            }

        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /*
	public boolean saveCSVData(String filename) {

        boolean success = false;

        File file = new File(filename + ".csv");

        try {

            // create FileWriter object with file as parameter

            FileWriter fileWriter = new FileWriter(file);

            StringBuilder line = new StringBuilder();

            line.append("ID,CoordinateX,CoordinateY,IsStation\n");

            fileWriter.write(line.toString());

            int pos = 1;

            for (Vertex data : graph.getVerticesList()) {

                line = new StringBuilder();

                Place place = (Place) data.getInfo();

                line.append(String.valueOf(pos)).append(',');

                line.append(String.valueOf(lugar.getX())).append(',');

                line.append(String.valueOf(lugar.getY())).append(',');

                line.append(place.isStation());

                line.append("\n");

                pos++;

                fileWriter.write(line.toString());

            }

            fileWriter.close();

            success = true;

        } catch (IOException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        }

        return success;

    }

     */
}