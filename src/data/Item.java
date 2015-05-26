package data;

import java.io.Serializable;

public abstract class Item implements Serializable{

	
	private static final long serialVersionUID = -3748018809004483299L;
	
	protected Attribute attribute;
	protected Object value;
	
	Item(Attribute attribute, Object value)
	{
		this.attribute = attribute;
		this.value = value;
	}
	
	Attribute GetAttribute()
	{
		return attribute;
	}
	
	Object GetValue()
	{
		return value;
	}
	
	public String toString()
	{
		return value.toString();
	}
	
	abstract double distance(Object a);
}
