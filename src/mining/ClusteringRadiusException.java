package mining;

public class ClusteringRadiusException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1284633450742866668L;
	
	private String msg;
	
	public ClusteringRadiusException(String msg) {
		this.msg = msg;
	}
	
	public String getMessage()
	{
		return msg;
	}

}
