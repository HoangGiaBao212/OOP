import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class test {
    private static boolean checkDayExpire(String any,String thing){
        if(any == "" || thing == ""){
            return false;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        Date date1 = null;
        try{
            date = dateFormat.parse(any);
            date1 = dateFormat.parse(thing);
            if(date.after(date1)){
                return false;
            }
            else{
                return true;
            }
        }catch(ParseException e){
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String temp,tmp;
        // temp = scanner.nextLine();
        // tmp = scanner.nextLine();
        if(!checkDayExpire("12-5-2010","12-6-2010")){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }
        scanner.close();
    }
}