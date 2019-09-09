import java.io.Serializable;

public class Publisher implements Serializable {
    private String publisher;

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher){
        this.publisher = publisher;
    }
}
