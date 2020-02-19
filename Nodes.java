import java.util.ArrayList;

public class Nodes
{
	private Character name;
	
	private ArrayList<Character> connections = new ArrayList<Character>();
	
	public Nodes(Character name)
	{
		this.name=name;
	}
	
	public Character getName()
	{
		return name;
	}
	
	public void setEdge(Character edge)
	{
		connections.add(edge);
	}
	
	public ArrayList<Character> getEdge()
	{
		return connections;
	}
	
	
	
}
