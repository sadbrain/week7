package Views.MemberCardViews;

import FrameWork.ViewBaseG;
import FrameWork.ViewHelp;
import Models.MemberCard;

public class ListMemberCardView extends ViewBaseG<MemberCard[]>{
    
    public ListMemberCardView(MemberCard[] models) {super(models);}

    public  void render(){
        if(model.length == 0) {
            ViewHelp.WriteLine("No member card found", ViewHelp.TEXT_RED);
            return;
        }
        ViewHelp.WriteLine(String.format("%80s %n", "The memberCard list"), ViewHelp.TEXT_GREEN);
        ViewHelp.WriteLine("_______________________________________________________________________________________________________________________________________________________________", ViewHelp.TEXT_YELLOW);
        ViewHelp.WriteLine(String.format("| %-23s | %-60s | %-20s | %-20s | %-20s |", "ID", "Name Customer", "Number cmnd", "Start date", "End date"), ViewHelp.TEXT_YELLOW);
        ViewHelp.WriteLine("|_________________________|______________________________________________________________|______________________|______________________|______________________|", ViewHelp.TEXT_YELLOW);

        for (MemberCard m : model) {
            System.out.printf("| %-23d | %-60s | %-20s | %-20tD | %-20tD | %n", m.getId(), m.getName(), m.getCmnd(), m.getStartDate(), m.getEndDate());
            System.out.println("|_________________________|______________________________________________________________|______________________|______________________|______________________|");

        }

        ViewHelp.WriteLine( String.format("%n%73s", "list has " +  model.length + " items"), ViewHelp.TEXT_GREEN);
        ViewHelp.WriteLine(String.format("%n%78s","----------End----------"), ViewHelp.TEXT_GREEN);
  
    }
}

