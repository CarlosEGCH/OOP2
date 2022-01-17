import java.util.ArrayList;

public class Business {
    private int baseProfit;
    private String name;
    private String skill;
    private ArrayList<Gangster> associates;
    private ArrayList<Caporegime> caporegimes;

    public Business(int profit, String name, String skill, ArrayList<String> names, ArrayList<String> lastItalianName, ArrayList<Integer> personIds){
        this.baseProfit = profit;
        this.name = name;
        this.skill = skill;
        this.associates = new ArrayList<Gangster>();

        int amtOfAssociates = Utils.getRandomNumber(10);
        while(amtOfAssociates-- > 0){
            this.associates.add(new Gangster(names, lastItalianName, personIds));
        }
    }

    public int caporegimeExploreAll(Caporegime caporegime){
        if(this.skill == "loyalty"){
            return caporegime.getLoyalty()*baseProfit;
        }else if(this.skill == "muscle"){
            return caporegime.getMuscle()*baseProfit;
        }else if(this.skill == "intelligence"){
            return caporegime.getIntelligence()*baseProfit;
        }else if(this.skill == "strategist"){
            return caporegime.getStrategist()*baseProfit;
        }else if(this.skill == "charism"){
            return caporegime.getCharism()*baseProfit;
        }
        return 1;
    }

    public int soldierExploreAll(Soldier soldier){
        if(this.skill == "loyalty"){
            return soldier.getLoyalty()*baseProfit;
        }else if(this.skill == "muscle"){
            return soldier.getMuscle()*baseProfit;
        }else if(this.skill == "intelligence"){
            return soldier.getIntelligence()*baseProfit;
        }else if(this.skill == "strategist"){
            return soldier.getStrategist()*baseProfit;
        }else if(this.skill == "charism"){
            return soldier.getCharism()*baseProfit;
        }
        return 1;
    }

    public void showBusinessName(){
        System.out.println(this.name);
    }

    public ArrayList<Gangster> getAssociates(){
        return this.associates;
    }

    public ArrayList<Caporegime> getCaporegimes(){
        return this.caporegimes;
    }

    public void addCaporegime(String name, Caporegime caporegime){
        int index = this.caporegimes.size() - 1;
        while(index >= 0){
            if(this.caporegimes.get(index).getFamilyName().equals(name)){
                System.out.println("\nThis Business is already owned by the " + name + " family.\n");
                return;
            }
        }
        this.caporegimes.add(caporegime);
        System.out.println("\nCaporegime added succesfully!\n");
        return;
    }

    public void showAssociates(){
        System.out.println("\n\u001B[31m--------------------------- Associates ----------------------------\u001B[0m\n");
        this.associates.forEach((a)->System.out.println(a.stringify()));
    }
    
    /*
    * TODO: Improve business exploration methods to make them more diverse.
    */

}
