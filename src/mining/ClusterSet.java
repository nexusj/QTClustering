package mining;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import data.Data;


public class ClusterSet implements Iterable<Cluster>, Serializable{

	
	private static final long serialVersionUID = -2452162000508646393L;
	
	private Set<Cluster> C = new TreeSet<Cluster>();
	
	ClusterSet()
	{
		
	}
	
	void Add(Cluster c)
	{
		C.add(c);
			
	}
	
	
	public String toString()
	{
		String s="";
		int i = 0;
		
		for (Iterator<Cluster> it = C.iterator(); it.hasNext();) {
			s += ++i + it.next().toString() + "\n";
		}
		
		return s;
	}
	
	public String toString(Data data)
	{
		String s="";
		int i = 0;
		for (Iterator<Cluster> it = C.iterator(); it.hasNext();) {
			if(it != null)
				s += i++ +":" +it.next().toString(data) + "\n";
		}
		
		return s;
	}

	@Override
	public Iterator<Cluster> iterator() {
		return C.iterator();
	}
}
