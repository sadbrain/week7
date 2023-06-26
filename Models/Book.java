package Models;

public class Book{
    private int id  ;
    private String name = "";
    private String author = "Unknown author";
    private String shell = "Unknow shell";
    private String category = "";
    private boolean bookStatus = false;
    private boolean isBroke = false;
    private int price;


    public void setIsBroke(boolean isBroke) {
        this.isBroke = isBroke;
    }
    public Boolean getIsBroke() {
        return isBroke;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        if(id > 0) this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if(!(name == null || name.isEmpty())) this.name = name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        if(!(author == null || author.isEmpty())) this.author = author;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        if(!(category == null || category.isEmpty())) this.category = category;
    }
    
    public String getShell() {
        return shell;
    }
    public void setShell(String shell) {
        if(!(shell == null || shell.isEmpty())) this.shell = shell;
    }
    public boolean getBookStatus(){
        return bookStatus;
    }
    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        if(price > 0) this.price = price;
    }
   
}