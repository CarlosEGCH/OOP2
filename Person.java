import java.util.ArrayList;

public class Person {

    private String name;
    private String family;
    private boolean lineage;
    private int personId;
    private int behaviour;

    public Person(){

        this.name = Metadata.getFileNames().get(Utils.getRandomNumber(Metadata.getFileNames().size()));

        if(Utils.getRandomNumber(10) > 5){
            this.lineage = true;

            int size = Metadata.getFileItalianLastNames().size();
            int index = Utils.getRandomNumber(size);
            this.family = Metadata.getFileItalianLastNames().get(index);
        }else{
            this.lineage = false;

            int size = Metadata.getFileNonItalianLastNames().size();
            int index = Utils.getRandomNumber(size);
            this.family = Metadata.getFileNonItalianLastNames().get(index);
        }

        while(personId == 0){
            int newId = Utils.getRandomNumber(999999999);

            if(MafiaCity.getPersonIds() == null){
                this.personId = newId;
                MafiaCity.getPersonIds().add(newId);
            }
            if(!MafiaCity.personIdExists(newId)){
                this.personId = newId;
                MafiaCity.getPersonIds().add(newId);
            }

        }

        this.behaviour = Utils.getRandomNumber(100);

    }

    public String toString(){
        String info;
        info = "Name: " + name + " ccId: " + personId + " Lineage: " + lineage + " Behaviour: " + behaviour + " Family: " + family;
        return info;
    }

}
