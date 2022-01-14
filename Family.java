import java.util.ArrayList;

public class Family {
    
    //private double wealth;
    private Gangster boss;
    private ArrayList<Gangster> underbosses;
    private Person consiglieri;
    private ArrayList<Caporegime> caporegimes;

    /**
     * Constructor method
     * @param metadata
     */
    public Family(Metadata metadata){
        this.caporegimes = new ArrayList<Caporegime>();
        this.underbosses = new ArrayList<Gangster>();

        this.boss = new Gangster(metadata.getFileNames(), metadata.getFileItalianLastNames(), metadata.getPersonIds());
        Gangster underboss = new Gangster(metadata.getFileNames(), metadata.getFileItalianLastNames(), metadata.getPersonIds());
        this.underbosses.add(underboss);
        this.consiglieri = new Consiglieri(metadata.getFileNames(), metadata.getFileItalianLastNames(), metadata.getFileNonItalianLastNames(), metadata.getPersonIds());

        int index = Utils.getRandomNumber(2, 4);
        while(index-- > 0){
            Caporegime caporegime = new Caporegime(metadata.getFileNames(), metadata.getFileItalianLastNames(), metadata.getPersonIds());
            this.caporegimes.add(caporegime);
        }
        
    }

    public void familyPhoto(){
        System.out.println("\n\u001B[31m--------------------------- Family ----------------------------\u001B[0m\n");
        System.out.println("Boss: " + boss.stringify() + "\nConsiglieri: " + consiglieri.stringify() + "\n");
    }

    public void showCaporegimes(){
        System.out.println("\n\u001B[32m--------------------------- Caporegimes ----------------------------\u001B[0m\n");
        this.caporegimes.forEach((n) -> System.out.println(n.stringify()));
    }

    public void showUnderBosses(){
        System.out.println("\n\u001B[35m--------------------------- UnderBosses ----------------------------\u001B[0m\n");
        this.underbosses.forEach((n) -> System.out.println(n.stringify()));
    }

    public Caporegime getCaporegime(int index){
        return this.caporegimes.get(index);
    }

    public int getCaporegimesAmt(){
        return this.caporegimes.size();
    }

    public String getFamilyName(){
        return this.boss.getName();
    }

    public boolean isFamily(String familyName){
        return (familyName.equals(this.getFamilyName()))? true : false; 
    }

    public Person getBoss(){
        return this.boss;
    }

    public ArrayList<Caporegime> getCaporegimes(){
        return this.caporegimes;
    }
}
