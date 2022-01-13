import java.util.ArrayList;

public class Person {

    private String name;
    private boolean lineage;
    private int personId;
    private int behaviour;
    private String family;

    public Person(ArrayList<String> names){

        this.name = names.get(0);
        this.lineage = (Utils.getRandomNumber(10) > 5) ? true : false;

        while(personId == 0){
            int newId = Utils.getRandomNumber(999999999);

            if(MafiaCity.personIdExists(newId)){
                continue;
            }

            this.personId = newId;
        }

        this.behaviour = Utils.getRandomNumber(100);

        
    }

}
