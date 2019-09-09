import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.io.PrintStream;


public abstract class Book implements Comparable<Book>, Serializable {
    protected String title;
    protected Integer yearPub;
    protected String locationCode;
    protected Publisher publisher;
    protected Map<String, Object> authors = new HashMap<>();

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYearPub() {
        return this.yearPub;
    }

    public void setYearPub(Integer yearPub) {
        this.yearPub = yearPub;
    }

    public String getLocationCode() {
        return this.locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public void addAuthor(Author author) {
        this.authors.put(author.getName(), author);
    }

    public void setPublisher(Publisher publisher){
        this.publisher = publisher;
    }

    public void printAuthors(PrintStream ps) {
        for (Map.Entry<String, Object> entry: authors.entrySet()) {
            ps.println(entry.getKey());
        }
    }

    public String toString() {
        return "Title: " + this.title +
                "\nPublisher: " + this.publisher.getPublisher() +
                "\nYear Published: " + this.yearPub +
                "\nLocation Code: " + this.locationCode +
                "\nNumber of authors: " + this.authors.size();
    }

    @Override
    public int compareTo(Book b) {
        return Integer.compare(this.yearPub, b.getYearPub());
    }
}
