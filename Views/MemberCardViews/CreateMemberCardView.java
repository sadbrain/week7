package Views.MemberCardViews;

import java.time.LocalDate;

import FrameWork.ViewBase;
import FrameWork.ViewHelp;

public class CreateMemberCardView extends ViewBase{
    
    public CreateMemberCardView(){super();}

    public void render(){
        ViewHelp.WriteLine("Create a new member card", ViewHelp.TEXT_GREEN);
        String name = ViewHelp.inputString("Name", ViewHelp.TEXT_PURPLE);
        String cmnd = ViewHelp.inputString("Cmnd", ViewHelp.TEXT_PURPLE);
        String phone = ViewHelp.inputString("Phone", ViewHelp.TEXT_PURPLE);
        LocalDate birthDate = ViewHelp.inputDate(ViewHelp.TEXT_PURPLE);
        char gender = ViewHelp.inputString("Gender", ViewHelp.TEXT_PURPLE).charAt(0);
        String nationality = ViewHelp.inputString("Nationality", ViewHelp.TEXT_PURPLE);
        String placeOfOrigin = ViewHelp.inputString("Place of origin", ViewHelp.TEXT_PURPLE);
        String placeOfResidence = ViewHelp.inputString("Place of resident", ViewHelp.TEXT_PURPLE);

        String request = "do create member card ?"
                    +" name = " + name 
                    +" & cmnd = " + cmnd 
                    +" & phone = " + phone
                    +" & birthDate  = " + birthDate
                    +" & gender = " + gender
                    +" & nationality = " + nationality
                    +" & placeOfOrigin = " + placeOfOrigin
                    +" & placeOfResidence = " + placeOfResidence;
        
        router.forward(request);
            
    }
}
