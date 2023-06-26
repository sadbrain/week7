import java.time.LocalDate;
import java.util.Hashtable;

import Controller.*;
import DataService.SimpleDataAccess;
import FrameWork.Parameter;
import FrameWork.Router;
import FrameWork.ViewHelp;
import Models.*;

public class ProgramHelp {
    public static void configue(){
        SimpleDataAccess context = new SimpleDataAccess();
        context.load();

        BookController bookController = new BookController(context);
        ShellController shellController = new ShellController(context);
        MemberCardController  memberCardController = new MemberCardController(context);
        RentalController rentalController = new RentalController(context);

        Router r = Router.getInstance();
        r.register("0", (p) -> Program.main(new String[]{"call main"}), "call main");
        r.register("1", (p) -> bookManagmentMenu(), "display menu book management");        
        r.register("1.4", (p) -> bookController.list(), "display all books");
        r.register("1.3", (p) -> bookController.single(), "display a book");        
        r.register("1.1", (p) -> bookController.create(null), "create a book");
        r.register("do create book", (p) -> bookController.create(toBook(p)), "do create a book");
        r.register("1.2", (p) -> bookController.update(0, null), "update a book");
        r.register("do update book", (p) -> bookController.update(Integer.valueOf(p.getPairs().get("id")), toBook(p)), "do update a book");
        r.register("1.5", (p) -> bookController.delete(0, false), "delete a book");
        r.register("do delete book", (p) -> bookController.delete(Integer.valueOf(p.getPairs().get("id")), true), "do delete a book");


        r.register("2", (p) -> memberCardManagementMenu(), "display menu shell management");        
        r.register("2.4", (p) -> memberCardController.list(), "display all cards");
        r.register("2.3", (p) -> memberCardController.single(), "display a member card");        
        r.register("2.1", (p) -> memberCardController.create(null), "create a member card");
        r.register("do create member card", (p) -> memberCardController.create(toMemberCard(p)), "do create a member card");
        r.register("2.2", (p) -> memberCardController.update(0, null), "update a member card");
        r.register("do update member card", (p) -> memberCardController.update(Integer.valueOf(p.getPairs().get("id")), toMemberCard(p)), "do update a member card");
        r.register("2.5", (p) -> memberCardController.delete(0, false), "delete a member card");
        r.register("do delete member card", (p) -> memberCardController.delete(Integer.valueOf(p.getPairs().get("id")), true), "do delete a member card");


        r.register("3", (p) -> shellManagementMenu(), "display menu shell management");        
        r.register("3.4", (p) -> shellController.list(), "display all shells");
        r.register("3.3", (p) -> shellController.single(), "display a shell");        
        r.register("3.1", (p) -> shellController.create(null), "create a shell");
        r.register("do create shell", (p) -> shellController.create(toShell(p)), "do create a shell");
        r.register("3.2", (p) -> shellController.update(0, null), "update a shell");
        r.register("do update shell", (p) -> shellController.update(Integer.valueOf(p.getPairs().get("id")), toShell(p)), "do update a shell");
        r.register("3.5", (p) -> shellController.delete(0, false), "delete a shell");
        r.register("do delete shell", (p) -> shellController.delete(Integer.valueOf(p.getPairs().get("id")), true), "do delete a shell");

        r.register("4", (p) -> rentalManagementMenu(), "display menu rental management");        
        r.register("4.2", (p) -> rentalController.list(), "display all rentals");
        r.register("4.1", (p) -> rentalController.single(), "display a rental");        
        r.register("4.4", (p) -> rentalController.listRentalHisDes(), "display all rental history deleted");
        r.register("4.3", (p) -> rentalController.singleRentalHisDes(), "display a rental history deleted");   

        r.register("8", (p) -> about(), "");
        r.register("9", (p) -> help(p), "");
    }

    private static void about()
    {
        ViewHelp.WriteLine("BOOK MANAGER version 2  .0", ViewHelp.TEXT_GREEN);
        ViewHelp.WriteLine("by dhnynit@TuHocIct.com", ViewHelp.TEXT_YELLOW);
    }

    private static void help(Parameter p)
    {
        if (p == null)
        {
            ViewHelp.WriteLine("SUPPORTED COMMANDS:", ViewHelp.TEXT_GREEN);
            ViewHelp.WriteLine("type: 9 ? cmd = <number> to get command details", ViewHelp.TEXT_CYAN);
            return;
        }
        String command = p.getPairs().get("cmd").toLowerCase();
        ViewHelp.WriteLine(Router.getInstance().GetHelp(command), ViewHelp.TEXT_BLACK);
    }

