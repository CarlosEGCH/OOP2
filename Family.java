import java.util.ArrayList;

public class Family {
    
    private double wealth;
    private Person boss;
    private Person underboss;
    private Person consiglieri;
    private ArrayList<Caporegime> caporegimes;

    public Family(Metadata metadata){
        this.boss = new Person(metadata.getFileNames(), metadata.getFileItalianLastNames(), metadata.getPersonIds());
        this.underboss = new Person(metadata.getFileNames(), metadata.getFileItalianLastNames(), metadata.getPersonIds());
        this.consiglieri = new Person(metadata.getFileNames(), metadata.getFileItalianLastNames(), metadata.getPersonIds());

        int index = Utils.getRandomNumber(3);
        while(index > 0){
            Caporegime caporegime = new Caporegime(metadata.getFileNames(), metadata.getFileItalianLastNames(), metadata.getPersonIds());
            caporegimes.add(caporegime);
        }
        
    }

}
