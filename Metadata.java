import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

public class Metadata {

    private ArrayList<String> fileNames;
    private ArrayList<String> fileNonItalianLastNames;
    private ArrayList<String> fileItalianLastNames;
    private ArrayList<Integer> personIds;

    public Metadata(){
        loadData();
    }

    public void loadData(){
        personIds = new ArrayList<Integer>();
        fileNames = downloadData("database/names.txt");
        fileNonItalianLastNames = downloadData("database/nonitalian.txt");
        fileItalianLastNames = downloadData("database/italian.txt");
    }

    public ArrayList<String> downloadData(String url){
        ArrayList<String> upload = new ArrayList<String>();
        
        try{
            File file = new File(url);
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String data = sc.nextLine();
                upload.add(data);
            }
            sc.close();

            
        }catch(FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();;
        }

        return upload;

    }

    public ArrayList<String> getFileNames(){
        return fileNames;
    }

    public ArrayList<String> getFileNonItalianLastNames(){
        return fileNonItalianLastNames;
    }

    public ArrayList<String> getFileItalianLastNames(){
        return fileItalianLastNames;
    }

    public ArrayList<Integer> getPersonIds(){
        return personIds;
    }
}
