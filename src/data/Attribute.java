package data;

public abstract class Attribute {
	
	protected String name;
	protected int index;
	
	public Attribute()
	{
		
	}
	
	public Attribute(String name,int index)
	{
		this.name = name;
		this.index = index;
	}
	
	String GetName()
	{
		return name;
	}

	int GetIndex()
	{
		return index;
	}
	
	public String toString()
	{
		return name;
	}
}
