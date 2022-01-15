import java.util.ArrayList;

public class Caporegime extends Gangster{
    private ArrayList<Soldier> soldiers;

    public Caporegime(ArrayList<String> names, ArrayList<String> lastItalianName,  ArrayList<Integer> personIds){
        super(names, lastItalianName, personIds);
        this.soldiers = new ArrayList<Soldier>();
    }

    public void showTeam(){
        System.out.println("\n\u001B[31m--------------------------- Team ----------------------------\u001B[0m\n");
        System.out.println("\n\u001B[35mConsiglieri: " + this.stringify() + "\u001B[0m\nSoldiers:\n");
        this.soldiers.forEach((s) -> System.out.println(s.stringify()));
    }

    public ArrayList<Soldier> getSoldiers(){
        return this.soldiers;
    }
}
