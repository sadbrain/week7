package Views.BookViews;
import FrameWork.ViewBaseG;
import FrameWork.ViewHelp;
import Models.Book;
public class SingleBookView extends ViewBaseG<Book> {
    
    public SingleBookView(Book model) {super(model);}

    public void render(){
        if(model == null) {
            ViewHelp.WriteLine("No book found", ViewHelp.TEXT_RED);
            return;
        }
        ViewHelp.WriteLine("Book detail infomation", ViewHelp.TEXT_GREEN);
        System.out.println("Id:  "          + model.getId());
        System.out.println("Name:  "        + model.getName());
        System.out.println("Author: "       + model.getAuthor());
        System.out.println("Shell: "        + model.getShell());
        System.out.println("Category: "     + model.getCategory());
        if(model.getBookStatus())
        System.out.println("BookStatus: "   + "da duoc muon");
        else 
        System.out.println("BookStatus: "   + "chua duoc muon");
        if(model.getIsBroke())  System.out.println("Sach da bi hu");

        System.out.println("Price: "        + model.getPrice());
        
    }
}
