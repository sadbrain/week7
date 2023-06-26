package Views.BookViews;


import FrameWork.ViewBaseG;
import FrameWork.ViewHelp;
import Models.Book;

public class ListBookView extends ViewBaseG<Book[]>{
    
    public ListBookView(Book[] models) {super(models);}

    public  void render(){
        if(model.length == 0) {
            ViewHelp.WriteLine("No book found", ViewHelp.TEXT_RED);
            return;
        }
        ViewHelp.WriteLine(String.format("%60s %n", "The Book list"), ViewHelp.TEXT_GREEN);
        ViewHelp.WriteLine("__________________________________________________________________________________________________________________________________",ViewHelp.TEXT_YELLOW);
        ViewHelp.WriteLine(String.format("| %-30s | %-60s | %-30s |", "ID", "Name book", "Status"), ViewHelp.TEXT_YELLOW);
        ViewHelp.WriteLine("|________________________________|______________________________________________________________|________________________________|", ViewHelp.TEXT_YELLOW);

        for (Book m : model) {
            if(m.getBookStatus())
                System.out.printf("| %-30d | %-60s | %-30s | %n", m.getId(), m.getName(), "da duoc muon");
            else if(m.getIsBroke())
                System.out.printf("| %-30d | %-60s | %-30s | %n", m.getId(), m.getName(), "da bi hu hai");

            else
                System.out.printf("| %-30d | %-60s | %-30s | %n", m.getId(), m.getName(), "chua duoc muon");
                System.out.println("|________________________________|______________________________________________________________|________________________________|");

                

        }

        ViewHelp.WriteLine( String.format("%n%63s", "list has " +  model.length + " items"), ViewHelp.TEXT_GREEN);
        ViewHelp.WriteLine( String.format("%n%65s","----------End----------"), ViewHelp.TEXT_GREEN);
  
    }
}
