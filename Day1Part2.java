//DAY-1 - PART 2

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Day1Part2 
{
    public static void main(String args[]) 
    {
    	String filename="D:\\AdventOfCode2023\\Day1Part2Input.txt";
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
        int firstDigit=getFirstDigit(word);
        int lastDigit=getLastDigit(word);
        int calibrationValue=firstDigit*10 +lastDigit;
        return calibrationValue;
    }
    
    static String[] numbers= {"one","two","three","four","five","six","seven","eight","nine"};
    
    public static int getFirstDigit(String word)
    {
    	String first="";
        for(char ch:word.toCharArray())
        {
            if(Character.isDigit(ch))
            {
            	int digit=Integer.parseInt(""+ch);
                return digit;
            }
            else
            {
            	first=first+ch;
            	for(int i=0;i<numbers.length;i++)
            	{
            		String number=numbers[i];
            		if(first.contains(number))
            		{
            			return i+1;	
            		}
            	}
            }
        }
        return 0;
    }
    
    public static int getLastDigit(String word)
    {
    	String last="";
        for(int i=word.length()-1;i>=0;i--)
        {
        	char ch=word.charAt(i);
        	if(Character.isDigit(ch))
            {
            	int digit=Integer.parseInt(""+ch);
                return digit;
            }
            else
            {
            	last=ch+last;
            	for(int j=0;j<numbers.length;j++)
            	{
            		String number=numbers[j];
            		if(last.contains(number))	
            		{
            			return j+1;
            		}
            	}
            }
        }
        return 0;
    }
}