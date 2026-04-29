import java.util.List;

public class Main {
    public static void main(String[] args) {
        String line = "A09.9          ,5,-,-,-,-,-,-,-,-,-,-,-,-,-,-,1,1,-,2,1,-";

        DeathCauseStatistic stat = DeathCauseStatistic.fromCsvLine(line);

        System.out.println(stat.getIcd10());
        System.out.println(stat.getByAge(52));

        DeathCauseStatisticList dl = new DeathCauseStatisticList();
        dl.repopulate("zgony.csv");
        List<DeathCauseStatistic> deathCauseStatistics = dl.mostDeadlyDiseases(52, 3);
        for(DeathCauseStatistic dc : deathCauseStatistics) {
            System.out.println(dc.toString());
        }

        ICDCodeTabularOptimizedForTime check1 = new ICDCodeTabularOptimizedForTime();
        System.out.println(check1.getDescription("A02.1"));
        ICDCodeTabularOptimizedForMemory  check2 = new ICDCodeTabularOptimizedForMemory();
        System.out.println(check2.getDescription("A02.1"));
    }
}