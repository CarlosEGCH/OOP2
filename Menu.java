import java.util.ArrayList;
import java.util.Scanner;



public class Menu {

    private ArrayList<Person> citizens;
    
    public Menu(ArrayList<Person> citizens){

        this.citizens = citizens;
    } 

    public void displayFamiliesMenu(ArrayList<Family> families, ArrayList<Business> businesses){

        System.out.println("╔╦══╦═╦═╦╦═╦═╦╦╦╦═══╗\n║║║║╠═╣╩╬╬═╣╔╬╬╣╠╦╦╗║\n║║║║╠╝║╦╣╠╝║╚╣╠╗╔╣║║║\n║╚╩╩╩═╩╝╚╩═╩═╩╝╚═╬╗║║\n╚════════════════╩═╩╝");

        String option = "";
        while(option.equals("")){
        System.out.println("\n\u001B[32mList of Families:\n\u001B[0m");
        int index = 0;
        ArrayList<String> familyNames = new ArrayList<String>();

        for(Family family: families){
            familyNames.add(family.getFamilyName());
            System.out.println("" + ++index + ". " + family.getFamilyName() + "\n");
        }

        System.out.println(++index + ". Exit\n");

            Scanner sc = new Scanner(System.in);
            option = sc.nextLine();

            for(Family family: families){

                if(familyNames.contains(option) && family.isFamily(option)){

                    displayMenu(family, businesses, families);
                    option = "";
                    break;

                }else if(option.equals("Exit")){

                    System.out.println("Thanks!");
                    System.exit(0);
                    
                }else if(!familyNames.contains(option)){

                    System.out.println("That family doesn't exist. Try again.");
                    option = "";
                    break;

                }

            }
            
        }
        

    }

    public void doMafiaSitdown(ArrayList<Family> families){
        for(Family family: families){
            family.mafiaSitdown();
        }
    }

    public void doAllOutWar(ArrayList<Family> families){
        for(Family family: families){
            family.allOutWar();
        }
    }

    public void displayMenu(Family family, ArrayList<Business> businesses, ArrayList<Family> families){
        
        while(true){
            int option = 0;
            System.out.println("\u001B[36mMain Menu of the Family " + family.getFamilyName() + "\u001B[0m\n");
            System.out.println("1. Boss Menu\n");
            System.out.println("2. UnderBoss Menu\n");
            System.out.println("3. Consiglieri Menu\n");
            System.out.println("4. Family Menu\n");
            System.out.println("5. Exit Menu\n");

            try{
                Scanner sc = new Scanner(System.in);
                option = sc.nextInt();

            switch(option){
                case 1:
                    displayBossMenu(family, businesses);
                    break;
                case 2:
                    displayUnderBossMenu(family, businesses);
                    break;
                case 3:
                    displayConsiglieriMenu(family, families);
                    break;
                case 4:
                    displayFamilyMenu(family, families);
                    break;
                case 5:
                    System.out.println("\n\u001B[31mGoing back\n\u001B[0m");
                    return;
                default:
                    System.out.println("\n\u001B[31mInvalid Option! Try again.\n\u001B[0m");
                    option = 0;
                    break;
            }
            }catch(Exception e){
                System.out.println("You must insert a number ");
                displayMenu(family, businesses, families);
            }
        }
    }

    public void displayBossMenu(Family family, ArrayList<Business> businesses){
        System.out.println("\u001B[36mMain Menu of the Boss " + family.getFamilyName() + "\n\u001B[0m");
        System.out.println("1. Recruit Soldier\n");
        System.out.println("2. Recruit CapoRegime\n");
        System.out.println("3. Recruit Underboss\n");
        System.out.println("4. Generate Business for CapoRegime\n");
        System.out.println("5. Nominate Consiglieri\n");
        System.out.println("6. Exit Menu\n");

        try{
        Scanner sc = new Scanner(System.in);
        int option = 0;
        option = sc.nextInt();

        switch(option){
            case 1:
                family.getBoss().recruitSoldiers(citizens, family);
                System.out.println("\n\u001B[42m\u001B[30mSoldier successfully recruited\n\u001B[0m\u001B[0m");
                break;
            case 2:
                family.getBoss().recruitCaporegimes(citizens, family);
                System.out.println("\n\u001B[42m\u001B[30mCaporegime successfully recruited\n\u001B[0m\u001B[0m");
                break;
            case 3:
                family.getBoss().recruitUnderBosses(citizens, family);
                System.out.println("\n\u001B[42m\u001B[30mUnderboss successfully recruited\n\u001B[0m\u001B[0m");
                break;
            case 4:
                int randomCapo = Utils.getRandomNumber(family.getCaporegimesAmt() - 1);
                int randomBusiness = Utils.getRandomNumber(businesses.size() - 1);
                family.generateBusinessesForCaporegime(family.getCaporegimes().get(Utils.getRandomNumber(randomCapo)), businesses.get(randomBusiness));
                break;
            case 5:
                family.nominateConsiglieri(citizens);
                break;
            case 6:
                return;
            default:
                System.out.println("\n\u001B[31mInvalid Option! Try again.\n\u001B[0m");
                break;
        }
        }catch(Exception e){
            System.out.println("You must insert a number. ERROR CODE: " + e.getMessage());
            displayBossMenu(family, businesses);
        }

    }

