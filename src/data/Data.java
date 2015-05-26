package data;


import java.util.LinkedList;
import java.util.List;

public class Data {

	private Object data[][];
	private int numberOfExamples;
	private List<Attribute> explanatorySet;
	
	public Data(){
		String outLook[] = {"Sunny","Overcast","Rain"};
		//String temperature[] = {"Hot","Mild","Cool"};
		String humidity[] = {"High","Normal"};
		String wind[] = { "Weak","Strong"};
		String playTennis[] = {"Yes","No"};
		
		data = new Object[14][5];
		explanatorySet = new LinkedList<Attribute>();
		
		numberOfExamples = 14;
		
		explanatorySet.add(new DiscreteAttribute("OutLook", 0, outLook));
		explanatorySet.add(new ContinuousAttribute("Temperature", 1,3.2,38.7));
		explanatorySet.add(new DiscreteAttribute("Humidity", 2, humidity));
		explanatorySet.add(new DiscreteAttribute("Wind", 3, wind));
		explanatorySet.add(new DiscreteAttribute("PlayTennis", 4, playTennis));
		
		
		//First row
		data[0][0] = (String)outLook[0];
		data[0][1] = new Double(30.3);
		data[0][2] = (String)humidity[0];
		data[0][3] = (String)wind[0];
		data[0][4] = (String)playTennis[1];
		
		//Second row
		data[1][0] = (String)outLook[1];
		data[1][1] = new Double (30.3);
		data[1][2] = (String)humidity[0];
		data[1][3] = (String)wind[1];
		data[1][4] = (String)playTennis[1];
		
		//Third row
		data[2][0] = (String)outLook[1];
		data[2][1] = new Double (30);
		data[2][2] = (String)humidity[0];
		data[2][3] = (String)wind[1];
		data[2][4] = (String)playTennis[0];	
		
		//Fourth row
		data[3][0] = (String)outLook[2];
		data[3][1] = new Double (13);
		data[3][2] = (String)humidity[0];
		data[3][3] = (String)wind[0];
		data[3][4] = (String)playTennis[0];	
		
		//Fifth row
		data[4][0] = (String)outLook[2];
		data[4][1] = new Double (0);
		data[4][2] = (String)humidity[1];
		data[4][3] = (String)wind[0];
		data[4][4] = (String)playTennis[0];	
		
		//Sixth row
		data[5][0] = (String)outLook[2];
		data[5][1] = new Double (0);
		data[5][2] = (String)humidity[1];
		data[5][3] = (String)wind[1];
		data[5][4] = (String)playTennis[1];
		
		//Seventh row
		data[6][0] = (String)outLook[1];
		data[6][1] = new Double (0.1);
		data[6][2] = (String)humidity[1];
		data[6][3] = (String)wind[1];
		data[6][4] = (String)playTennis[0];	
		
		//Eighth row
		data[7][0] = (String)outLook[0];
		data[7][1] = new Double (13);
		data[7][2] = (String)humidity[0];
		data[7][3] = (String)wind[0];
		data[7][4] = (String)playTennis[1];	
		
		//9th row
		data[8][0] = (String)outLook[0];
		data[8][1] = new Double (0.1);
		data[8][2] = (String)humidity[1];
		data[8][3] = (String)wind[0];
		data[8][4] = (String)playTennis[0];
		
		//10th row
		data[9][0] = (String)outLook[2];
		data[9][1] = new Double (12);
		data[9][2] = (String)humidity[1];
		data[9][3] = (String)wind[0];
		data[9][4] = (String)playTennis[0];	
		
		//11th row
		data[10][0] = (String)outLook[0];
		data[10][1] = new Double (12.5);
		data[10][2] = (String)humidity[1];
		data[10][3] = (String)wind[1];
		data[10][4] = (String)playTennis[0];	
		
		//12th row
		data[11][0] = (String)outLook[1];
		data[11][1] = new Double (12.5);
		data[11][2] = (String)humidity[0];
		data[11][3] = (String)wind[1];
		data[11][4] = (String)playTennis[0];	
		
		//13th row
		data[12][0] = (String)outLook[1];
		data[12][1] = new Double(29.21);
		data[12][2] = (String)humidity[1];
		data[12][3] = (String)wind[0];
		data[12][4] = (String)playTennis[0];	
		
		//14th row
		data[13][0] = (String)outLook[2];
		data[13][1] = new Double (12.5);
		data[13][2] = (String)humidity[0];
		data[13][3] = (String)wind[1];
		data[13][4] = (String)playTennis[1];	
		
	}
	
	public int GetNumberOfExamples()
	{
		return numberOfExamples;
	}
	
	public int GetNumberOfExplanatoryAttributes()
	{
		return explanatorySet.size();
	}
	
	List<Attribute> GetAttributeSchema()
	{
		return explanatorySet;
	}
	
	public Object GetAttributeValue(int exampleIndex, int attributeIndex)
	{
		return data[exampleIndex][attributeIndex];
	}
	
	public Tuple GetItemSet(int index)
	{
		Tuple t = new Tuple(explanatorySet.size());
		
		for (int i = 0; i < explanatorySet.size(); i++) {
			if(explanatorySet.get(i) instanceof DiscreteAttribute)
				t.Add(new DiscreteItem((DiscreteAttribute)explanatorySet.get(i),(String)data[index][i]), i);
			else
				t.Add(new ContinuousItem((ContinuousAttribute)explanatorySet.get(i),(Double)data[index][i]), i);
		}
		
		return t;
	}
	
	@Override
	public String toString()
	{
		String s="";
		
		for (int i = 0; i < data.length; i++) {
			s+=(i+1) + ": ";
			for (int j = 0; j < data[0].length; j++) {
				
				s += GetAttributeValue(i, j) + ",";
			}
			s+= "\n";
		}
		
		return s;
	}
	
}
