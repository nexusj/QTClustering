package data;

import java.io.Serializable;

public class ContinuousItem extends Item implements Serializable{

	
	private static final long serialVersionUID = -8319086459990798579L;
	ContinuousItem(Attribute attribute, Double value) {
		super(attribute, value);
				
	}
	@Override
	double distance(Object a) {
		
		return Math.abs((double)(this.GetValue()) - (double)a);
	}

}
