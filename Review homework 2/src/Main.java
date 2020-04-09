//Mohammed Ahmed, msa190000

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// The program will build a graph from the file data and output if the graph is connected is true/false
public class Main
{

	public static void main(String[] args) throws FileNotFoundException
	{
		System.out.println("Enter input file name: ");
		Scanner inputReader = new Scanner(System.in);
		String fileName = inputReader.nextLine();
		File inputFile = new File(fileName);

		if(inputFile.exists() == false)
		{
			System.out.println(fileName + " does not exist. Exiting program...");
			inputReader.close();
			return;
		}
		
		Graph vertexGraph = new Graph();
		
		vertexGraph.createGraph(inputFile);
		
		boolean isGraphConnected = vertexGraph.isConnected();
		
		System.out.println("The graph is connected: " + isGraphConnected);
		
		
		inputReader.close();
	}

}
