import java.io.Serializable;

public class PrintedBook extends Book implements Serializable {
    private Integer numberOfPages;
    private Integer dateOfPrint;

    public Integer getNumberOfPages() {
        return this.numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Integer getDateOfPrint() {
        return this.dateOfPrint;
    }

    public void setDateOfPrint(int dateOfPrint) {
        this.dateOfPrint = dateOfPrint;
    }

    public String toString() {
        return "\nType: Printed Book\n" +
                super.toString() +
                "\nNumber of pages: " + this.numberOfPages +
                "\nDate of print: " + this.dateOfPrint;
    }
}
