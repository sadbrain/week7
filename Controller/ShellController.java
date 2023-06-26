package Controller;

import DataService.ShellRepository;
import DataService.SimpleDataAccess;
import FrameWork.ControllerBase;
import FrameWork.Router;
import FrameWork.ViewHelp;
import Models.Shell;
import Views.ShellViews.*;

public class ShellController extends ControllerBase{
    protected ShellRepository shellRepository;
    
    public ShellController(SimpleDataAccess context){
        shellRepository = new ShellRepository(context);
    }


    public void single(){
        int id = ViewHelp.inputInt("Enter shell id", ViewHelp.TEXT_PURPLE);
        Shell model = shellRepository.select(id);
        render(new SingleShellView(model));
    }

    public void list(){
        Shell[] shells = shellRepository.select();
        render(new ListShellView(shells));
    }

    public void create(Shell s){
        if(s == null){
            render(new CreateShellView());
        }
        shellRepository.insert(s);
        
        success("Shell created!", null);
        Router.getInstance().forward("0");
    }

    public void update(int id, Shell s){

        if(s == null){
            id = ViewHelp.inputInt("Enter shell id", ViewHelp.TEXT_PURPLE);
            Shell model = shellRepository.select(id);
            if(model == null){
                ViewHelp.WriteLine("No shell found, please choose another shell", ViewHelp.TEXT_YELLOW);
                return;
            }

            render(new UpdateShellView(model));
            return;
        }

        shellRepository.update(id, s);
        success("Shell updated!", null);


    }

    public void delete(int id, boolean process){

        //đầu tiên md process sẽ là false để tìm sách và đưa ra thông báo có muốn xóa hay không.
        //có thì sẽ gọi hàm này một lần nữa và process sẽ là true, 
        if (!process)
        {
            id = ViewHelp.inputInt("Enter shell id", ViewHelp.TEXT_PURPLE);
            Shell s = shellRepository.select(id);
            if(s != null)  {

                confirm("Do you want to delete this shell " + s.getName() +"?", "do delete shell ? id = "+ s.getId(), null);
                return;
                 
            }
            else
            {

                inform("No shell found, please choose another shell!", null);
                return;
            }

        }
        else
        {
            shellRepository.delete(id);
            success("Shell deleted!", null);

        }
    }
}
