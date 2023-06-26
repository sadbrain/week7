package Controller;
import DataService.BookRepository;
import DataService.SimpleDataAccess;
import FrameWork.ControllerBase;
import FrameWork.Router;
import FrameWork.ViewHelp;
import Models.Book;
import Views.BookViews.*;

public class BookController extends ControllerBase{
    protected BookRepository bookRepository;
    
    public BookController(SimpleDataAccess context){
        bookRepository = new BookRepository(context);
    }


    public void single(){
        int id = ViewHelp.inputInt("Enter book id", ViewHelp.TEXT_PURPLE);
        Book model = bookRepository.select(id);
        render(new SingleBookView(model));
    }

    public void list(){
        Book[] books = bookRepository.select();
        render(new ListBookView(books));
    }

    public void create(Book b){
        if(b == null){
            render(new CreateBookView());
        }
        bookRepository.insert(b);

        success("Book created!", null);
        Router.getInstance().forward("0");
    }

    public void update(int id, Book b){

        if(b == null){
            id = ViewHelp.inputInt("Enter book id", ViewHelp.TEXT_PURPLE);
            Book model = bookRepository.select(id);
            if(model == null){
                ViewHelp.WriteLine("No book found, please choose another book", ViewHelp.TEXT_YELLOW);
                return;
            }

            render(new UpdateBookView(model));
            return;
        }

        bookRepository.update(id, b);
        success("Book updated!", null);


    }

    public void delete(int id, boolean process){

        //đầu tiên md process sẽ là false để tìm sách và đưa ra thông báo có muốn xóa hay không.
        //có thì sẽ gọi hàm này một lần nữa và process sẽ là true, 
        if (!process)
        {
            id = ViewHelp.inputInt("Enter book id", ViewHelp.TEXT_PURPLE);
            Book b = bookRepository.select(id);
            if(b != null)  {
                confirm("Do you want to delete this book " +b.getName() +"?", "do delete book ? id = "+ b.getId(), null); 
                return;       
            }
            else
            {

                inform("No book found, please choose another book!", null);
                return;
            }

        }
        else
        {
            bookRepository.delete(id);
            success("Book deleted!", null);

        }
    }
}
