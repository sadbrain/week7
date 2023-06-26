import FrameWork.Router;
import FrameWork.ViewHelp;

public class Program {

    public static void main(String[] args) {

        ProgramHelp.configue();
        while(true){
            rootMenu();;

        }
    
    }
    private static void rootMenu(){
        ViewHelp.WriteLine("---------------------------------LibreryMan----------------------------------", ViewHelp.TEXT_YELLOW);            
        ViewHelp.WriteLine(String.format("| %-73s |","1. Book management"), ViewHelp.TEXT_BLUE); 
        ViewHelp.WriteLine(String.format("| %-73s |","2. Member card management"), ViewHelp.TEXT_BLUE); 
        ViewHelp.WriteLine(String.format("| %-73s |","3. Shell managemet"), ViewHelp.TEXT_BLUE); 
        ViewHelp.WriteLine(String.format("| %-73s |","4. Rental managemet"), ViewHelp.TEXT_BLUE); 
        ViewHelp.WriteLine(String.format("| %-73s |","5. Hire book"), ViewHelp.TEXT_BLUE); 
        ViewHelp.WriteLine(String.format("| %-73s |","6. Give book back"), ViewHelp.TEXT_BLUE); 
        ViewHelp.WriteLine(String.format("| %-73s |","7. Find book"), ViewHelp.TEXT_BLUE); 
        ViewHelp.WriteLine(String.format("| %-73s |","8. About"), ViewHelp.TEXT_BLUE); 
        ViewHelp.WriteLine(String.format("| %-73s |","9. Help"), ViewHelp.TEXT_BLUE); 

        ViewHelp.WriteLine("---------------------------------LibreryMan----------------------------------", ViewHelp.TEXT_YELLOW);       
        ViewHelp.Write("Request >> ", ViewHelp.TEXT_PURPLE);
        String request = ViewHelp.SC.nextLine();
        Router.getInstance().forward(request);
    }

}






