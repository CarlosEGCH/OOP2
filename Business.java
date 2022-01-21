import java.util.ArrayList;

public class Business {
    private int baseProfit;
    private String name;
    private String skill;
    private ArrayList<Person> associates;
    private ArrayList<Caporegime> caporegimes;
    private int policeIntervention;

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
    }

    public int gangsterExploreAll(Gangster gangster, int policeCost){
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
                if(soldier.getIntelligence() >= max){
                    max = soldier.getIntelligence();
                }
                return (max/100 + 1)*baseProfit;
            }
        }

        if(this.skill == "muscle"){
            int sum = 0;
            for(Soldier soldier: soldiers){
                sum += soldier.getMuscle();
            }
            return (sum/soldiers.size()/100 + 1)*baseProfit;
        }

        if(this.skill == "strategist"){
            //Do something
        }

        if(this.skill == "charism"){
            //Do something
        }

        if(this.skill == "loyalty"){
            //Do something
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

    
    /*
    * TODO: Improve business exploration methods to make them more diverse.
    */

}
