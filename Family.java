import java.util.ArrayList;
import java.util.Scanner;

public class Family {
    
    private Gangster boss;
    private Gangster underboss;
    private Consiglieri consiglieri;
    private ArrayList<Caporegime> caporegimes;
    private ArrayList<Person> obituary;
    private int wealth;
    
    private ArrayList<Person> jail;

    private int policeCost;

    /**
     * Constructor method
     * @param metadata
     */
    public Family(Metadata metadata){
        this.obituary = new ArrayList<Person>();
        this.caporegimes = new ArrayList<Caporegime>();
        this.underboss = new Gangster(metadata.getFileNames(), metadata.getFileItalianLastNames(), metadata.getPersonIds());
        this.consiglieri = new Consiglieri(metadata.getFileNames(), metadata.getFileItalianLastNames(), metadata.getFileNonItalianLastNames(), metadata.getPersonIds());
        this.jail = new ArrayList<Person>();

        this.boss = new Gangster(metadata.getFileNames(), metadata.getFileItalianLastNames(), metadata.getPersonIds());
        Gangster underboss = new Gangster(metadata.getFileNames(), metadata.getFileItalianLastNames(), metadata.getPersonIds());
        Consiglieri consiglieri = new Consiglieri(metadata.getFileNames(), metadata.getFileItalianLastNames(), metadata.getFileNonItalianLastNames(), metadata.getPersonIds());

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
        System.out.println("\n\u001B[35m--------------------------- UnderBoss ----------------------------\u001B[0m\n");
        System.out.println(this.underboss.stringify());
    }
    
