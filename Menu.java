import java.util.ArrayList;
import java.util.Scanner;



public class Menu {

    private ArrayList<Person> citizens;
    private ArrayList<Family> families;
    private ArrayList<Person> jail;
    
    public Menu(ArrayList<Person> citizens, ArrayList<Family> families, ArrayList<Person> jail){

        this.citizens = citizens;
        this.families = families;
        this.jail = jail;
    } 

    public void displayFamiliesMenu(ArrayList<Family> families){

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

                    displayMenu(family);
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

    public void displayMenu(Family family){
        
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
                    displayBossMenu(family);
                    break;
                case 2:
                    displayUnderBossMenu(family);
                    break;
                case 3:
                    displayConsiglieriMenu(family);
                    break;
                case 4:
                    displayFamilyMenu(family);
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
                displayMenu(family);
            }
        }
    }

    public void displayBossMenu(Family family){
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
                System.out.println("\n\u001B[42m\u001B[30m successfully recruited\n\u001B[0m\u001B[0m");
                break;
            case 3:
                //Recruit Underboss
                break;
            case 4:
                //Generate business
                break;
            case 5:
                //Nominate consiglieri
                break;
            case 6:
                return;
            default:
                System.out.println("\n\u001B[31mInvalid Option! Try again.\n\u001B[0m");
                break;
        }
        }catch(Exception e){
            System.out.println("You must insert a number ");
            displayBossMenu(family);
        }

    }

    public void displayUnderBossMenu(Family family){
        System.out.println("\u001B[36mMain Menu of the UnderBoss " + family.getFamilyName() + "\n\u001B[0m");
        System.out.println("1. Free Gangster\n");
        System.out.println("2. Business Exploration\n");
        System.out.println("3. Loyalty Test\n");
        System.out.println("4. Exit Menu\n");

        try{
        Scanner sc = new Scanner(System.in);
        int option = 0;
        option = sc.nextInt();

        switch(option){
            case 1:
                //Free Gangster
                break;
            case 2:
                //Business Exploration
                break;
            case 3:
                //Loyalty Test
                break;
            case 4:
                return;
            default:
                System.out.println("\n\u001B[31mInvalid Option! Try again.\n\u001B[0m");
                break;
        }
        }catch(Exception e){
            System.out.println("You must insert a number ");
            displayUnderBossMenu(family);
        }

    }

    public void displayConsiglieriMenu(Family family){
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
                //Expand Business
                break;
            case 2:
                //Mafia Sitdown
                break;
            case 3:
                return;
            default:
                System.out.println("\n\u001B[31mInvalid Option! Try again.\n\u001B[0m");
                break;
        }
        }catch(Exception e){
            System.out.println("You must enter a number ");
            displayConsiglieriMenu(family);
        }

    }
    
    public void displayFamilyMenu(Family family){
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
                family.showCaporegimes();
                break;
            case 2:
                //Business Plan
                break;
            case 3:
                //Costs Map
                break;
            case 4:
                //Team Spirit
                break;
            case 5:
                //Obituary
                break;
            case 6:
                //Jailed
                break;
            case 7:
                //All Out War
                break;
            case 8:
                return;
            default:
                System.out.println("\n\u001B[31mInvalid Option! Try again.\n\u001B[0m");
                break;
        }
        }catch(Exception e){
            System.out.println("You must enter a number");
            displayFamilyMenu(family);
        }

    }
}
