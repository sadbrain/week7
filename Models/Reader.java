package Models;
import java.time.LocalDate;


public abstract class Reader {
    private int id;

    private String name = "";
    private String cmnd = "";
    private String phone = "";
    private LocalDate birthDate;
    private char gender ='m';
    private String nationality = "Viet Nam";
    private String placeOfOrigin = "";
    private String placeOfResidence = "";

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
    public String getCmnd() {
        return cmnd;
    }
    public void setCmnd(String cmnd) {
        if(!(cmnd == null || cmnd.isEmpty())) this.cmnd = cmnd;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        if(!(phone == null || phone.isEmpty())) this.phone = phone;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public char getGender() {
        return gender;
    }
    public void setGender(char gender) {
      if(gender == 'f') this.gender = gender;
    }
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        if(!(nationality == null || nationality.isEmpty())) this.nationality = nationality;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }
    public void setPlaceOfOrigin(String placeOfOrigin) {
        if(!(placeOfOrigin == null || placeOfOrigin.isEmpty())) this.placeOfOrigin = placeOfOrigin;
    }
    public String getPlaceOfResidence() {
        return placeOfResidence;
    }
    public void setPlaceOfResidence(String placeOfResidence) {
        if(!(placeOfResidence == null || placeOfResidence.isEmpty())) this.placeOfResidence = placeOfResidence;
    }

}