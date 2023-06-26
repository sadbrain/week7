package DataService;
import Models.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class SimpleDataAccess {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Shell> shells = new ArrayList<>();
    private ArrayList<MemberCard> memberCards = new ArrayList<>();
    private ArrayList<Rental> rentals = new ArrayList<>();
    private ArrayList<Rental> rentalHisDes = new ArrayList<>();


    public ArrayList<Book> getBooks() {
        return books;
    }
    public ArrayList<Shell> getShells() {
        return shells;
    }
    public ArrayList<MemberCard> getMemberCards() {
        return memberCards;
    }
    public ArrayList<Rental> getRentalHisDes() {
        return rentalHisDes;
    }
    public ArrayList<Rental> getRentals() {
        return rentals;
    }
    public void load(){
        books.add(new Book());            
        books.add(new Book());
        books.add(new Book());
        books.add(new Book());
        books.add(new Book());
        books.add(new Book());
        books.add(new Book());
        books.add(new Book());
        for(int i = 0; i < books.size(); i++) {
            books.get(i).setId(i+1);
        } 
        shells.add(new Shell());
        shells.add(new Shell());
        shells.add(new Shell());
        for(int i = 0; i < shells.size(); i++) {
            shells.get(i).setId(i+1);
        }
        memberCards.add(new MemberCard());
        memberCards.add(new MemberCard());
        memberCards.add(new MemberCard());
        memberCards.add(new MemberCard());

        for(int i = 0; i < memberCards.size(); i++) {
            memberCards.get(i).setId(i+1);
        }
        rentals.add(new Rental(LocalDate.of(2023,5,5), new Book[]{books.get(0)}, memberCards.get(0)));
        rentals.add(new Rental(LocalDate.of(2023,4,4), new Book[]{books.get(1)}, memberCards.get(1)));

        for(int i = 0; i < rentals.size(); i++) {
            rentals.get(i).setId(i+1);
        }

        rentalHisDes.add(new Rental(LocalDate.of(2023,9,5), new Book[]{books.get(3)}, memberCards.get(2)));
        rentalHisDes.add(new Rental(LocalDate.of(2023,10,4), new Book[]{books.get(4)}, memberCards.get(3)));

        for(int i = 0; i < rentalHisDes.size(); i++) {
            rentalHisDes.get(i).setId(i+1);
        }

    }

    public void saveChanges(){}
}
