import java.util.ArrayList;

public class Person {

    private String name;
    private String family;
    private boolean lineage;
    private int personId;
    private int behaviour;
    private int loyalty;
    private int muscle;
    private int intelligence;
    private int strategist;
    private int charism;

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

            int size = lastItalianName.size() - 1;
            int index = Utils.getRandomNumber(size);
            this.family = lastItalianName.get(index);
        }else{
            this.lineage = false;

            int size = lastNonItalianName.size() - 1;
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
        this.loyalty = Utils.getRandomNumber(100);
        this.muscle = Utils.getRandomNumber(100);
        this.intelligence = Utils.getRandomNumber(100);
        this.strategist = Utils.getRandomNumber(100);
        this.charism = Utils.getRandomNumber(100);

    }

    /**
     * Constructor for italian people
     * @param names
     * @param lastItalianName
     * @param personIds
     */
    public Person(ArrayList<String> names, ArrayList<String> lastItalianName, ArrayList<Integer> personIds){

        this.name = names.get(Utils.getRandomNumber(names.size() - 1));
        this.lineage = true;

        int size = lastItalianName.size() - 1;
        int index = Utils.getRandomNumber(size);
        this.family = lastItalianName.get(index);

        while(personId == 0){
            int newId = Utils.getRandomNumber(10000000, 99999999);

            if(!personIds.contains(newId)){
                this.personId = newId;
                personIds.add(newId);
            }

        }

        this.behaviour = Utils.getRandomNumber(100);
        this.loyalty = Utils.getRandomNumber(100);
        this.muscle = Utils.getRandomNumber(100);
        this.intelligence = Utils.getRandomNumber(100);
        this.strategist = Utils.getRandomNumber(100);
        this.charism = Utils.getRandomNumber(100);
    }



    public String stringify(){
        String info;
        info = "Name: " + this.name + " ccId: " + this.personId + " Lineage: " + this.lineage + " Behaviour: " + this.behaviour + " Family: " + this.family;
        info += "\nLoyalty: " + this.loyalty + " Muscle: " + this.muscle + " Intelligence: " + this.intelligence + " Strategist: " + this.strategist + " Charism: " + this.charism + "\n";
        return info;
    }

    public Soldier becomeSoldier(ArrayList<Person> citizens){
        ArrayList<String> name = new ArrayList<String>();
        ArrayList<String> lastName = new ArrayList<String>(); 
        ArrayList<Integer> id = new ArrayList<Integer>();

        name.add(this.name);
        lastName.add(this.family);
        id.add(this.personId);

        Soldier newSoldier = new Soldier(name, lastName, id);

        citizens.remove(this);

        return newSoldier;

    }

    public boolean getLineage(){
        return this.lineage;
    }

    public int getLoyalty(){
        return this.loyalty;
    }

    public String getName(){
        return this.name;
    }

    public void recruitSoldiers(ArrayList<Person> citizens, ArrayList<Soldier> soldiers){
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
}
