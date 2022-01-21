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

    public Caporegime becomeCaporegime(ArrayList<Person> citizens){
        ArrayList<String> name = new ArrayList<String>();
        ArrayList<String> lastName = new ArrayList<String>(); 
        ArrayList<Integer> id = new ArrayList<Integer>();

        name.add(this.name);
        lastName.add(this.family);
        id.add(this.personId);

        Caporegime newCaporegime = new Caporegime(name, lastName, id);

        citizens.remove(this);

        return newCaporegime;
    }

    public Consiglieri becomeConsiglieri(ArrayList<Person> citizens){
        ArrayList<String> name = new ArrayList<String>();
        ArrayList<String> lastName = new ArrayList<String>(); 
        ArrayList<Integer> id = new ArrayList<Integer>();

        name.add(this.name);
        lastName.add(this.family);
        id.add(this.personId);

        Consiglieri newConsiglieri = new Consiglieri(name, lastName, lastName, id);

        citizens.remove(this);

        return newConsiglieri;
    }

    public Gangster becomeGangster(ArrayList<Person> citizens){
        ArrayList<String> name = new ArrayList<String>();
        ArrayList<String> lastName = new ArrayList<String>(); 
        ArrayList<Integer> id = new ArrayList<Integer>();

        name.add(this.name);
        lastName.add(this.family);
        id.add(this.personId);

        Gangster newGangster = new Gangster(name, lastName, id);

        citizens.remove(this);

        return newGangster;
    }

    public boolean getLineage(){
        return this.lineage;
    }

    public String getName(){
        return this.name;
    }

    public void recruitSoldiers(ArrayList<Person> citizens, Family family){
        int index = citizens.size() - 1;

        while(index-- > 0){
            if(citizens.get(index).getLineage() && citizens.get(index).getLoyalty() > 80){
                family.getCaporegime(Utils.getRandomNumber(family.getCaporegimesAmt() - 1)).getSoldiers().add(citizens.get(index).becomeSoldier(citizens));
                return;
            }
        }
    }

    public void recruitCaporegimes(ArrayList<Person> citizens, Family family){
        int index = citizens.size() - 1;

        while(index-- > 0){
            if(citizens.get(index).getLineage() && citizens.get(index).getLoyalty() > 80){
                family.getCaporegimes().add(citizens.get(index).becomeCaporegime(citizens));
                return;
            }
        }
    }

    public void recruitUnderBosses(ArrayList<Person> citizens, Family family){
        int index = citizens.size() - 1;

        while(index-- > 0){
            if(citizens.get(index).getLineage() && citizens.get(index).getLoyalty() > 80){
                family.getUnderbosses().add(citizens.get(index).becomeGangster(citizens));
                return;
            }
        }
    }

    public String getFamilyName(){
        return this.family;
    }

        
    //Getters && Setters
    public int getLoyalty() {
        return this.loyalty;
    }
    
    public void setLoyalty(int loyalty) {
        this.loyalty = loyalty;
    }
    
    public int getMuscle() {
        return this.muscle;
    }
    
    public void setMuscle(int muscle) {
        this.muscle = muscle;
    }
    
    public int getIntelligence() {
        return this.intelligence;
    }
    
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    
    public int getStrategist() {
        return this.strategist;
    }
    
    public void setStrategist(int strategist) {
        this.strategist = strategist;
    }
    
    public int getCharism() {
        return this.charism;
    }
    
    public void setCharism(int charism) {
        this.charism = charism;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
    
}
