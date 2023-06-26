package Models;
import java.time.LocalDate;
public class Rental{
    //hai dòng dưới kỹ thuật tăng tự tăng id mỗi khi có một đối tượng mới
    private int id = NextId++;
    private static int NextId = 1;

    //tạo ngày với thời gian hiện tại
    private LocalDate startDate = LocalDate.now();
    //ngày kết thúc sẽ tăng 30 ngày so với ngày bắt đầu
    private LocalDate endDate = startDate.plusDays(30);
    private MemberCard member;
    private Book[] books;

    public Rental(){}
    public Rental(LocalDate start, Book[] books, MemberCard card) {
        this.startDate = start;
        this.endDate = startDate.plusDays(30);
        this.books = books;
        this.member = card;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        if(id > 0) this.id = id;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public Book[] getBooks() {
        return books;
    }
    public void setBooks(Book[] books) {
        this.books = books;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public MemberCard getMember() {
        return member;
    }
    public void setMember(MemberCard member) {
        this.member = member;
    }

}