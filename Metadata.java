import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

public class Metadata {

    private ArrayList<String> fileNames;
    private ArrayList<String> fileNonItalianLastNames;
    private ArrayList<String> fileItalianLastNames;


    public Metadata(){
        fileNames = new ArrayList<String>();
        downloadNames();
    }

    public void downloadNames(){
        try{
            File file = new File("database/names.txt");
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String data = sc.nextLine();
                fileNames.add(data);
            }
            sc.close();
        }catch(FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();;
        }
    }

    public void downloadLastNames(){
        try{
            File file = new File("database/nonitalian.txt");
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String data = sc.nextLine();
                fileNonItalianLastNames.add(data);
            }
            sc.close();
        }catch(FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();;
        }
    }

    public void downloadItalianLastNames(){
        try{
            File file = new File("database/italian.txt");
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String data = sc.nextLine();
                fileItalianLastNames.add(data);
            }
            sc.close();
        }catch(FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();;
        }
    }

}
