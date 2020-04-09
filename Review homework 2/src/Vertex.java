import java.util.ArrayList;

public class Vertex 
{
	private int vertexNumber;
	private ArrayList<Vertex> adjacentVertices;
	
	private Vertex()
	{
		vertexNumber = 0;
		adjacentVertices = new ArrayList<Vertex>();
	}
	
	public Vertex(int itsNumber)
	{
		vertexNumber = itsNumber;
		adjacentVertices = new ArrayList<Vertex>();
	}
	
	
	public int getVertexNumber()
	{
		return vertexNumber;
	}
	
	public void setVertexNumber(int theVertexNumber)
	{
		vertexNumber = theVertexNumber;
	}
	
	public ArrayList<Vertex> getAdjacentVertices()
	{
		return adjacentVertices;
	}
	
	public void setAdjacentVertices(ArrayList<Vertex> adjacentVerticesList)
	{
		adjacentVertices = adjacentVerticesList;
	}

	public boolean equals(Vertex theVertex)
	{
		if(vertexNumber == theVertex.getVertexNumber())
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
}
