package DataService;

import java.util.ArrayList;
import Models.Rental;
public class RentalRepository {
    protected SimpleDataAccess context;

    public RentalRepository(SimpleDataAccess context) {
        this.context = context;
    }
    
    public void saveChange() {context.saveChanges();}

    public ArrayList<Rental> rentals () {return context.getRentals();}
    public ArrayList<Rental> rentalHisDes () {return context.getRentalHisDes();}


    public Rental[] select() {return context.getRentals().toArray(new Rental[context.getRentals().size()]);}
    public Rental[] selectRentalHisDes() {return context.getRentalHisDes().toArray(new Rental[context.getRentalHisDes().size()]);}


    public Rental select(int id){
        for (Rental r : context.getRentals()) {
            if(r.getId() == id){
                return r;
            }
        }
        return null;
    }
    public Rental selectRentalHisDes(int id){
        for (Rental r : context.getRentalHisDes()) {
            if(r.getId() == id){
                return r;
            }
        }
        return null;
    }
    public void insert(Rental rental){
        int i = context.getRentals().size();
        int id = i == 0 ? 1 : context.getRentals().get(i-1).getId() + 1;
        rental.setId(id);
        context.getRentals().add(rental);
    }
    public void insertRentalHisDes(Rental rental){
        int i = context.getRentalHisDes().size();
        int id = i == 0 ? 1 : context.getRentalHisDes().get(i-1).getId() + 1;
        rental.setId(id);
        context.getRentalHisDes().add(rental);
    }


    public boolean delete(int id)
    {
        Rental r = select(id);
        if (r == null) return false;
        context.getRentals().remove(r);
        return true;
    } 

    public boolean deleteRentalHisDes(int id)
    {
        Rental r = selectRentalHisDes(id);
        if (r == null) return false;
        context.getRentalHisDes().remove(r);
        return true;
    } 
}
