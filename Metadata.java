import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

public class Metadata {

    private static ArrayList<String> fileNames;
    private static ArrayList<String> fileNonItalianLastNames;
    private static ArrayList<String> fileItalianLastNames;

    public static void loadData(){
        fileNames = downloadData("names.txt");
        fileNonItalianLastNames = downloadData("italian.txt");
        fileItalianLastNames = downloadData("nonitalian.txt");
    }

    public static ArrayList<String> downloadData(String url){
        ArrayList<String> upload = new ArrayList<String>();

        try{
            File file = new File("database/" + url);
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

    public static ArrayList<String> getFileNames(){
        return fileNames;
    }

    public static ArrayList<String> getFileNonItalianLastNames(){
        return fileNonItalianLastNames;
    }

    public static ArrayList<String> getFileItalianLastNames(){
        return fileItalianLastNames;
    }
}
