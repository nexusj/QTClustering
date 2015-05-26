package data;

import java.io.Serializable;



public class ContinuousAttribute extends Attribute implements Serializable{
	
	
	private static final long serialVersionUID = -4004206078463845503L;
	
	private double max;
	private double min;
	
	public ContinuousAttribute(String name, int index, double min, double max) {
		super(name, index);
		this.min = min;
		this.max = max;
		// TODO Auto-generated constructor stub
	}
	
	double GetScaledValue(double v)
	{
		
		return ((v-min)/(max-min));
	}
	
	

}
