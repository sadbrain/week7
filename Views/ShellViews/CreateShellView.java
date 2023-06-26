package Views.ShellViews;

import FrameWork.ViewBase;
import FrameWork.ViewHelp;

public class CreateShellView extends ViewBase{
    
    public CreateShellView(){super();}

    public void render(){
        ViewHelp.WriteLine("Create a new shell", ViewHelp.TEXT_GREEN);

        String name = ViewHelp.inputString("Name", ViewHelp.TEXT_PURPLE);
        int location = ViewHelp.inputInt("Location", ViewHelp.TEXT_PURPLE);

        String request = "do create shell ?"
                    +" name = " + name 
                    +" & price = " + location;
        
        router.forward(request);
            
    }
}
