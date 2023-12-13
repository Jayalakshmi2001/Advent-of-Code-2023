//DAY 2 - PART 1

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Day2Part1 
{
	public static void main(String args[])
	{
		String fileName="D:\\AdventOfCode2023\\Day2Part1Input.txt";
		try
		{
			int i=1;
			int val=0;
			BufferedReader br=new BufferedReader(new FileReader(fileName));
			for(String Games:br.lines().toList())
			{
				int check=0;
				String[] game=Games.split(":");
				
				for(String sets:game[1].split(";"))
				{
					for(String cubes:sets.split(","))
					{
					    String[] cube=cubes.split(" ");
					    int count=Integer.parseInt(cube[1]);
					   
					    switch(cube[2])
					    {
					    	case  "red":
					    	{
					    		if(count>12)
					    		{
					    			check++;
					    			break;
					    		}
					    	}
					    	case  "green":
					    	{
					    		if(count>13)
					    		{
					    			check++;
					    			break;
					    		}
					    	}
					    	case  "blue":
					    	{
					    		if(count>14)
					    		{
					    			check++;
					    			break;
					    		}
					    	}
					    }
					}
				}
				if(check==0)
				{
					val=val+i;
				}
				i++;
				
			}
			System.out.println(val);
	
		}
		
		catch(IOException e)
    	{
    		e.printStackTrace();
    	}
	}

}