package pkgLibrary;

public class BookException extends Exception {
	public static void main(String[] args) {
		}
	
	private Book b;
	
	public BookException() {
		super();
	}
	
	public BookException(Book b) {
		super("error");
		this.b = b;
	}

}
