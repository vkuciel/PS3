package pkgEmpty;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.junit.Test;
import pkgLibrary.Book;
import pkgLibrary.BookException;
import pkgLibrary.Catalog;
import pkgLibrary.Catalog;

public class UnitTests {

	public static void main(String[] args) {
	}
	// Passing test
	@Test
	public void utgetbookP() throws BookException {
		Catalog cat = ReadXMLFile();
		cat.getBook("bk101");
	}
	//Failing test
	public void utgetbookF() throws BookException {
		Catalog cat = ReadXMLFile();
		cat.getBook("bk0");
	}
	//Passing Test
	public void utaddbookP() throws BookException {
		Catalog cat = ReadXMLFile();
		Book b = new Book("bk101", null, null, null, 0, null, null, 0);
	}
	//Failing test
	public void utaddbookF() throws BookException {
		Catalog cat = ReadXMLFile();
		Book b = new Book("bk0", null, null, null, 0, null, null, 0);
	}

	private Catalog ReadXMLFile() {
		Catalog cat = null;

		String basePath = new File("").getAbsolutePath();
		basePath = basePath + "\\src\\main\\resources\\XMLFiles\\Books.xml";
		File file = new File(basePath);

		System.out.println(file.getAbsolutePath());
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			cat = (Catalog) jaxbUnmarshaller.unmarshal(file);
			System.out.println(cat);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return cat;

	}
	

}
