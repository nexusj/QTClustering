package mining;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;

import data.Data;
import data.EmptyDataSetException;


public class QTMiner {

	private ClusterSet C;
	private double radius;
	
	public QTMiner(double radius)
	{
		C = new ClusterSet();
		this.radius = radius;
	}
	
	public QTMiner(String filename) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		if(filename == null) throw new FileNotFoundException("IO Error: null string !");
		
		FileInputStream fstream = new FileInputStream(filename);
		ObjectInputStream ostream = new ObjectInputStream(fstream);
		
		this.C = (ClusterSet)ostream.readObject();
		ostream.close();
	}
	
	public void Save(String filename) throws FileNotFoundException, IOException
	{
		if(filename == null) throw new FileNotFoundException("IO Error: null string !");
		
		FileOutputStream fstream = new FileOutputStream(filename);
		ObjectOutputStream ostream = new ObjectOutputStream(fstream);
		
		ostream.writeObject(this.C);
		ostream.close();
	}
	public ClusterSet GetC()
	{
		return C;
	}
	
	public int Compute(Data data) throws ClusteringRadiusException,EmptyDataSetException
	{
		int numclusters = 0,
			countClustered = 0;
		boolean isClustered[] = new boolean[data.GetNumberOfExamples()];
		
		
			
			if(data.GetNumberOfExamples() == 0)
				throw new EmptyDataSetException("Empty DataSet!!");
			
			for (int i = 0; i < isClustered.length; i++)
				isClustered[i] = false;
			
			while(countClustered != data.GetNumberOfExamples())
			{
				//Finding the most populated cluster
				Cluster c = BuildCandidateCluster(data, isClustered);
				C.Add(c);
				numclusters++;
				
				//Removing clustered tuples from dataset.
				
				
				for (Iterator<Integer> clusteredTupleID = c.iterator(); clusteredTupleID.hasNext();) {
					isClustered[clusteredTupleID.next().intValue()] = true;
				}
				
				countClustered += c.getSize();
			}
			
			if (numclusters == 1)
				throw new  ClusteringRadiusException(data.GetNumberOfExamples() + " tuples in 1 cluster !");
		
			return numclusters;
	}
	
	Cluster BuildCandidateCluster(Data data, boolean isClustered[])
	{
		Cluster c = null,
				candidateCluster = new Cluster(null);
		
		
		for (int i = 0; i < isClustered.length; i++) {
			
			if(!isClustered[i])
			{
				c = new Cluster(data.GetItemSet(i));
				
				for (int j = 0; j < isClustered.length; j++) {
					
					if(!isClustered[j])
					{
						if(data.GetItemSet(i).GetDistance(data.GetItemSet(j)) <= radius)
						{
							c.addData(j);
							
						}	
					}
				}
				
				if(candidateCluster.getSize() < c.getSize())
					candidateCluster = c;
			}
		}
		
		return candidateCluster;
	}
	
	@Override
	public String toString()
	{
		return this.C.toString();
	}
}
