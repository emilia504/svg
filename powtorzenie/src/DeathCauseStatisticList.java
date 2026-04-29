import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DeathCauseStatisticList {
    public ArrayList<DeathCauseStatistic> stat_list = new ArrayList<DeathCauseStatistic>();

    public void repopulate(String path){
        stat_list.clear();

        File file = new File(path);
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        scan.nextLine();
        scan.nextLine();

        while(scan.hasNextLine()){
            stat_list.add(DeathCauseStatistic.fromCsvLine(scan.nextLine()));
        }
    }

    public List<DeathCauseStatistic> mostDeadlyDiseases(int age, int n){
        ArrayList<DeathCauseStatistic> found = stat_list;
        found.sort(Comparator.comparing(c_stat -> c_stat.getByAge(age).deathCount()));

        return found.subList(0, n);
    }
}
