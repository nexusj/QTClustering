package mining;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;











import data.Data;
import data.Tuple;


class Cluster implements  Iterable<Integer>, Comparable<Cluster>, Serializable{
	
	private static final long serialVersionUID = -5572376503861985391L;

	private Tuple centroid;

	private Set<Integer> clusteredData; 
	
	/*Cluster(){
		
	}*/

	Cluster(Tuple centroid){
		this.centroid=centroid;
		clusteredData=new HashSet<Integer>();
		
	}
		
	Tuple getCentroid(){
		return centroid;
	}
	
	//return true if the tuple is changing cluster
	boolean addData(int id){
		return clusteredData.add(id);
		
	}
	
	//verifica se una transazione è clusterizzata nell'array corrente
	int contain(int id){
		Iterator<Integer> it = clusteredData.iterator();
		Integer t = it.next();
		
		for (int i = 0; i < id; i++)
			t = it.next();
		return t.intValue();
	}
	

	//remove the tuplethat has changed the cluster
	void removeTuple(int id){
		Iterator<Integer> it = clusteredData.iterator();
		
		for (int i = 0; i < id; i++, it.next())
			
		it.remove();
		
	}
	
	int  getSize(){
		return clusteredData.size();
	}
	
	
	@Override
	public String toString(){
		String str="Centroid=(";
		for(int i=0;i<centroid.GetLength();i++)
			str+=centroid.Get(i);
		str+=")";
		return str;
		
	}
	
	


	
	public String toString(Data data){
		String str="Centroid=(";
		for(int i=0;i<centroid.GetLength();i++)
			str+=centroid.Get(i)+ " ";
		str+=")\nExamples:\n";
		
		
		//System.arraycopy(clusteredData.toArray(), 0, array, 0, clusteredData.size());
		for(Iterator<Integer> it = clusteredData.iterator(); it.hasNext();){
			int v = it.next().intValue();
			str+="[";
			for(int j=0;j<data.GetNumberOfExplanatoryAttributes();j++)
				str+=data.GetAttributeValue(v, j)+" ";
			str+="] dist="+getCentroid().GetDistance(data.GetItemSet(v))+"\n";
			
		}
		str+="\nAvgDistance="+getCentroid().AvgDistance(data, clusteredData);
		return str;
		
	}

	@Override
	public int compareTo(Cluster arg0) {
		int size = arg0.getSize();
		
		return this.clusteredData.size() > size ? 1 : -1;
	}

	@Override
	public Iterator<Integer> iterator() {
		return clusteredData.iterator();
	}

}
