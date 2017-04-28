import java.io.FileNotFoundException;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Created by u1939670 on 27/04/17.
 */
public class testMain {
    public static void main(String[] args) {
        try{
            DadesAgencia a = new DadesAgencia("test.txt");
            a.llegirDadesFitxer();
        }catch(FileNotFoundException a){
            System.out.println("ei!");
        }

    }
}
