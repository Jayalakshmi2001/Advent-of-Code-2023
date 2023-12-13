//DAY 2 - PART 2

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Day2Part2
{
	public static void main(String args[])
	{
		String fileName="D:\\AdventOfCode2023\\Day2Part2Input.txt";
		try
		{
			int sum=0;
			BufferedReader br=new BufferedReader(new FileReader(fileName));
			for(String Games:br.lines().toList())
			{
				int power=0;
				int maxRed=0;
				int maxBlue=0;
				int maxGreen=0;
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
					    		
					    		if(count>maxRed)
					    		{
					    			maxRed=count;
					    		}
					    		break;
					    	}
					    	case  "green":
					    	{
					    		if(count>maxGreen)
					    		{
					    			maxGreen=count;
					    		}
					    		break;
					    	}
					    	case  "blue":
					    	{
					    	
					    		if(count>maxBlue)
					    		{
					    			maxBlue=count;
					    		}
					    		break;
					    	}
					    }
					}
				}
				power=maxRed*maxGreen*maxBlue;
				sum=sum+power;
		
			}
			
			System.out.println(sum);
	
		}
		
		catch(IOException e)
    	{
    		e.printStackTrace();
    	}
	}

}