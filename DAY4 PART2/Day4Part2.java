
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.*;

public class Day4Part2
{
	public static void main(String args[])
	{
		String fileName="D:\\AdventOfCode2023\\DAY4 PART2\\Day4Part2Input.txt";

		/*Sample Input
		Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
		Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19
		Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1
		Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83
		Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36
		Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11*/
		
		try
		{
			
			int totalCards=0;
			BufferedReader br=new BufferedReader(new FileReader(fileName));
			
			List<Card> cards=new ArrayList<>();
			
			for(String line:br.lines().toList())
			{
				cards.add(new Card(line));
			}
			
			for(int i=0;i<cards.size();i++)
			{
				Card cd=cards.get(i);
				int totalWins=cd.getTotalWins();
				int instances=cd.getInstances();
				totalCards=totalCards+instances;
				for(int k=i+1;k<=i+totalWins && k<cards.size();k++)
				{
					cards.get(k).addCopies(instances);
				}
			}
			
			System.out.println(totalCards);
			
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}

class Card
{
	
	int instances;
	
	int winCount=0;
	
	public Card(String line)
	{
		
		List<Integer> winningNumber=new ArrayList<>();
		String[] card=line.split(":");

		String[] lists=card[1].split("\\|"); 

		for(String num:lists[0].split(" "))   //List of Winning numbers
		{
			if(num.isBlank())
				continue;
			winningNumber.add(Integer.parseInt(num));
		}
		
		for(String num:lists[1].split(" "))     //List of numbers you have
		{
			if(num.isBlank())
				continue;
			if(winningNumber.contains(Integer.parseInt(num)))
			{
				winCount++;
			
			}
		}
	}
	
	public int getTotalWins()
	{
		return winCount;
	}
	
	public void addCopies(int copies)
	{
		this.instances=this.instances+copies;
	}
	
	public int getInstances()
	{
		return instances+1;
	}
}