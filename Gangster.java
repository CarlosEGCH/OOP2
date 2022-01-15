import java.util.ArrayList;

public class Gangster extends Person {
    
    private int loyalty;
    private int muscle;
    private int intelligence;
    private int strategist;
    private int charism;

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
    
    public int getCharism() {
        return charism;
    }
    
    public void setCharism(int charism) {
        this.charism = charism;
    }
    
    @Override
    public String stringify(){
        String info = super.stringify();
        return info;
    }
}