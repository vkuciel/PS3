package pkgLibrary;

import java.util.ArrayList;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Catalog {

	@XmlAttribute
	int id;	
	
	@XmlElement(name="book")
	ArrayList<Book> books;
	
	
	public int getId() {
		return id;
	}
	

	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Book> getBooks() {
		return books;
	}
	

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}
	
	public Book getBook(String id) throws BookException {
		Catalog cat = null;
		Book b = null;
		
		for (int i = 0; i<cat.getBooks().size(); i++) {
			if (cat.getBooks().get(i).getId() == id) {
				b = cat.getBooks().get(i);
			}
		}
		if (b == null) {
			b = new Book(id, id, id, id, 0, null, id, 0);
			throw new BookException(b);
		}
		else {
			return b;		
		}
		
		//AddBook 
		private static Catalog AddBook(int id, Book b)throws BookException {
			
			Catalog cat = ReadXMLFile();
			
			if (id = cat.getId()) {
				for (int i = 0; i < cat.getBooks().size(); i++) {
					if (b.getId() == cat.getBooks().get(i).getId()) {
						throw new BookException(b);
					}
				}
				cat.getBooks().add(b);
			}
			return cat;
			
		}
	}

	
	


	
	
	
	
}
