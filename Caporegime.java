import java.util.ArrayList;

public class Caporegime extends Gangster{
    private ArrayList<Soldier> soldiers;
    private ArrayList<Business> businesses;

    public Caporegime(ArrayList<String> names, ArrayList<String> lastItalianName,  ArrayList<Integer> personIds){
        super(names, lastItalianName, personIds);
        this.soldiers = new ArrayList<Soldier>();
        this.businesses = new ArrayList<Business>();
    }

    public void showTeam(){
        System.out.println("\n\u001B[31m--------------------------- Team ----------------------------\u001B[0m\n");
        System.out.println("\n\u001B[35mConsiglieri: " + this.stringify() + "\u001B[0m\nSoldiers:\n");
        this.soldiers.forEach((s) -> System.out.println(s.stringify()));
    }

    public void exploration(Family family){
        if(this.getBusinesses().isEmpty()){
            return;
        }
        for(Business business: businesses){
            int wealth = family.getWealth();
            int associatesCosts = 0;
            for(Person associate: business.getAssociates()){
                associatesCosts += associate.getCost();
            }

            if(Utils.getRandomNumber(business.getPoliceIntervention() - family.getPoliceCost()/10) > 30 && !family.getBoss().isPrisoner()){
                System.out.println("\nThe boss of the family "+family.getFamilyName()+" was caught!.\n");
                family.getJail().add(family.getBoss());
            }

            family.setWealth(wealth +  business.caporegimeExploreAll(family, this, family.getPoliceCost()) - associatesCosts - family.getInformantCosts());
            
            business.soldiersExplore(family, soldiers, family.getPoliceCost());
        }
    }

    public ArrayList<Business> getBusinesses(){
        return this.businesses;
    }

    public ArrayList<Soldier> getSoldiers(){
        return this.soldiers;
    }
}
