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
            family.setWealth(wealth +  business.gangsterExploreAll(this));
            System.out.println("gangsterExploreAll(): "+business.gangsterExploreAll(this)+"\n");
            
            for(Soldier soldier: soldiers){
            wealth = family.getWealth();
                family.setWealth(wealth +  business.gangsterExploreAll(soldier));
                System.out.println("Actual wealth: "+family.getWealth()+"\n");
            }
        }
    }

    public ArrayList<Business> getBusinesses(){
        return this.businesses;
    }

    public ArrayList<Soldier> getSoldiers(){
        return this.soldiers;
    }
}
