import java.util.ArrayList;
import java.util.Scanner;

public class Family {
    
    private Gangster boss;
    private ArrayList<Gangster> underbosses;
    private ArrayList<Consiglieri> consiglieries;
    private ArrayList<Caporegime> caporegimes;
    private int wealth;

    private int policeCost;

    /**
     * Constructor method
     * @param metadata
     */
    public Family(Metadata metadata){
        this.caporegimes = new ArrayList<Caporegime>();
        this.underbosses = new ArrayList<Gangster>();
        this.consiglieries = new ArrayList<Consiglieri>();

        this.boss = new Gangster(metadata.getFileNames(), metadata.getFileItalianLastNames(), metadata.getPersonIds());
        Gangster underboss = new Gangster(metadata.getFileNames(), metadata.getFileItalianLastNames(), metadata.getPersonIds());
        this.underbosses.add(underboss);
        Consiglieri consiglieri = new Consiglieri(metadata.getFileNames(), metadata.getFileItalianLastNames(), metadata.getFileNonItalianLastNames(), metadata.getPersonIds());
        this.consiglieries.add(consiglieri);

        int index = Utils.getRandomNumber(2, 4);
        while(index-- > 0){
            Caporegime caporegime = new Caporegime(metadata.getFileNames(), metadata.getFileItalianLastNames(), metadata.getPersonIds());
            this.caporegimes.add(caporegime);
        }

        this.policeCost = Utils.getRandomNumber(200,500);
        
    }

    public void familyPhoto(){
        System.out.println("\n\u001B[31m--------------------------- Family ---- Wealth: "+ getWealth() +" ----------------------------\u001B[0m\n");
        System.out.println("Boss: " + boss.stringify() + "\n");
    }

    public void showCaporegimes(){
        System.out.println("\n\u001B[32m--------------------------- Caporegimes ----------------------------\u001B[0m\n");
        this.caporegimes.forEach((n) -> System.out.println(n.stringify()));
    }

    public void showUnderBosses(){
        System.out.println("\n\u001B[35m--------------------------- UnderBosses ----------------------------\u001B[0m\n");
        this.underbosses.forEach((n) -> System.out.println(n.stringify()));
    }
    
    public void showConsiglieries(){
        System.out.println("\n\u001B[32m--------------------------- Consiglieries ----------------------------\u001B[0m\n");
        for(Consiglieri c: getConsiglieries()){
            System.out.println("\n"+c.stringify()+"\n");
        }
    }

    public void showBusinesses(){
        for(Caporegime caporegime: caporegimes){
        System.out.println("\n\u001B[32m--------------------------- Businesses for Caporegime "+ caporegime.getName() + " " + caporegime.getFamilyName() +"----------------------------\u001B[0m\n");
            for(Business business: caporegime.getBusinesses()){
            System.out.println("\n        "+business.getName()+"        \n");
            System.out.println("\n\u001B[33m----------------------------Associates:-----------------------------------\u001B[0m\n");
                for(Person associate: business.getAssociates()){
                    System.out.println("\n"+associate.stringify()+"\n");
                }
            }

        }
    }

    public void nominateConsiglieri(ArrayList<Person> citizens){
        while(true){
            showBusinesses();
            System.out.println("\nChoose an associate (ccID) to nominate as Consiglieri, or type 0 to leave\n");

            int option;
            Scanner sc = new Scanner(System.in);
            option = sc.nextInt();

            for(Caporegime c: caporegimes){
                for(Business b: c.getBusinesses()){
                    for(Person a:b.getAssociates()){
                        if(option == a.getPersonId()){
                            this.getConsiglieries().add(a.becomeConsiglieri(citizens));
                            System.out.println("\n\u001B[46m\u001B[30m"+a.getName() + " " + a.getFamilyName()+" was nominated as Consiglieri\u001B[30m\u001B[0m\n");
                            b.getAssociates().remove(a);
                            return;
                        }
                    }
                }
            }

            if(option == 0){
                System.out.println("\nLeaving current menu\n");
                break;
            }

            System.out.println("\n\u001B[41mInvalid input\u001B[0m\n");
        }
    }

    public void generateBusinessesForCaporegime(Caporegime caporegime, Business business){
        caporegime.getBusinesses().add(business);
    }

    public Caporegime getCaporegime(int index){
        return this.caporegimes.get(index);
    }

    public int getCaporegimesAmt(){
        return this.caporegimes.size();
    }

    public ArrayList<Consiglieri> getConsiglieries(){
        return this.consiglieries;
    }

    public ArrayList<Gangster> getUnderbosses(){
        return this.underbosses;
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

    public int getWealth(){
        return this.wealth;
    }

    public void setWealth(int wealth){
        this.wealth = wealth;
    }

    public int getPoliceCost() {
        return policeCost;
    }

    public void setPoliceCost(int policeCost) {
        this.policeCost = policeCost;
    }
}
