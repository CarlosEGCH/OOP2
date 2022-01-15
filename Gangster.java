import java.util.ArrayList;

public class Gangster extends Person {
    
    private int loyalty;
    private int muscle;
    private int intelligence;
    private int strategist;
    private int carism;

    public Gangster(ArrayList<String> names, ArrayList<String> lastItalianName, ArrayList<Integer> personIds){
        super(names, lastItalianName, personIds);
    }
    
    //Getters && Setters
    public int getLoyalty() {
        return loyalty;
    }
    
    public void setLoyalty(int loyalty) {
        this.loyalty = loyalty;
    }
    
    public int getMuscle() {
        return muscle;
    }
    
    public void setMuscle(int muscle) {
        this.muscle = muscle;
    }
    
    public int getIntelligence() {
        return intelligence;
    }
    
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    
    public int getStrategist() {
        return strategist;
    }
    
    public void setStrategist(int strategist) {
        this.strategist = strategist;
    }
    
    public int getCarism() {
        return carism;
    }
    
    public void setCarism(int carism) {
        this.carism = carism;
    }
    
    @Override
    public String stringify(){
        String info = super.toString();
        info += " Loyalty: " + loyalty + " Muscle: " + muscle + " Intelligence: " + intelligence + " Strategist: " + strategist + " Carism: " + carism;
        return info;
    }
}