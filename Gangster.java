import java.util.ArrayList;

public class Gangster extends Person {

    public Gangster(ArrayList<String> names, ArrayList<String> lastItalianName, ArrayList<Integer> personIds){
        super(names, lastItalianName, personIds);
    }

    public void accountingPeriod(Family family){
        int jailBeforeExploration = family.getJail().size();
        for(Caporegime capo: family.getCaporegimes()){
            capo.exploration(family);
            if(jailBeforeExploration != family.getJail().size()){
                System.out.println("\n\u001B[42mA casualty has occurred and someone went to jail\u001B[0m");
                jailBeforeExploration = family.getJail().size();
                //Punishment must be applied to the underboss
                this.setCost(this.getCost() + Utils.getRandomNumber(10, 50));
                continue;
            }
            System.out.println("\nBusiness explored successfully by Caporegime "+capo.getName() + " "+ capo.getFamilyName() +"\n");
        }

        family.loyaltyTest();
        System.out.println("\nAccounting period has been performed for family "+family.getFamilyName()+".\n");
    }
}