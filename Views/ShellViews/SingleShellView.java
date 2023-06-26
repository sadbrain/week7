package Views.ShellViews;
import FrameWork.ViewBaseG;
import FrameWork.ViewHelp;
import Models.Shell;

public class SingleShellView extends ViewBaseG<Shell> {
    
    public SingleShellView(Shell model) {super(model);}

    public void render(){
        if(model == null) {
            ViewHelp.WriteLine("No shell found", ViewHelp.TEXT_RED);
            return;
        }
        ViewHelp.WriteLine("Book detail infomation", ViewHelp.TEXT_GREEN);
        
        ViewHelp.WriteLine("Shell detail infomation", ViewHelp.TEXT_GREEN);
        System.out.println("Id:  "          + model.getId());
        System.out.println("Name:  "        + model.getName());
        System.out.println("Location: "       + model.getLocation());
        
    }
}

