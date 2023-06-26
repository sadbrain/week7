package Models;
import java.time.LocalDate;
public class MemberCard extends Reader{
    private LocalDate startDate = LocalDate.now();
    private LocalDate endDate = startDate.plusDays(30);

    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate start) {
        this.startDate = start;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate end) {
        this.endDate = end;
    }

}