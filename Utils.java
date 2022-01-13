import java.util.*;

public class Utils {
    
    public static int getRandomNumber(int num){
        return (int)Math.floor( Math.random()*(num + 1));
    }

    public static int getRandomNumber(int min, int max){
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }

    public static void print(String str) {
        System.out.println(str);
    }

    public static void print(int str) {
        System.out.println(str);
    }
}
