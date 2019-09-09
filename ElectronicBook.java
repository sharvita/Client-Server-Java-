import java.io.Serializable;

public class ElectronicBook extends Book implements Serializable {
    private Integer numberOfPages;
    private Integer dateDigitized;

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Integer getDateDigitized() {
        return dateDigitized;
    }

    public void setDateDigitized(Integer dateDigitized) {
        this.dateDigitized = dateDigitized;
    }

    public String toString(){
        return "\nType: Electronic Book\n" +
                super.toString() +
                "\nNumber of pages: " + this.numberOfPages +
                "\nDate digitized: " + this.dateDigitized;
    }
}
