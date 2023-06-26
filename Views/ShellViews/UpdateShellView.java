package Views.ShellViews;
import FrameWork.ViewBaseG;
import FrameWork.ViewHelp;
import Models.Shell;

public class UpdateShellView extends ViewBaseG<Shell>{
    public UpdateShellView(Shell model) {super(model);}
    
    public void render(){
        ViewHelp.WriteLine("Update shell infomation", ViewHelp.TEXT_GREEN);
   
        String name = ViewHelp.inputString("Name", model.getName(), ViewHelp.TEXT_PURPLE);
        int location = ViewHelp.inputInt("Location", model.getLocation(), ViewHelp.TEXT_PURPLE);


        String request = "do update shell ?"
                    +" id =" + model.getId() 
                    +" & name = " + name 
                    +" & location = " + location;
        
        router.forward(request);

    }
}
