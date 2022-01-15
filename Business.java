public class Business {
    private int baseProfit;
    private String name;
    private String skill;

    public Business(int profit, String name, String skill){
        this.baseProfit = profit;
        this.name = name;
        this.skill = skill;
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
    
    /*
    * TODO: Improve business exploration methods to make them more diverse.
    */

}
