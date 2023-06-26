package Models;
public class Shell {
    private int id;

    private String name ="" ;
    private int location;
    public Shell(){}
    public Shell(String name, int location){
        this.name = name;
        this.location = location;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        if(id > 0) this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if(!(name == null || name.isEmpty())) this.name = name;
    }
    public int getLocation() {
        return location;
    }
    public void setLocation(int location) {
        if(location > 0) this.location = location;
    }

}