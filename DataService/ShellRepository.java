package DataService;

import java.util.ArrayList;
import Models.Shell;
public class ShellRepository {
    protected SimpleDataAccess context;

    public ShellRepository(SimpleDataAccess context) {
        this.context = context;
    }
    
    public void saveChange() {context.saveChanges();}

    public ArrayList<Shell> shells () {return context.getShells();}

    public Shell[] select() {return context.getShells().toArray(new Shell[context.getShells().size()]);}

    public Shell select(int id){
        for (Shell s : context.getShells()) {
            if(s.getId() == id){
                return s;
            }
        }
        return null;
    }
    public void insert(Shell shell){
        int i = context.getShells().size();
        int id = i == 0 ? 1 : context.getShells().get(i-1).getId() + 1;
        shell.setId(id);
        context.getShells().add(shell);
    }

    public boolean update(int id, Shell shell){
        Shell s = select(id);
        if(s == null) return false;
        s.setName(shell.getName());
        s.setLocation(shell.getLocation());
        return true;
    }
    public boolean delete(int id)
    {
        Shell s = select(id);
        if (s == null) return false;
        context.getShells().remove(s);
        return true;
    } 

}
