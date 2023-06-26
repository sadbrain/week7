package Controller;
import DataService.RentalRepository;
import DataService.SimpleDataAccess;
import FrameWork.ControllerBase;
import FrameWork.Router;
import FrameWork.ViewHelp;
import Models.Rental;
import Views.RentalViews.ListRentalView;
import Views.RentalViews.SingleRentalView;

public class RentalController extends ControllerBase{
    protected RentalRepository rentalRepository;
    
    public RentalController(SimpleDataAccess context){
        rentalRepository = new RentalRepository(context);
    }


    public void single(){
        int id = ViewHelp.inputInt("Enter rental id", ViewHelp.TEXT_PURPLE);
        Rental model = rentalRepository.select(id);
        render(new SingleRentalView(model));
    }

    public void list(){
        Rental[] rentals = rentalRepository.select();
        render(new ListRentalView(rentals));
    }
    public void singleRentalHisDes(){
        int id = ViewHelp.inputInt("Enter rental id", ViewHelp.TEXT_PURPLE);
        Rental model = rentalRepository.selectRentalHisDes(id);
        render(new SingleRentalView(model));
    }

    public void listRentalHisDes(){
        Rental[] rentals = rentalRepository.selectRentalHisDes();
        render(new ListRentalView(rentals));
    }

    public void delete(int id, boolean process){

        //đầu tiên md process sẽ là false để tìm sách và đưa ra thông báo có muốn xóa hay không.
        //có thì sẽ gọi hàm này một lần nữa và process sẽ là true, 
        if (!process)
        {
            id = ViewHelp.inputInt("Enter rental id", ViewHelp.TEXT_PURPLE);
            Rental r = rentalRepository.select(id);
            if(r != null)  {
                ViewHelp.WriteLine("CONFIRMATION", ViewHelp.TEXT_CYAN);
                boolean isDelete = ViewHelp.inputBool("Do you want to delete this rental " +r.getId() +"?", ViewHelp.TEXT_PURPLE);
                if(isDelete) {
                    String request = "do delete rental ? id = "+ r.getId();
                    Router.getInstance().forward(request);
                }
                 
            }
            else
            {
                ViewHelp.WriteLine("INFORMATION!", ViewHelp.TEXT_YELLOW);
                ViewHelp.WriteLine("No rental found, please choose another rental!", ViewHelp.TEXT_PURPLE);
                return;
            }

        }
        else
        {
            rentalRepository.delete(id);
            ViewHelp.WriteLine("SUCCESS", ViewHelp.TEXT_GREEN);
            ViewHelp.WriteLine("Rental deleted!", ViewHelp.TEXT_PURPLE);
        }
    }
}
