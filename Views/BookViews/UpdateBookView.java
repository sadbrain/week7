package Views.BookViews;

import FrameWork.ViewBaseG;
import FrameWork.ViewHelp;
import Models.Book;

public class UpdateBookView extends ViewBaseG<Book>{
    public UpdateBookView(Book model) {super(model);}
    public void render(){
        ViewHelp.WriteLine("Update book infomation", ViewHelp.TEXT_GREEN);
   
        String name = ViewHelp.inputString("Name", model.getName(), ViewHelp.TEXT_PURPLE);
        String author = ViewHelp.inputString("Author", model.getAuthor(), ViewHelp.TEXT_PURPLE);
        String shell = ViewHelp.inputString("Shell", model.getShell(), ViewHelp.TEXT_PURPLE);
        String category = ViewHelp.inputString("Category", model.getCategory(), ViewHelp.TEXT_PURPLE);
        int price = ViewHelp.inputInt("Price", model.getPrice(), ViewHelp.TEXT_PURPLE);
        boolean bookStatus = ViewHelp.inputBool("BookStatus", model.getBookStatus(), ViewHelp.TEXT_PURPLE);


        String request = "do update book ?"
                    +" id =" + model.getId() 
                    +" & name = " + name 
                    +" & author = " + author
                    +" & shell  = " + shell
                    +" & category = " + category
                    +" & price = " + price
                    +" & bookStatus = " + bookStatus;
        
        router.forward(request);

    }
}
