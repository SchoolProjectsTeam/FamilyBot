package cu.edu.cujae.ceis.familybot.logic.controllers;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cu.edu.cujae.ceis.familybot.logic.core.Family;

import cu.edu.cujae.ceis.familybot.logic.core.Robot;


public class FileControllerSCSV{

	String path = PathConstants.APP_DIRECTORY.getAbsolutePath();
	String fileName = "data.csv";
	File file = new File(PathConstants.APP_DIRECTORY, fileName);

	public void write(ArrayList<Family> array) {
		ensureRequirements();
		try {
			FileWriter csv = new FileWriter(file);
			StringBuilder line = new StringBuilder();
			for(Family fam : array) {
				line.append("Nombre de la Familia," + fam.getFrindlyID() + "\n");
				csv.write(line.toString());
				line = new StringBuilder();
				line.append("Promedio de Pasos," + fam.getRecord().getAverage() + "\n");
				csv.write(line.toString());
				line = new StringBuilder();
				line.append("Mejor Camino," + fam.getRecord().getLastGeneration().get(0).getMoveRecord() + "\n");
				csv.write(line.toString());
				for(int i = 0; i < 50; i++) {
					List<Robot> robots = fam.getRecord().getGeneration(i);
					System.out.println(robots.get(0).getMoveRecord());
					line = new StringBuilder();
					line.append("Generación," + i + "\n");
					csv.write(line.toString());
					line = new StringBuilder();
					line.append("Robot ID,Lista de Pasos\n");
					csv.write(line.toString());
					for(int j = 0; j < 10; j++) {
						System.out.println(robots.get(j).getID());
						line = new StringBuilder();
						line.append(robots.get(j).getID() + "," + robots.get(j).getMoveRecord() + "\n");
						csv.write(line.toString());
					}
				}
			}
			csv.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void ensureRequirements()
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
            }
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
