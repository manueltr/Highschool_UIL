import java.util.*;
import java.io.*;

public class Stelios
{
	public static void main(String[] args) throws IOException
	{
		Scanner bob= new Scanner(new File("stelios.dat"));
		
		while(bob.hasNext())
		{
			String[] line = bob.nextLine().trim().split(" ");
			int counter= Integer.valueOf(line[0]);
			ArrayList<Nodes> vertices = new ArrayList<Nodes>();
			Character naming='A';
			
			//////////////////// makes nodes;-
			for(int x=0; x<counter; x++) 
			{
				Nodes temp = new Nodes(naming);
				vertices.add(temp);
				naming++;
			}
			/////////////////////
			
			///////////////////////will set connecting nodes
			for(int x=1; x<line.length;x++)
			{
				String cEdge = line[x];
				
				for(Nodes temp: vertices)
				{
					if(cEdge.charAt(0)==temp.getName())
					{
						temp.setEdge(cEdge.charAt(1));
					}
					
					if(cEdge.charAt(1)==temp.getName())
					{
						temp.setEdge(cEdge.charAt(0));
					}
				}
			}
			/////////////////////////////////////////////////
			
			
			
			int[] cLine = new int[counter];
			int[][] matrix= new int[counter][counter];
					
			for(int x=0;x<counter;x++)
			{
				
				cLine = shortestPath(x,vertices);
				
				for(int z=0; z<counter;z++)
				{
					matrix[x][z]=cLine[z];
				}
			}
			
			printOutConnections(counter,matrix,vertices);
			/*printOutResults(matrix);*/
			
	
		}
	}
	
	public static int[] shortestPath(int start, ArrayList<Nodes> vertices)
	{
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		
		
		
		int[] distances= new int[vertices.size()];
		Arrays.fill(distances, -1);
		distances[start]=0;
		
		while(!queue.isEmpty())
		{
			int currentNode=queue.poll();
			Nodes cNode= vertices.get(currentNode);
			
			for(Character temp: cNode.getEdge())
			{
				int location = Integer.valueOf(temp)-65;
				if(distances[location]==-1)
				{
					distances[location]= distances[currentNode] + 1;
					queue.add(location);
					
				}
			}
			
		}
		
		return distances;
	}
	
	
	
	
	
	
	public static void printOutResults(int[][] matrix)
	{
		
		for(int x=0; x<matrix.length; x++)
		{
			String line="";
			for(int z=0; z<matrix.length;z++)
			{
				if(matrix[x][z]!=-1)
				line += ""+ matrix[x][z];
				else
					line+= "0";
				
				if(z!= matrix.length-1)
				{
				line+=" ";
				}
			}
			System.out.println(line);
			
			if(x==matrix.length-1)
			{
				for(int y=0; y<line.length();y++)
				{
					System.out.print("-");
				}
				System.out.println();
			}
		}
		
	}
	
	public static void printOutConnections(final int counter, final int[][] matrix, final ArrayList<Nodes> vertices)
	{
		for(final Nodes temp: vertices)
		{
			System.out.print(temp.getName() + " connections: ");
			
			ArrayList<Character> edges = new ArrayList<Character>();
			edges= temp.getEdge();
			
			for(final Character temp1: edges)
			{
				System.out.print(temp1 +" ");
			}
			
			System.out.println();
		}
		
		System.out.println();
		
		Character letter ='A';
		Character letter1 = 'A';
		for( int x=0; x<counter+1; x++)
		{
			for(int z=0; z<counter+1; z++)
			{
				if(x ==0 && z ==0)
					System.out.print("  ");
				
				if(x==0 && z>0)
				{
					System.out.print(letter + " ");
					letter++;
				}
				
				if(x>0 && z==0)
				{
					System.out.print(letter1 + " ");
					letter1++;
				}
				
				if(x>0 && z>0)
				{
					if(matrix[x-1][z-1]!=-1)
						System.out.print(matrix[x-1][z-1]+ " ");
					else
						System.out.print("0 ");
				}
				
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("/////////////////////////////////////////////////////");
		System.out.println();
		
	}
	
	
}