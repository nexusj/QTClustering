
import mining.QTMiner;
import data.Data;
import keyboardinput.Keyboard;

import data.EmptyDataSetException;
import java.io.FileNotFoundException;
import java.io.IOException;

import mining.ClusteringRadiusException;

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		double radius =0.0;
		char choice = 'y';
		int numIter, answer;
		
		
		
		do{

//region LoopChoice			
			do {
				System.out.println("1- Load Clusters from file\n" + "2- Load Data");
				System.out.println("Choice: ");
				answer = Keyboard.readInt();

			} while (answer != 1 && answer != 2);
//endregion
			switch (answer) {
//region LoadFromFile			
			case 1:
				String filename = "";

				try {
					System.out.println("Filename: ");
					filename = Keyboard.readString();
					QTMiner qt = new QTMiner(filename);
					System.out.println(qt);
				} 
				catch (FileNotFoundException e) {
					System.out.println(e.getMessage());
				}
				catch (ClassNotFoundException e)
				{
					System.out.println(e.getMessage());
				}
				catch (IOException e)
				{
					System.out.println(e.getMessage());
				}
				break;
//endregion				
//region NewData			
			case 2:				
				Data data =new Data();
				System.out.println(data);

				System.out.println("Inserire valore di radius (>0): ");
				radius = Keyboard.readDouble();

				if(radius > 0)
				{
					QTMiner qt=new QTMiner(radius);

					try {
						numIter = qt.Compute(data);
						System.out.println("Number of clusters:"+numIter);
						System.out.println(qt.GetC().toString(data));

						System.out.println("Backing data up. Choose a name for the file: ");
						String fname = Keyboard.readString();
						System.out.println("Saving data in" + fname);

						try {
							qt.Save(fname);
						} 
						catch (FileNotFoundException e) {
							e.printStackTrace();
						}
						catch (IOException e)
						{
							e.printStackTrace();
						}
						
						System.out.println("Data successfully saved !");

					} catch ( ClusteringRadiusException e) {

						System.err.println("ERROR: an exception has been thrown during the computing : " + e.getMessage());
					}
					catch(EmptyDataSetException e)
					{
						System.err.println("ERROR: an exception has been thrown before the computing : " + e.getMessage());

					}

					
				}
				break;
//endregion				
			default:
				System.err.println("Error: Invalid choice !");
				break;
			}

			System.out.println("New execution? (y/n): ");
			choice = Keyboard.readChar();
		}while(Character.toUpperCase(choice) != 'N');

	}

}
