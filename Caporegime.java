import java.util.ArrayList;

public class Caporegime extends Gangster{
    private ArrayList<Soldier> soldiers;
    private double wealth;


    public Caporegime(ArrayList<String> names, ArrayList<String> lastItalianName,  ArrayList<Integer> personIds){
        super(names, lastItalianName, personIds);
        this.soldiers = new ArrayList<Soldier>();
    }

    public void recruitSoldiers(ArrayList<Person> citizens){
        int index = citizens.size() - 1;
        int addedSoldiers = 0;

        while(index-- > 0){
            if(addedSoldiers >= 3){
                return;
            }
            if(citizens.get(index).getLineage() && citizens.get(index).getLoyalty() > 80){
                soldiers.add(citizens.get(index).becomeSoldier(citizens));
                addedSoldiers++;
            }
        }
    }

    public void showTeam(){
        System.out.println("\n\u001B[31m--------------------------- Team ----------------------------\u001B[0m\n");
        System.out.println("\n\u001B[35mConsiglieri: " + this.stringify() + "\u001B[0m\nSoldiers:\n");
        this.soldiers.forEach((s) -> System.out.println(s.stringify()));
    }
}
