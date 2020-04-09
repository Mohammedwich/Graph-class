//Mohammed Ahmed, msa190000

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Graph
{
	private ArrayList<Vertex> vertexList;
	private int currentSize;
	private int maxSize;
	
	public Graph()
	{
		vertexList = new ArrayList<Vertex>();
		currentSize = 0;
		maxSize = 10;
	}
	
	public Graph(int theSize)
	{
		vertexList = new ArrayList<Vertex>(theSize);
		currentSize = 0;
		maxSize = theSize;
	}
	
	public boolean isEmpty()
	{
		if(currentSize == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void createGraph(File inputFile) throws FileNotFoundException
	{
		Scanner fileReader = new Scanner(inputFile);
		
		String numberOfEntriesString = fileReader.nextLine();
		int numberOfEntries = Integer.parseInt(numberOfEntriesString);
		
		if(numberOfEntries > maxSize)
		{
			System.out.println("Too many entries. Data will not be extracted. Max size is " + maxSize);
			fileReader.close();
			return;
		}
		
		while(fileReader.hasNextLine())
		{
			String currentLine = fileReader.nextLine();
			Scanner lineReader = new Scanner(currentLine);
			
			int vertexNumber = Integer.parseInt(lineReader.next()); //Pick the vertex out	
			Vertex tempVertex = new Vertex(vertexNumber); //create the vertex
			ArrayList<Vertex> adjacentVerticesList = new ArrayList<Vertex>(); // will hold vertices adjacent to the vertex
			
			// fill the adjacentVerticesList
			while(lineReader.hasNext())
			{
				int adjacentVertex = Integer.parseInt(lineReader.next());
				adjacentVerticesList.add(new Vertex(adjacentVertex) );
			}
			
			tempVertex.setAdjacentVertices(adjacentVerticesList); // attach its list of adjacent vertices
			
			//add the vertex to this graph's list of vertices
			vertexList.add(tempVertex);
			++currentSize;
			
			lineReader.close();
		}
		
		fileReader.close();
	} // createGraph() end
	
	
	//Perform a depth-first search and see if all vertices were visited. If yes return true, if not, return false
	public boolean isConnected()
	{
		if(vertexList.isEmpty() == true)
		{
			System.out.println("The function Graph.isConnected() returned false because the graph vertex list is empty.");
			return false;
		}
		
		ArrayList<Vertex> visitedVertices = new ArrayList<Vertex>();
		Stack<Vertex> theStack = new Stack<Vertex>();
		
		
		theStack.push(vertexList.get(0)); //position zero holds vertex 1
		
		while(theStack.isEmpty() == false)
		{
			Vertex currentVertex = theStack.pop();
			
			// if the vertex was not previously visited, add it to the visitedList and push all its neighbors to the stack
			if( visitedVertices.contains(currentVertex) == false)
			{
				visitedVertices.add(currentVertex);
				
				ArrayList<Vertex> adjacentList = currentVertex.getAdjacentVertices();
				
				for(int i = 0; i < adjacentList.size(); ++i)
				{
					int index = adjacentList.get(i).getVertexNumber() - 1;
					theStack.push(vertexList.get(index));
				}
			}
		}
		
		// set this flag to true. 
		boolean allVisited = true;
		// If any of the vertices in this graph is not in the list visitedVertices, set the flag to false
		for(int i = 0; i < vertexList.size(); ++i)
		{
			if(visitedVertices.contains(vertexList.get(i)) == false)
			{
				allVisited = false;
			}
		}
		
		return allVisited;
	}
	
}
