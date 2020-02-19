package others;

import java.util.*;
import java.io.*;

public class Logan 
{
	public static void main(String[] args)throws IOException
	{
		Scanner bob= new Scanner(new File("others/Logan.dat"));
		int Counter= Integer.parseInt(bob.nextLine().trim());
		
		
		for(int x=0; x<Counter;x++)
		{
			int maxW= Integer.parseInt(bob.nextLine().trim());
			ArrayList<bags> Thefloor= new ArrayList<bags>();
			int numB=Integer.parseInt(bob.nextLine().trim());
			int currentW=0;
			int count=0;
			int totalvalue=0;
			int index=0;
			
			for(int z=0;z<numB;z++)
			{
				String[] line=bob.nextLine().trim().split(" ");
				bags o1= new bags(Integer.parseInt(line[0]),Integer.parseInt(line[1]),line[2]);
				Thefloor.add(o1);
			}
			
			ArrayList<bags> SortedTote= new ArrayList<bags>(Thefloor);
			ArrayList<bags> Tote= new ArrayList<bags>();
			
			Collections.sort(Thefloor);
			Collections.reverse(Thefloor);
			
			
			for(bags temp: Thefloor) 
			{
				if(currentW+temp.weight()<=maxW)
				{
					currentW+=temp.weight();
					Tote.add(temp);		
				}
			}
			
			for(int u=0;u<numB;u++)
			{
				for(bags temp: Tote)
				{
					if(SortedTote.get(index).name().equals(temp.name()))
					{
						++count;	
					}
				}
				if(count==0)
				{
					SortedTote.remove(index);
				}
				else if(count!=0)
					index++;
				count=0;
			}
			
			for(bags temp:SortedTote)
			{
				totalvalue+=temp.value();
			}
			
			System.out.println(maxW);
			System.out.println(currentW);
			System.out.println("$"+totalvalue);
				for(bags temp:SortedTote)
					System.out.println(temp.name());
				
		
		}
		
	
				
	}
}