    public void showConsiglieries(){
        System.out.println("\n\u001B[32m--------------------------- Consiglieri ----------------------------\u001B[0m\n");
        System.out.println(this.consiglieri.stringify());
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
                            this.consiglieri = a.becomeConsiglieri(citizens);
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

    public int getInformantCosts(){
        int costs = 0;
        for(Caporegime capo: caporegimes){
            for(Soldier soldier: capo.getSoldiers()){
                if(soldier.isInformant()){
                    costs += 20;
                }
            }
            if(capo.isInformant()){
                costs += 40;
            }
        }
        return costs;
    }

    public void generateBusinessesForCaporegime(Caporegime caporegime, Business business){

        if(business.getOwnership() == getFamilyName()){
            for(Caporegime capo: getCaporegimes()){
                if(capo.getBusinesses().contains(business)){
                    continue;
                }
                capo.getBusinesses().add(business);
                System.out.println("\n\u001B[42m\u001B[30mBusiness "+ business.getName() +" generated successfully for Caporegime\n\u001B[0m\u001B[0m");
                return;
            }
        }

        if(business.getOwnership() == "none"){
            caporegime.getBusinesses().add(business);
            System.out.println("\n\u001B[42m\u001B[30mBusiness "+ business.getName() +" generated successfully for Caporegime\n\u001B[0m\u001B[0m");
            business.setOwnership("single");
            return;
        }
        if(business.getOwnership() == "single"){
            boolean belongsToFamily = false;
            for(Caporegime capo: getCaporegimes()){
                if(!capo.getBusinesses().contains(business)){
                    continue;
                }

                belongsToFamily = true;
                break;
            }

            if(belongsToFamily){
                for(Caporegime capo: getCaporegimes()){
                    int amt = 0;
                    if(capo.getBusinesses().contains(business)){
                        if(amt == getCaporegimes().size() - 1){
                            System.out.println("\n\u001B[42m\u001B[30mBusiness can't be generated for any Caporegime, try again\n\u001B[0m\u001B[0m");
                            return;
                            }
                            amt++;
                        continue;
                    }
                    
                    capo.getBusinesses().add(business);
                    business.setOwnership(getFamilyName());
                    System.out.println("\n\u001B[42m\u001B[30mBusiness "+ business.getName() +" generated successfully for Caporegime\n\u001B[0m\u001B[0m");
                    return;
                }
            }

            caporegime.getBusinesses().add(business);
            System.out.println("\n\u001B[42m\u001B[30mBusiness "+ business.getName() +" generated successfully for Caporegime\n\u001B[0m\u001B[0m");
            business.setOwnership("shared");
            return;
        }


        if(business.getOwnership() == "shared"){
            System.out.println("\nThis business is already shared by Caporegimes of different families, try another one");
            return;
        }

        System.out.println("\nThis business is already shared by Caporegimes of a whole family.\n");
    }

    public void loyaltyTest(){
        for(Caporegime capo: caporegimes){
            for(Soldier soldier: capo.getSoldiers()){
                if(Utils.getRandomNumber(soldier.getLoyalty()) < 10 && !soldier.isPrisoner()){
                    System.out.println("\nThe soldier "+soldier.getName() + " " + soldier.getFamilyName()+" wasn't on his lucky day.\n");
                    this.obituary.add(soldier);
                    capo.getSoldiers().remove(soldier);
                }
            }
            if(Utils.getRandomNumber(capo.getLoyalty()) < 10 && !capo.isPrisoner()){
                System.out.println("\nThe Caporegime "+capo.getName() + " " + capo.getFamilyName()+" was found guilty.\n");
                this.obituary.add(capo);
                this.caporegimes.remove(capo);
            }
        }
    }

    public void showObituary(){
        System.out.println("\n\u001B[42m\u001B[30m-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|OBITUARY|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|\n\u001B[0m\u001B[0m");
        for(Person person: obituary){
            System.out.println(person.stringify());
        }
    }

    public void showJail(){
        System.out.println("\n\u001B[42m\u001B[30m-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|JAIL|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|\n\u001B[0m\u001B[0m");
        for(Person person: jail){
            System.out.println(person.stringify());
        }
    }

    public void teamSpirit(){
        while(true){
        System.out.println("\n\u001B[32m--------------------------- Caporegimes ----------------------------\u001B[0m\n");
            for(Caporegime capo: caporegimes){
                System.out.println(capo.stringify());
            }
        System.out.println("\n\u001B[32mSelect a Caporegime by it's ccID, or type 0 to Exit this menu\u001B[0m\n");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        if(option == 0){
            System.out.println("Leaving menu");
            return;
        }
        for(Caporegime capo: this.caporegimes){
            if(capo.getPersonId() == option){
                System.out.println("\n\u001B[32m--------------------------- Soldiers of Caporegime "+capo.getName() + " " + capo.getFamilyName()+" ----------------------------\u001B[0m\n");
                for(Soldier soldier: capo.getSoldiers()){
                    System.out.println(soldier.stringify());
                }
                return;
            }
        }
        System.out.println("\nYou must select a valid option! Try again.\n");
        }
    }

    public void costsMap(){
        int total = 0;
        System.out.println("\n\u001B[32m--------------------------- Costs for family "+this.getFamilyName()+" ----------------------------\u001B[0m\n");
        System.out.println("\nMain family cost for the police: $"+this.policeCost+"\n");
        total += this.policeCost;
        for(Caporegime capo: this.caporegimes){
            System.out.println("\nCost for Caporegime "+capo.getName() + " " + capo.getFamilyName()+": $"+capo.getCost()+"\n");
            total += capo.getCost();
            for(Soldier soldier: capo.getSoldiers()){
                System.out.println("\nCost for Soldier "+soldier.getName() + " " + soldier.getFamilyName()+": $"+soldier.getCost()+"\n");
                total += soldier.getCost();
            }
            System.out.println("\nCosts of businesses owned by Caporegime "+capo.getName() + " "+capo.getFamilyName()+"\n");
            for(Business business: capo.getBusinesses()){
                for(Person associate: business.getAssociates()){
                System.out.println("\nCost of Associate "+associate.getName() + " "+associate.getFamilyName()+" owned by Caporegime "+capo.getName() + " "+capo.getFamilyName()+": $"+associate.getCost()+"\n");
                total += associate.getCost();
                }
            }
        }
        System.out.println("\nTotal Family Costs: $"+total+"\n");
    }

    public void releaseGangster(){
        while(true){
            System.out.println("\n\u001B[32mSelect a gangster to release (select by ccID) or type 0 to Exit this menu: \u001B[0m\n");
            for(Person person: jail){
                System.out.println(person.stringify());
            }
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            for(Person person: jail){
                if(person.getPersonId() == option){
                    System.out.println("\n\u001B[32m"+person.getName() + " " + person.getFamilyName()+" has been released!\u001B[0m\n");
                    person.setPrisonerState(false);
                    jail.remove(person);
                    return;
                }
            }
            if(option == 0){
                System.out.println("\nLeaving current menu\n");
                return;
            }

            System.out.println("Please select a valid option.");
        }
    }

    public Caporegime getCaporegime(int index){
        return this.caporegimes.get(index);
    }

    public int getCaporegimesAmt(){
        return this.caporegimes.size();
    }

    public Consiglieri getConsiglieri(){
        return this.consiglieri;
    }

    public Gangster getUnderboss(){
        return this.underboss;
    }

    public void setUnderboss(Gangster underboss){
        this.underboss = underboss;
    }

    public String getFamilyName(){
        return this.boss.getFamilyName();
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

    public ArrayList<Person> getJail(){
        return this.jail;
    }
}
