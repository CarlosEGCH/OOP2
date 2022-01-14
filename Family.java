import java.util.ArrayList;

public class Family {
    
    private double wealth;
    private Person boss;
    private Person underboss;
    private Person consiglieri;
    private ArrayList<Caporegime> caporegimes;

    public Family(Metadata metadata){
        this.caporegimes = new ArrayList<Caporegime>();

        this.boss = new Person(metadata.getFileNames(), metadata.getFileItalianLastNames(), metadata.getPersonIds());
        this.underboss = new Person(metadata.getFileNames(), metadata.getFileItalianLastNames(), metadata.getPersonIds());
        this.consiglieri = new Consiglieri(metadata.getFileNames(), metadata.getFileItalianLastNames(), metadata.getFileNonItalianLastNames(), metadata.getPersonIds());

        int index = Utils.getRandomNumber(2, 6);
        while(index-- > 0){
            Caporegime caporegime = new Caporegime(metadata.getFileNames(), metadata.getFileItalianLastNames(), metadata.getPersonIds());
            this.caporegimes.add(caporegime);
        }
        
    }

    public void familyPhoto(){
        System.out.println("\n\u001B[31m--------------------------- Family ----------------------------\u001B[0m\n");
        System.out.println("Boss: " + boss.stringify() + "\nUnderboss: " + underboss.stringify() + "\nConsiglieri: " + consiglieri.stringify() + "\n");
    }

    public void showCaporegimes(){
        System.out.println("\n\u001B[32m--------------------------- Caporegimes ----------------------------\u001B[0m\n");
        this.caporegimes.forEach((n) -> System.out.println(n.stringify()));
    }
}
