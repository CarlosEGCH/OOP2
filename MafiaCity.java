import java.util.ArrayList;

class MafiaCity {

    private static ArrayList<Person> citizens;
    private static ArrayList<Family> families;
    private static Metadata metadata;

    public static void createMafiaCity(){
        citizens = new ArrayList<Person>();
        families = new ArrayList<Family>();

        metadata = new Metadata();
        int population = Utils.getRandomNumber(15, 30);
        while(population-- > 0){
            Person newPerson = new Person(metadata.getFileNames(), metadata.getFileItalianLastNames(), metadata.getFileNonItalianLastNames(), metadata.getPersonIds());
            citizens.add(newPerson);
        }

        int amtOfFamilies = Utils.getRandomNumber(2, 5);
        while(amtOfFamilies-- > 0){
            Family newFamily = new Family(metadata);
            families.add(newFamily);
        }


    }

    public static void showFamilies(){
        families.forEach((f) -> f.familyPhoto());
    }

    public static void showCitizens(){
        System.out.println("\n\u001B[33m--------------------------- People ----------------------------\u001B[0m\n");
        citizens.forEach((c) -> System.out.println(c.stringify()));
    }
    public static void main(String[] args) {

        createMafiaCity();
        showFamilies();
        showCitizens();
    }

    
}