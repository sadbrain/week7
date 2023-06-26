package Views.BookViews;

import FrameWork.ViewBase;
import FrameWork.ViewHelp;

public class CreateBookView extends ViewBase{
    
    public CreateBookView(){super();}

    public void render(){
        ViewHelp.WriteLine("Create a new book", ViewHelp.TEXT_GREEN);
        String name = ViewHelp.inputString("Name", ViewHelp.TEXT_PURPLE);
        String author = ViewHelp.inputString("Author", ViewHelp.TEXT_PURPLE);
        String shell = ViewHelp.inputString("Shell", ViewHelp.TEXT_PURPLE);
        String category = ViewHelp.inputString("Category", ViewHelp.TEXT_PURPLE);
        int price = ViewHelp.inputInt("Price", ViewHelp.TEXT_PURPLE);
        Boolean bookStatus = ViewHelp.inputBool("BookStatus", ViewHelp.TEXT_PURPLE);

        String request = "do create book ?"
                    +" name = " + name 
                    +" & author = " + author
                    +" & shell  = " + shell
                    +" & category = " + category
                    +" & price = " + price
                    +" & bookStatus = " + bookStatus;
        
        router.forward(request);
            
    }
}
