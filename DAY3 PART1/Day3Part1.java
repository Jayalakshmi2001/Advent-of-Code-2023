
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Day3Part1 
{
	
public static void main(String[] args) 
	{
		
		String fileName="D:\\AdventOfCode2023\\Day3Part1Input.txt";
		int[] symbol=new int[150*150];
		
		HashMap<String,Integer> specialCharacters=new HashMap<>();
		specialCharacters.put("@",1);
		specialCharacters.put("#",2);
		specialCharacters.put("$",3);
		specialCharacters.put("%",4);
		specialCharacters.put("^",5);
		specialCharacters.put("&",6);
		specialCharacters.put("*",7);
		specialCharacters.put("+",8);
		specialCharacters.put("/",9);
		specialCharacters.put("=",10);
		specialCharacters.put("-",11);
		
		try
		{
			BufferedReader br=new BufferedReader(new FileReader(fileName));
			int sum=0;
			int x=0;
			int y=0;
			
			List<NumberPosition> list=new ArrayList<>();
			NumberPosition position=null;
			
			Arrays.fill(symbol, 0);
			for(String line:br.lines().toList())
			{
				for(String c:line.split(""))
				{
					if(Character.isDigit(c.charAt(0)))
					{
						if(position==null)
						{
							position=new NumberPosition();
						}
						position.addDigit(x,y,c);
					}
					else
					{
						if(position!=null)
						{
							list.add(position);
						}
						position=null;
					}
					
					if(specialCharacters.containsKey(c))
					{
						symbol[y*150+x]=specialCharacters.get(c);
					}
					x++;
				}
				x=0;
				y++;
			}
			
			for(NumberPosition num:list)
			{
				if(num.isAdjacent(symbol))
				{
					sum=sum+num.getPartNumber();
				}
			}
			
			System.out.println(sum);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}

class NumberPosition 
{
	private int xStart=-1;
	private int xEnd=-1;
	private int y=-1;
	private int partNumber=0;
	private String number="";
	
	public void addDigit(int x,int y,String digit)
	{
		this.y=y;
		if(xStart==-1)
		{
			this.xStart=x;
		}
		this.xEnd=x;
		number=number+digit;
		partNumber=Integer.parseInt(number);
	}
	
	public boolean isAdjacent(int[] map)
	{
		for(int x=xStart;x<=xEnd;x++)
		{
			if(map[y*150+(x+1)]!=0)
				return true;
			if(x>0 && map[y*150+(x-1)]!=0)
				return true;
			if(map[(y+1)*150+x]!=0)
				return true;
			if(x>0 && map[(y+1)*150+(x-1)]!=0)
				return true;
			if(map[(y+1)*150+(x+1)]!=0)
				return true;
			if(y>0 && map[(y-1)*150+x]!=0)
				return true;
			if(y>0 && x>0 && map[(y-1)*150+(x-1)]!=0)
				return true;
 			if(y>0 && map[(y-1)*150+(x+1)]!=0)
				return true;
		}
		return false;
	}
	
	public int getPartNumber()
	{
		return partNumber;
	}
}


