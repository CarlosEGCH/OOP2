

class MafiaCity {

    

    public MafiaCity(){
        

    }
    public static void main(String[] args) {
        Metadata metadata = new Metadata();

        Person person = new Person(metadata.getFileNames(), metadata.getFileItalianLastNames(), metadata.getFileNonItalianLastNames(), metadata.getPersonIds());

        System.out.println(person.toString());

    }

    
}