    public void displayUnderBossMenu(Family family, ArrayList<Business> businesses){
        System.out.println("\u001B[36mMain Menu of the UnderBoss " + family.getFamilyName() + "\n\u001B[0m");
        System.out.println("1. Release Gangster\n");
        System.out.println("2. Business Exploration\n");
        System.out.println("3. Loyalty Test\n");
        System.out.println("4. Exit Menu\n");

        try{
        Scanner sc = new Scanner(System.in);
        int option = 0;
        option = sc.nextInt();

        switch(option){
            case 1:
                family.releaseGangster();
                break;
            case 2:
                family.getUnderboss().accountingPeriod(family);
                break;
            case 3:
                family.loyaltyTest();
                System.out.println("\n\u001B[42m\u001B[30mLoyalty test has been performed\n\u001B[0m\u001B[0m");
                break;
            case 4:
                return;
            default:
                System.out.println("\n\u001B[31mInvalid Option! Try again.\n\u001B[0m");
                break;
        }
        }catch(Exception e){
            System.out.println("You must insert a number ");
            displayUnderBossMenu(family, businesses);
        }

    }

    public void displayConsiglieriMenu(Family family, ArrayList<Family> families){
        System.out.println("\u001B[36mMain Menu of the Consiglieri " + family.getFamilyName() + "\n\u001B[0m");
        System.out.println("1. Expand Business\n");
        System.out.println("2. Mafia Sitdown\n");
        System.out.println("3. Exit Menu\n");

        try{
        Scanner sc = new Scanner(System.in);
        int option = 0;
        option = sc.nextInt();

        switch(option){
            case 1:
                family.getConsiglieri().expandBusiness(family);
                break;
            case 2:
                doMafiaSitdown(families);
                break;
            case 3:
                return;
            default:
                System.out.println("\n\u001B[31mInvalid Option! Try again.\n\u001B[0m");
                break;
        }
        }catch(Exception e){
            System.out.println("You must enter a number ");
            displayConsiglieriMenu(family, families);
        }

    }
    
    public void displayFamilyMenu(Family family, ArrayList<Family> families){
        System.out.println("\u001B[36mMain Menu of the family " + family.getFamilyName() + "\n\u001B[0m");
        System.out.println("1. Family Photo\n");
        System.out.println("2. Business Plan\n");
        System.out.println("3. Costs Map\n");
        System.out.println("4. Team Spirit\n");
        System.out.println("5. Obituary\n");
        System.out.println("6. Jailed\n");
        System.out.println("7. All Out War\n");
        System.out.println("8. Exit\n");

        try{
        Scanner sc = new Scanner(System.in);
        int option = 0;
        option = sc.nextInt();

        switch(option){
            case 1:
                family.familyPhoto();
                family.showUnderBosses();
                family.showConsiglieries();
                family.showCaporegimes();
                break;
            case 2:
                family.showBusinesses();
                break;
            case 3:
                family.costsMap();
                break;
            case 4:
                family.teamSpirit();
                break;
            case 5:
                family.showObituary();
                break;
            case 6:
                family.showJail();
                break;
            case 7:
                doAllOutWar(families);
                break;
            case 8:
                return;
            default:
                System.out.println("\n\u001B[31mInvalid Option! Try again.\n\u001B[0m");
                break;
        }
        }catch(Exception e){
            System.out.println("You must enter a number");
            displayFamilyMenu(family, families);
        }

    }
}
