package Views.ShellViews;

import FrameWork.ViewBaseG;
import FrameWork.ViewHelp;
import Models.Shell;

public class ListShellView extends ViewBaseG<Shell[]>{
    
    public ListShellView(Shell[] models) {super(models);}

    public  void render(){
        if(model.length == 0) {
            ViewHelp.WriteLine("No shell found", ViewHelp.TEXT_RED);
            return;
        }
        ViewHelp.WriteLine(String.format("%46s %n", "The shell list"), ViewHelp.TEXT_GREEN);
        ViewHelp.WriteLine("______________________________________________________________________________________________________________", ViewHelp.TEXT_YELLOW);            

        ViewHelp.WriteLine(String.format("| %-30s | %-40s | %-30s |", "ID", "Name shell", "Location"), ViewHelp.TEXT_YELLOW);
        ViewHelp.WriteLine("|________________________________|__________________________________________|________________________________|", ViewHelp.TEXT_YELLOW);            

        for (Shell s : model) {
            
            System.out.printf("| %-30d | %-40s | %-30d |%n",s.getId(), s.getName(), s.getLocation());            
            System.out.println("|________________________________|__________________________________________|________________________________|");            
    
        }

        ViewHelp.WriteLine( String.format("%n%50s", "list has " +  model.length + " items"), ViewHelp.TEXT_GREEN);
        ViewHelp.WriteLine(String.format("%n%50s","----------End----------"), ViewHelp.TEXT_GREEN);


  
    }
}

