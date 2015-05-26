package data;

import java.io.Serializable;

public class DiscreteItem extends Item implements Serializable{

	
	private static final long serialVersionUID = 3850193919363836044L;

	DiscreteItem(DiscreteAttribute attribute, String value)
	{
		super(attribute,value);
	}
	
	double distance(Object a)
	{
		return GetValue().equals(a) ? 0 : 1;
	}
}
