package Views.RentalViews;
import FrameWork.ViewBaseG;
import FrameWork.ViewHelp;
import Models.Book;
import Models.Rental;
public class SingleRentalView extends ViewBaseG<Rental> {
    
    public SingleRentalView(Rental model) {super(model);}

    public void render(){
        if(model == null) {
            ViewHelp.WriteLine("No rental found", ViewHelp.TEXT_RED);
            return;
        }

        ViewHelp.WriteLine("Member rental detail infomation", ViewHelp.TEXT_GREEN);
        System.out.println("Id:  "                       + model.getId()); 
        System.out.println("Id khach hang: "             + model.getMember().getId());
        System.out.println("Name khach hang: "           + model.getMember().getName());
        System.out.println("So cmnd: "                   + model.getMember().getCmnd());  
        System.out.printf("Start date: %tD%n"                ,model.getStartDate());    
        System.out.printf("End date: %tD%n"                  ,model.getEndDate());   

        if(model.getBooks().length == 0) {
            ViewHelp.WriteLine("No book found", ViewHelp.TEXT_RED);
            return;
        }
        ViewHelp.WriteLine(String.format("%60s %n", "The Book list"), ViewHelp.TEXT_GREEN);
        ViewHelp.WriteLine("__________________________________________________________________________________________________________________________________",ViewHelp.TEXT_YELLOW);
        ViewHelp.WriteLine(String.format("| %-30s | %-60s | %-30s |", "ID", "Name book", "Status"), ViewHelp.TEXT_YELLOW);
        ViewHelp.WriteLine("|________________________________|______________________________________________________________|________________________________|", ViewHelp.TEXT_YELLOW);

        for (Book b : model.getBooks()) {
            if(b.getBookStatus())
                System.out.printf("| %-30d | %-60s | %-30s | %n", b.getId(), b.getName(), "da duoc muon");
            else if(b.getIsBroke())
                System.out.printf("| %-30d | %-60s | %-30s | %n", b.getId(), b.getName(), "da bi hu hai");

            else
                System.out.printf("| %-30d | %-60s | %-30s | %n", b.getId(), b.getName(), "chua duoc muon");
                System.out.println("|________________________________|______________________________________________________________|________________________________|");

                

        }

        ViewHelp.WriteLine( String.format("%n%63s", "list has " +  model.getBooks().length + " items"), ViewHelp.TEXT_GREEN);
        ViewHelp.WriteLine( String.format("%n%65s","----------End----------"), ViewHelp.TEXT_GREEN);
  
            
        
        
    }
}