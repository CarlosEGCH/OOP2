import java.util.ArrayList;
import java.util.Scanner;

class MafiaCity {

    private static ArrayList<Person> citizens;
    private static ArrayList<Family> families;
    private static ArrayList<Business> businesses;
    private static ArrayList<Person> jail;
    private static Metadata metadata;
    private static Menu menu;

    
    /**
     * Create Families and population for the city
     */
    public static void createMafiaCity(){
        citizens = new ArrayList<Person>();
        families = new ArrayList<Family>();
        businesses = new ArrayList<Business>();

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

    /**
     * Display the program's menu
     */
    public static void displayMenu(){
        menu = new Menu(citizens);
        menu.displayFamiliesMenu(families, businesses);
    }

    public static void showFamilies(){
        families.forEach((f) -> f.familyPhoto());
    }

    public static void showCitizens(){
        System.out.println("\n\u001B[33m--------------------------- People ----------------------------\u001B[0m\n");
        citizens.forEach((c) -> System.out.println(c.stringify()));
    }

    public static void processSoldiers(){
        families.forEach((f) -> f.familyPhoto());
    }

    public static ArrayList<Person> getCitizens(){
        return citizens;
    }

    public static void generateBusinesses(){
        ArrayList<Business> newBusinesses = new ArrayList<Business>();

        newBusinesses.add(new Business(2000, "Stealing", "intelligence", true, metadata.getFileNames(), metadata.getFileItalianLastNames(), metadata.getFileNonItalianLastNames(), metadata.getPersonIds()));
        newBusinesses.add(new Business(4500, "Extortion", "charism", true, metadata.getFileNames(), metadata.getFileItalianLastNames(), metadata.getFileNonItalianLastNames(), metadata.getPersonIds()));
        newBusinesses.add(new Business(3200, "Black Market", "strategist", true, metadata.getFileNames(), metadata.getFileItalianLastNames(), metadata.getFileNonItalianLastNames(), metadata.getPersonIds()));

        businesses = newBusinesses;
    }

    public static void main(String[] args) {
        createMafiaCity();
        generateBusinesses();
        displayMenu();
    }

    
}