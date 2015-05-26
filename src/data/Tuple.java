package data;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

public class Tuple implements Serializable{

	
	private static final long serialVersionUID = -6494788828448994650L;
	private Item[] tuple;
	
	Tuple(int size)
	{
		tuple = new Item[size];
	}
	
	public int GetLength()
	{
		return tuple.length;
	}
	
	public Item Get(int i)
	{
		return tuple[i];
	}
	
	void Add(Item c, int i)
	{
		tuple[i] = c;
	}
	
	public double GetDistance(Tuple obj)
	{
		double d = 0.0;
		
		for (int i = 0; i < tuple.length; i++) {
			d += tuple[i].distance(obj.Get(i).GetValue());
		}
		
		return d;
	}
	
	public double AvgDistance(Data data, Set<Integer> clusteredData)
	{
		double p=0.0,sum=0.0,d = 0.0;
		Iterator<Integer> it = clusteredData.iterator();
		
		for (int i = 0; i < clusteredData.size(); i++) {
			d = GetDistance(data.GetItemSet(it.next().intValue()));
			sum += d;
		}
		
		p = sum / clusteredData.size();
		return p;
	}
}
