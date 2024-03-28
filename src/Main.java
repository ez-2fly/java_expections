import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {

    // Иванов Иван Иванович 12.06.1997 79990001122 m

    public static void main(String[] args) {
        String[] data = prompt();
        if (data[0].equals("0")) System.out.println("data entry error");
        else fileWorker(validityCheck(data));
    }

    public static String[] prompt(){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] res = str.split(" ");
        if (res.length == 6) return res;
        else return new String[]{"0"};
    }

    public static String validityCheck(String[] data){
        try {
            long number = Long.parseLong(data[4]);
        }
        catch (NumberFormatException e){
            throw new RuntimeException("invalid phone number format");
        }

        char gender = data[5].charAt(0);
        if (gender != 'm' && gender != 'f') {
            throw new RuntimeException("invalid gender format");
        }

        if (data[3].charAt(2) != '.' || data[3].charAt(5) != '.' || data[3].length() != 10){
            throw new RuntimeException("invalid date format");
        }

        StringBuilder res = new StringBuilder();
        for (String item : data){
            res.append(item);
            res.append(" ");
        }
        return res.toString();
    }

    public static void fileWorker(String str){
        String[] temp = str.split(" ");
        String path = temp[0] + ".txt";
        try (FileWriter fw = new FileWriter(path, true)){
            fw.write(str + "\n");
        } catch (IOException e) {
            System.out.println(e.fillInStackTrace());
        }
    }

}