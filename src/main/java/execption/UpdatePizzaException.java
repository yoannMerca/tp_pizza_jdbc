package execption;

public class UpdatePizzaException extends StockageException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UpdatePizzaException (String msg) {
		
		super(msg);
		//this.printStackTrace();
	}
}
