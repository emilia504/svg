import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ICDCodeTabularOptimizedForTime implements ICDCodeTabular{
    File file = new File("icd10.txt");

    //do dokończenia!

    @Override
    public String getDescription(String code) {
        try {
            Scanner scanner = new Scanner(file);
            String sum;
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                if(line.contains(code)){
                    scanner.close();
                    return line;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return "Wrong data";
    }
}
