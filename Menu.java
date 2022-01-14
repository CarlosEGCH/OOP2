import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    
    public Menu(){

    } 

    public void displayFamiliesMenu(ArrayList<Family> families){

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
        int option = 0;
        while(option != 5){
            System.out.println("\u001B[36mMain Menu of the Family " + family.getFamilyName() + "\u001B[0m\n");
            System.out.println("1. Boss Menu\n");
            System.out.println("2. UnderBoss Menu\n");
            System.out.println("3. Consiglieri Menu\n");
            System.out.println("4. Family Menu\n");
            System.out.println("5. Exit Menu\n");

            Scanner sc = new Scanner(System.in);
            option = sc.nextInt();

            switch(option){
                case 1:
                    displayBossMenu(family);
                    break;
                case 2:
                    //Option 2
                    break;
                case 3:
                    //Option 3
                    break;
                case 4:
                    //Option 4
                    break;
                case 5:
                    System.out.println("\n\u001B[31mGoing back\n\u001B[0m");
                    break;
                default:
                    System.out.println("\n\u001B[31mInvalid Option! Try again.\n\u001B[0m");
                    break;
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

        Scanner sc = new Scanner(System.in);
        int option = 0;
        option = sc.nextInt();

        switch(option){
            case 1:
                //Recruit Soldier
                break;
            case 2:
                //Recruit Caporegime
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
            default:
                System.out.println("Invalid option");
                break;
        }

    }

    public void displayUnderbossMenu(){

    }
    
}
