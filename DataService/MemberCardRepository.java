package DataService;

import java.util.ArrayList;

import Models.MemberCard;

public class MemberCardRepository {
    protected SimpleDataAccess context;

    public MemberCardRepository(SimpleDataAccess context) {
        this.context = context;
    }
    
    public void saveChange() {context.saveChanges();}

    public ArrayList<MemberCard> shells () {return context.getMemberCards();}

    public MemberCard[] select() {return context.getMemberCards().toArray(new MemberCard[context.getMemberCards().size()]);}

    public MemberCard select(int id){
        for (MemberCard m : context.getMemberCards()) {
            if(m.getId() == id){
                return m;
            }
        }
        return null;
    }
    public void insert(MemberCard card){
        int i = context.getMemberCards().size();
        int id = i == 0 ? 1 : context.getMemberCards().get(i-1).getId() + 1;
        card.setId(id);
        context.getMemberCards().add(card);
    }

    public boolean update(int id, MemberCard card){
        MemberCard m = select(id);
        if(m == null) return false;
        m.setName(card.getName());
        m.setCmnd(card.getCmnd());
        m.setPhone(card.getPhone());
        m.setGender(card.getGender());
        m.setBirthDate(card.getBirthDate());
        m.setNationality(card.getNationality());
        m.setPlaceOfOrigin(card.getPlaceOfOrigin());
        m.setPlaceOfResidence(card.getPlaceOfResidence());
        m.setStartDate(card.getStartDate());
        m.setEndDate(card.getStartDate().plusDays(30));

        return true;
    }
    public boolean delete(int id)
    {
        MemberCard m = select(id);
        if (m == null) return false;
        context.getMemberCards().remove(m);
        return true;
    } 

}
