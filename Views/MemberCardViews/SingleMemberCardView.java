package Views.MemberCardViews;

import FrameWork.ViewBaseG;
import FrameWork.ViewHelp;
import Models.MemberCard;
public class SingleMemberCardView extends ViewBaseG<MemberCard> {
    
    public SingleMemberCardView(MemberCard model) {super(model);}

    public void render(){
        if(model == null) {
            ViewHelp.WriteLine("No member card found", ViewHelp.TEXT_RED);
            return;
        }
        ViewHelp.WriteLine("Member card detail infomation", ViewHelp.TEXT_GREEN);
        System.out.println("Id:  "                       + model.getId());
        System.out.println("Name:  "                     + model.getName());
        System.out.println("Cmnd: "                      + model.getCmnd());
        System.out.printf("Birth day: %tD%n"                 , model.getBirthDate());
        System.out.println("Gender: "                    + model.getGender());
        System.out.println("Nationality: "               + model.getNationality());
        System.out.println("Place of origin: "           + model.getPlaceOfOrigin());    
        System.out.println("place of Residence: "        + model.getPlaceOfResidence());    
        System.out.printf("Start date: %tD%n"                , model.getStartDate());    
        System.out.printf("End date:  %tD%n"                  , model.getEndDate()); 
        
    }
}
