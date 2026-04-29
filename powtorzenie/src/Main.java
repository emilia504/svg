
public class Main {
    public static void main(String[] args) {
        String line = "A09.9          ,5,-,-,-,-,-,-,-,-,-,-,-,-,-,-,1,1,-,2,1,-";

        DeathCauseStatistic stat = DeathCauseStatistic.fromCsvLine(line);

        System.out.println(stat.getIcd10());
        System.out.println(stat.getByAge(52));
    }
}