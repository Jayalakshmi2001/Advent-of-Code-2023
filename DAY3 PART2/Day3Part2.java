
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Day3Part2  
{
	
public static void main(String[] args) 
	{
		
		String fileName="D:\\AdventOfCode2023\\DAY3 PART2\\Day3Part2Input.txt";
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
				num.findGears(symbol);
			}
			
			for(int i=0;i<list.size();i++)
			{
				for(int j=i+1;j<list.size();j++)
				{
					sum=sum+list.get(i).findGearRatio(list.get(j));
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
	
	class Gear
	{
		int x;
		int y;
		
		public Gear(int x,int y)
		{
			this.x=x;
			this.y=y;
		}
	}

	private List<Gear> Gears=new ArrayList<>();
	
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
	
	public void findGears(int[] map)
	{
		for(int x=xStart;x<=xEnd;x++)
		{
			if(map[y*150+(x+1)]==7)
				Gears.add(new Gear(x+1,y));
			if(x>0 && map[y*150+(x-1)]==7)
				Gears.add(new Gear(x-1,y));
			if(map[(y+1)*150+x]==7)
				Gears.add(new Gear(x,y+1));
			if(x>0 && map[(y+1)*150+(x-1)]==7)
				Gears.add(new Gear(x-1,y+1));
			if(map[(y+1)*150+(x+1)]==7)
				Gears.add(new Gear(x+1,y+1));
			if(y>0 && map[(y-1)*150+x]==7)
				Gears.add(new Gear(x,y-1));
			if(y>0 && x>0 && map[(y-1)*150+(x-1)]==7)
				Gears.add(new Gear(x-1,y-1));
 			if(y>0 && map[(y-1)*150+(x+1)]==7)
				Gears.add(new Gear(x+1,y-1));
		}
	}
	
	public int findGearRatio(NumberPosition numPos)
	{
		int gearRatio=0;
		for(Gear gear1:Gears)
		{
			for(Gear gear2:numPos.Gears)
			{
				if(gear1.x==gear2.x && gear1.y==gear2.y)
				{
					gearRatio=this.getPartNumber()*numPos.getPartNumber();
				}
			}
		}
		return gearRatio;
	}
					
	public int getPartNumber()
	{
		return partNumber;
	}
}


