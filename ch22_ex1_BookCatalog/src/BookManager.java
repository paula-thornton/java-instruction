import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BookManager {
    private List<Book> bookList;
    
    public BookManager() {
        bookList = new BookCatalog().getCatalog();
    }
    
   
	// Make one method that can replace the above 3 methods
	public List<Book> getBooks(Predicate<Book> condition) {
		List<Book> filteredBooks = new ArrayList<>();
		for (Book b: bookList) {
			if (condition.test(b)) {
				filteredBooks.add(b);
			}
		}
		return filteredBooks;
	}
}