    private static void bookManagmentMenu(){
        ViewHelp.WriteLine("--------------------------------Book managment-------------------------------", ViewHelp.TEXT_YELLOW);            
        ViewHelp.WriteLine(String.format("| %-73s |","1.1 Create a book"), ViewHelp.TEXT_BLUE);            
        ViewHelp.WriteLine(String.format("| %-73s |","1.2 Update a book"), ViewHelp.TEXT_BLUE);
        ViewHelp.WriteLine(String.format("| %-73s |","1.3 Display a book"), ViewHelp.TEXT_BLUE);
        ViewHelp.WriteLine(String.format("| %-73s |","1.4 Display all book"), ViewHelp.TEXT_BLUE);
        ViewHelp.WriteLine(String.format("| %-73s |","1.5 Delete a book"), ViewHelp.TEXT_BLUE);
        ViewHelp.WriteLine("--------------------------------Book managment-------------------------------", ViewHelp.TEXT_YELLOW);

        ViewHelp.Write("Request >> ", ViewHelp.TEXT_PURPLE);
        String request = ViewHelp.SC.nextLine();
        Router.getInstance().forward(request);
    }
    private static void rentalManagementMenu(){
        ViewHelp.WriteLine("------------------------------Rental Managment-------------------------------", ViewHelp.TEXT_YELLOW);            
        ViewHelp.WriteLine(String.format("| %-73s |","4.1 Display a rental"), ViewHelp.TEXT_BLUE);
        ViewHelp.WriteLine(String.format("| %-73s |","4.2 Display all rental"), ViewHelp.TEXT_BLUE);
        ViewHelp.WriteLine(String.format("| %-73s |","4.3 Single a deleting rental"), ViewHelp.TEXT_BLUE);
        ViewHelp.WriteLine(String.format("| %-73s |","4.4 List all deleting rental"), ViewHelp.TEXT_BLUE);
        ViewHelp.WriteLine("------------------------------Rental Managment-------------------------------", ViewHelp.TEXT_YELLOW);

        ViewHelp.Write("Request >> ", ViewHelp.TEXT_PURPLE);
        String request = ViewHelp.SC.nextLine();
        Router.getInstance().forward(request);
    }
    private static void shellManagementMenu() {
        ViewHelp.WriteLine("-------------------------------Shell Managment-------------------------------", ViewHelp.TEXT_YELLOW);            
        ViewHelp.WriteLine(String.format("| %-73s |","3.1 Create a shell"), ViewHelp.TEXT_BLUE);            
        ViewHelp.WriteLine(String.format("| %-73s |","3.2 Update a shell"), ViewHelp.TEXT_BLUE);
        ViewHelp.WriteLine(String.format("| %-73s |","3.3 Display a shell"), ViewHelp.TEXT_BLUE);
        ViewHelp.WriteLine(String.format("| %-73s |","3.4 Display all shell"), ViewHelp.TEXT_BLUE);
        ViewHelp.WriteLine(String.format("| %-73s |","3.5 Delete a shell"), ViewHelp.TEXT_BLUE);
        ViewHelp.WriteLine("-------------------------------Shell Managment-------------------------------", ViewHelp.TEXT_YELLOW); 

        ViewHelp.Write("Request >> ", ViewHelp.TEXT_PURPLE);
        String request = ViewHelp.SC.nextLine();
        Router.getInstance().forward(request);
    }

    private static void memberCardManagementMenu() {
        ViewHelp.WriteLine("----------------------------Member card managment----------------------------", ViewHelp.TEXT_YELLOW);            
        ViewHelp.WriteLine(String.format("| %-73s |","2.1 Create a member card"), ViewHelp.TEXT_BLUE);            
        ViewHelp.WriteLine(String.format("| %-73s |","2.2 Update a member card"), ViewHelp.TEXT_BLUE);
        ViewHelp.WriteLine(String.format("| %-73s |","2.3 Display a member card"), ViewHelp.TEXT_BLUE);
        ViewHelp.WriteLine(String.format("| %-73s |","2.4 Display all member card"), ViewHelp.TEXT_BLUE);
        ViewHelp.WriteLine(String.format("| %-73s |","2.5 Delete a member card"), ViewHelp.TEXT_BLUE);
        ViewHelp.WriteLine("----------------------------Member card managment----------------------------", ViewHelp.TEXT_YELLOW);   

        ViewHelp.Write("Request >> ", ViewHelp.TEXT_PURPLE);
        String request = ViewHelp.SC.nextLine();
        Router.getInstance().forward(request);
    }
    
    private static Book toBook(Parameter parameter)
    {
        Hashtable<String, String> p = parameter.getPairs();
        Book b = new Book();
        if(p.containsKey("id")) b.setId(Integer.valueOf(p.get("id")));
        if (p.containsKey("name")) b.setName(p.get("name"));
        if (p.containsKey("author")) b.setAuthor(p.get("author"));
        if (p.containsKey("shell")) b.setShell(p.get("shell"));
        if (p.containsKey("category")) b.setCategory(p.get("category"));
        if (p.containsKey("price")) b.setPrice(Integer.valueOf(p.get("price")));
        if (p.containsKey("bookStatus")) b.setBookStatus(Boolean.valueOf(p.get("bookStatus")));
        return b;
    }

    private static MemberCard toMemberCard(Parameter parameter)
    {
        Hashtable<String, String> p = parameter.getPairs();
        MemberCard c = new MemberCard();
        if(p.containsKey("id"))  c.setId(Integer.valueOf(p.get("id")));
        if (p.containsKey("name")) c.setName(p.get("name"));
        if (p.containsKey("cmnd")) c.setCmnd(p.get("cmnd"));
        if (p.containsKey("phone")) c.setPhone(p.get("phone"));
        if (p.containsKey("birthDate")) c.setBirthDate(LocalDate.parse(p.get("birthDate")));
        if (p.containsKey("gender")) c.setGender(p.get("gender").charAt(0));
        if (p.containsKey("nationality")) c.setNationality(p.get("nationality"));
        if (p.containsKey("placeOfOrigin")) c.setPlaceOfOrigin(p.get("placeOfOrigin"));
        if (p.containsKey("placeOfResidence")) c.setPlaceOfResidence(p.get("placeOfResidence"));
        if (p.containsKey("startDate")) c.setStartDate(LocalDate.parse(p.get("startDate")));


        return c;
    }

    private static Shell toShell(Parameter parameter)
    {
        Hashtable<String, String> p = parameter.getPairs();
        Shell s = new Shell();
        if(p.containsKey("id")) s.setId(Integer.valueOf(p.get("id")));
        if (p.containsKey("name")) s.setName(p.get("name"));
        if (p.containsKey("location")) s.setLocation(Integer.valueOf(p.get("location")));
        return s;
    }
}
