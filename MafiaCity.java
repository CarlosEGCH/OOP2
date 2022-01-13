import java.util.ArrayList;

class MafiaCity {

    private static ArrayList<Integer> personIds;

    public MafiaCity(){
        personIds = new ArrayList<Integer>();

    }
    public static void main(String[] args) {
        Metadata metadata = new Metadata();
    }

    public static boolean personIdExists(int id){
        return personIds.contains(id);
    }
}