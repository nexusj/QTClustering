package data;


import java.io.Serializable;
import java.util.Iterator;
import java.util.TreeSet;

public class DiscreteAttribute extends Attribute implements Iterable<String>, Serializable{

	
	private static final long serialVersionUID = -2098746019299863936L;
	
	private TreeSet<String> values;
	
	public DiscreteAttribute()
	{
		
	}
	
	public DiscreteAttribute(String name, int index, String values[]) {
		super(name, index);
		
		this.values = new TreeSet<String>();
		for(String s : values)
			this.values.add(s);
		
	}

	int GetNumberOfDistinctVlues()
	{
		return values.size();
	}
	
	
	@Override
	public Iterator<String> iterator() {
		
		return values.iterator();
	}
	
	
	
}
