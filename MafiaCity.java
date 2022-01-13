import java.util.ArrayList;

class MafiaCity {

    private static ArrayList<Integer> personIds;

    public MafiaCity(){
        personIds = new ArrayList<Integer>();

    }
    public static void main(String[] args) {
        Metadata.loadData();

        Person person = new Person();

        person.toString();

    }

    public static boolean personIdExists(int id){
        return personIds.contains(id);
    }

    public static ArrayList<Integer> getPersonIds(){
        return personIds;
    }
}