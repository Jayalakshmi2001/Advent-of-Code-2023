//DAY1 PART-1

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Day1Part1 
{
    public static void main(String args[]) 
    {
    	String filename="D:\\AdventOfCode2023\\Day1Part1Input.txt";
    	try
    	{
		BufferedReader br=new BufferedReader(new FileReader(filename));
        int sum=0;
        for(String word:br.lines().toList())
        {
            sum=sum+getCalibrationValue(word);
        }
        System.out.println(sum);
    	}
    	
    	catch(IOException e)
    	{
    		e.printStackTrace();
    	}
    }
   
    
    public static int getCalibrationValue(String word)
    {
        char firstDigit=getFirstDigit(word);
        char lastDigit=getLastDigit(word);
        int calibrationValue=Integer.parseInt(""+firstDigit+lastDigit);
        return calibrationValue;
    }
    
    public static char getFirstDigit(String word)
    {
        for(char ch:word.toCharArray())
        {
            if(Character.isDigit(ch))
            {
                return ch;
            }
        }
        return 0;
    }
    
    public static char getLastDigit(String word)
    {
        for(int i=word.length()-1;i>=0;i--)
        {
            char ch=word.charAt(i);
            if(Character.isDigit(ch))
            {
                return ch;
            }
        }
        return 0;
    }
}