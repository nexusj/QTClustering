package data;

public class EmptyDataSetException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8445190676615136597L;

	private String msg;
	
	public EmptyDataSetException(String msg) {
		this.msg = msg;
	}
	
	public String getMessage()
	{
		return msg;
	}
}
