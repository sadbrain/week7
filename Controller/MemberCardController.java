package Controller;

import DataService.MemberCardRepository;
import DataService.SimpleDataAccess;
import FrameWork.ControllerBase;
import FrameWork.Router;
import FrameWork.ViewHelp;
import Models.MemberCard;
import Views.MemberCardViews.*;

public class MemberCardController extends ControllerBase{
    protected MemberCardRepository memberCardRepository;
    
    public MemberCardController(SimpleDataAccess context){
        memberCardRepository = new MemberCardRepository(context);
    }


    public void single(){
        int id = ViewHelp.inputInt("Enter member card id", ViewHelp.TEXT_PURPLE);
        MemberCard model = memberCardRepository.select(id);
        render(new SingleMemberCardView(model));
    }

    public void list(){
        MemberCard[] cards = memberCardRepository.select();
        render(new ListMemberCardView(cards));
    }

    public void create(MemberCard c){
        if(c == null){
            render(new CreateMemberCardView());
        }
        memberCardRepository.insert(c);
        
        success("Member card created!", null);
        Router.getInstance().forward("0");
    }

    public void update(int id, MemberCard b){

        if(b == null){
            id = ViewHelp.inputInt("Enter member card id", ViewHelp.TEXT_PURPLE);
            MemberCard model = memberCardRepository.select(id);
            if(model == null){
                ViewHelp.WriteLine("No member card found, please choose another member card", ViewHelp.TEXT_YELLOW);
                return;
            }

            render(new UpdateMemberCardView(model));
            return;
        }

        memberCardRepository.update(id, b);

        success("Member card updated!", null);

    }

    public void delete(int id, boolean process){

        //đầu tiên md process sẽ là false để tìm sách và đưa ra thông báo có muốn xóa hay không.
        //có thì sẽ gọi hàm này một lần nữa và process sẽ là true, 
        if (!process)
        {
            id = ViewHelp.inputInt("Enter member card id", ViewHelp.TEXT_PURPLE);
            MemberCard c = memberCardRepository.select(id);
            if(c != null)  {
                confirm("Do you want to delete this card " + c.getName() +"?", "do delete member card ? id = "+ c.getId(), null);
                return;
                 
            }
            else
            {
                inform("No member card found, please choose another member card!", null);
                return;
            }

        }
        else
        {
            memberCardRepository.delete(id);
            success("member card deleted!", null);

        }
    }
}

