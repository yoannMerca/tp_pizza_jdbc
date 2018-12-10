package execption;

public class DeletePizzaException extends StockageException{
	private static final long serialVersionUID = 1L;

	public DeletePizzaException (String msg) {
		super(msg);
	}
}
