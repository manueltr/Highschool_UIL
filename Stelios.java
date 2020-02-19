import java.util.*;
import java.io.*;

public class Stelios
{
	public static void main(String[] args) throws IOException
	{
		
		Scanner bob= new Scanner(new File("stelios.dat"));
		
		while(bob.hasNext()) {   

			// get line and split into string array
			String[] line = bob.nextLine().trim().split(" ");

			int counter= Integer.valueOf(line[0]);
			ArrayList<Nodes> vertices = new ArrayList<Nodes>();
			Character naming='A';
			
			// make corresponding nodes, add to vertices list
			for(int x=0; x<counter; x++) {
				Nodes temp = new Nodes(naming);
				vertices.add(temp);
				naming++;
			}
			
			
			// will set node connections
			for(int x=1; x < line.length; x++) {

				// cEdge is for example 'AB' , 'BC' etc
				String cEdge = line[x];
				

				for(Nodes temp: vertices){

					if(cEdge.charAt(0) == temp.getName()) {
						temp.setEdge(cEdge.charAt(1));
					}
					
					if(cEdge.charAt(1) == temp.getName()){
						temp.setEdge(cEdge.charAt(0));
					}
				}
			}
			
			
			int[] distances = new int[counter];
			int[][] matrix= new int[counter][counter];
			
			
			// makes array of distances to all other nodes, for each vertex
			for(int x = 0; x < counter; x++){

				distances = shortestPath(x, vertices);
				matrix[x] = distances;
			
			}
			
			printOutConnections(counter,matrix,vertices);
			// printOutResults(matrix);
			
	
		}
	}
	

	// BFS
	public static int[] shortestPath(int start, ArrayList<Nodes> vertices)
	{   

		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		
		int[] distanceToNodes= new int[vertices.size()];
		Arrays.fill(distanceToNodes, -1);
		distanceToNodes[start]=0;
		

		while(!queue.isEmpty())
		{
			int currentIndex = queue.poll();
			Nodes currentNode = vertices.get(currentIndex);
			
			// loops through currentNode edges
			for(Character temp: currentNode.getEdge())
			{
				// sets index Ex. A = 0, B = 1
				int nextNode = Integer.valueOf(temp)-65;


				/* 
				if an edge has not been gotten to (distance = -1) then add the current node
				distance + 1
				add that discovered node to queue, so that its edges can also be check
				*/

				if(distanceToNodes[nextNode] == -1) {
					distanceToNodes[nextNode] = distanceToNodes[currentIndex] + 1;
					queue.add(nextNode);
				}
			}
			
		}
		
		return distanceToNodes;
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