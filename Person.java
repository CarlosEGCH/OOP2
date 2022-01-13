import java.util.ArrayList;

public class Person {

    private String name;
    private String family;
    private boolean lineage;
    private int personId;
    private int behaviour;

    /**
     * Constructor for all kinds of people
     * @param names
     * @param lastItalianName
     * @param lastNonItalianName
     * @param personIds
     */
    public Person(ArrayList<String> names, ArrayList<String> lastItalianName, ArrayList<String> lastNonItalianName, ArrayList<Integer> personIds){

        this.name = names.get(Utils.getRandomNumber(names.size()));

        if(Utils.getRandomNumber(10) > 5){
            this.lineage = true;

            int size = lastItalianName.size();
            int index = Utils.getRandomNumber(size);
            this.family = lastItalianName.get(index);
        }else{
            this.lineage = false;

            int size = lastNonItalianName.size();
            int index = Utils.getRandomNumber(size);
            this.family = lastNonItalianName.get(index);
        }

        while(personId == 0){
            int newId = Utils.getRandomNumber(999999);

            if(!personIds.contains(newId)){
                this.personId = newId;
                personIds.add(newId);
            }

        }

        this.behaviour = Utils.getRandomNumber(100);

    }

    /**
     * Constructor for italian people
     * @param names
     * @param lastItalianName
     * @param personIds
     */
    public Person(ArrayList<String> names, ArrayList<String> lastItalianName, ArrayList<Integer> personIds){

        this.name = names.get(Utils.getRandomNumber(names.size()));
        this.lineage = true;

        int size = lastItalianName.size();
        int index = Utils.getRandomNumber(size);
        this.family = lastItalianName.get(index);

        while(personId == 0){
            int newId = Utils.getRandomNumber(999999);

            if(!personIds.contains(newId)){
                this.personId = newId;
                personIds.add(newId);
            }

        }

        this.behaviour = Utils.getRandomNumber(100);
    }

    public String toString(){
        String info;
        info = "Name: " + this.name + " ccId: " + this.personId + " Lineage: " + this.lineage + " Behaviour: " + this.behaviour + " Family: " + this.family;
        return info;
    }

}
