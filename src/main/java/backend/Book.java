package backend;


public class Book {

    private String title;
    private String author;
    private String publisher;
    private String category;
    private String releasedate;
    private String isbn;
    private String description;
    private String image_url;
    private double price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void initPlaceholder() {
        String ph = "placeholder";
        title = ph;
        author = ph;
        publisher = ph;
        category = ph;
        releasedate = ph;
        isbn = ph;
        description = ph;
        image_url = "http://funnypictures4.fjcdn.com/pictures/Still+nothing+to+see+here+more+appropriate+than+ever+for_d048f3_5678875.jpg";
        price= 0.00;
    }
}
