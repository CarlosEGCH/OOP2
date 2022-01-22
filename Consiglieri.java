import java.util.ArrayList;
import java.util.Scanner;

public class Consiglieri extends Person{
    
    public Consiglieri(ArrayList<String> names, ArrayList<String> lastItalianName, ArrayList<String> lastNonItalianName, ArrayList<Integer> personIds){
        super(names, lastItalianName, lastNonItalianName, personIds);
    }

    public void expandBusiness(Family family){
        while(true){
            System.out.println("\n\u001B[32mSelect a Caporegime (ccID) to increase a business profit or type 0 to Exit this menu: \u001B[0m\n");
            int index = 1;
            for(Caporegime capo: family.getCaporegimes()){
                    System.out.println(capo.stringify());
            }
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            
            for(Caporegime capo: family.getCaporegimes()){
                if(capo.getPersonId() == option){
                    int random = Utils.getRandomNumber(capo.getBusinesses().size() - 1);
                    System.out.println("The profit of the business "+capo.getBusinesses().get(random).getName()+" increased to "+capo.getBusinesses().get(random).getBaseProfit()*((double)family.getConsiglieri().getStrategist()/100 + 1));
                    capo.getBusinesses().get(random).setBaseProfit(capo.getBusinesses().get(random).getBaseProfit()*(int)((double)family.getConsiglieri().getStrategist()/100 + 1));
                }
            }
            if(option == 0){
                System.out.println("\nLeaving current menu\n");
                return;
            }

            System.out.println("Please select a valid option.");
        }
    }
}