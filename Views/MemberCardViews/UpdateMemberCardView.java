package Views.MemberCardViews;

import java.time.LocalDate;

import FrameWork.ViewBaseG;
import FrameWork.ViewHelp;
import Models.MemberCard;

public class UpdateMemberCardView extends ViewBaseG<MemberCard>{
    public UpdateMemberCardView(MemberCard model) {super(model);}

    public void render(){
        ViewHelp.WriteLine("Update member card infomation", ViewHelp.TEXT_GREEN);

        String name = ViewHelp.inputString("Name", model.getName(), ViewHelp.TEXT_PURPLE);
        String cmnd = ViewHelp.inputString("Cmnd", model.getCmnd(), ViewHelp.TEXT_PURPLE);
        String phone = ViewHelp.inputString("Phone", model.getPhone(), ViewHelp.TEXT_PURPLE);
        LocalDate birthDate = ViewHelp.inputDate("Birth date: ", model.getBirthDate(), ViewHelp.TEXT_PURPLE);
        char gender = ViewHelp.inputString("Gender", String.valueOf(model.getGender()), ViewHelp.TEXT_PURPLE).charAt(0);
        String nationality = ViewHelp.inputString("Nationality",model.getNationality(), ViewHelp.TEXT_PURPLE);
        String placeOfOrigin = ViewHelp.inputString("Place of origin", model.getPlaceOfOrigin(), ViewHelp.TEXT_PURPLE);
        String placeOfResidence = ViewHelp.inputString("Place of resident",model.getPlaceOfResidence(), ViewHelp.TEXT_PURPLE);
        LocalDate startDate = ViewHelp.inputDate("Start date: ", model.getStartDate(), ViewHelp.TEXT_PURPLE);
        
        String request = "do update member card ?"
                    +" id =" + model.getId() 
                    +" & name = " + name 
                    +" & cmnd = " + cmnd 
                    +" & phone = " + phone
                    +" & birthDate  = " + birthDate
                    +" & gender = " + gender
                    +" & nationality = " + nationality
                    +" & placeOfOrigin = " + placeOfOrigin
                    +" & placeOfResidence = " + placeOfResidence
                    +" & startDate = " + startDate;
        
        router.forward(request);

    }
}
