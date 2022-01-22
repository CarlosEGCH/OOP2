import java.util.ArrayList;

public class Business {
    private int baseProfit;
    private String name;
    private String skill;
    private ArrayList<Person> associates;
    private ArrayList<Caporegime> caporegimes;
    private int policeIntervention;
    private String ownership;

    public Business(int profit, String name, String skill, ArrayList<String> names, ArrayList<String> lastNonItalianName, ArrayList<String> lastItalianName, ArrayList<Integer> personIds){
        this.baseProfit = profit;
        this.name = name;
        this.skill = skill;
        this.associates = new ArrayList<Person>();

        int amtOfAssociates = Utils.getRandomNumber(10);
        while(amtOfAssociates-- > 0){
            this.associates.add(new Person(names, lastItalianName, lastNonItalianName, personIds));
        }

        this.policeIntervention = Utils.getRandomNumber(50, 100);
        this.ownership = "none";
    }

    public int caporegimeExploreAll(Gangster gangster, int policeCost){
        if(gangster.isPrisoner()){
            return 1;
        }
        if(policeIntervention - policeCost/10 > 30){
            System.out.println(gangster.getName() + " was catched by the police!");
            return 1;
        }
        if(this.skill == "loyalty"){
            return (gangster.getLoyalty()/100 + 1)*baseProfit;
        }else if(this.skill == "muscle"){
            return (gangster.getMuscle()/100 + 1)*baseProfit;
        }else if(this.skill == "intelligence"){
            return (gangster.getIntelligence()/100 + 1)*baseProfit;
        }else if(this.skill == "strategist"){
            return (gangster.getStrategist()/100 + 1)*baseProfit;
        }else if(this.skill == "charism"){
            return (gangster.getCharism()/100 + 1)*baseProfit;
        }
        return 1;
    }

    public int soldiersExplore(ArrayList<Soldier> soldiers){

        if(this.skill == "intelligence"){ //Calculate maximum intelligence
            int max = 0;
            for(Soldier soldier: soldiers){
                if(soldier.getIntelligence() >= max && !soldier.isPrisoner()){
                    max = soldier.getIntelligence() - soldier.getCost()/20;
                }
                return (max/100 + 1)*baseProfit;
            }
        }

        if(this.skill == "muscle"){
            int sum = 0;
            for(Soldier soldier: soldiers){
                if(!soldier.isPrisoner()){
                    sum += soldier.getMuscle() - soldier.getCost()/20;
                }
            }
            return (sum/soldiers.size()/100 + 1)*baseProfit;
        }

        if(this.skill == "strategist"){
            int max = 0;
            for(Soldier soldier: soldiers){
                if(soldier.getStrategist() >= max && !soldier.isPrisoner()){
                    max = soldier.getStrategist() - soldier.getCost()/20;
                }
                return (max/100 + 1)*baseProfit;
            }
        }

        if(this.skill == "charism"){
            int max = 0;
            for(Soldier soldier: soldiers){
                if(soldier.getCharism() >= max && !soldier.isPrisoner()){
                    max = soldier.getCharism() - soldier.getCost()/20;
                }
                return (max/100 + 1)*baseProfit;
            }
        }

        if(this.skill == "loyalty"){
            int max = 0;
            for(Soldier soldier: soldiers){
                if(soldier.getLoyalty() >= max && !soldier.isPrisoner()){
                    max = soldier.getLoyalty() - soldier.getCost()/20;
                }
                return (max/100 + 1)*baseProfit;
            }
        }
        
        return 1;
    }

    public void showBusinessName(){
        System.out.println(this.name);
    }

    public ArrayList<Person> getAssociates(){
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }
    

}
