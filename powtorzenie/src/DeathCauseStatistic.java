import java.util.Arrays;

public class DeathCauseStatistic {
    public record AgeBracketDeaths(int young, int old, int deathCount) {}


    private String icd10;

    private int[] deathByAge;

    public DeathCauseStatistic(String icd10, int[] deathByAge) {
        this.icd10 = icd10;
        this.deathByAge = deathByAge;
    }

    public void setIcd10(String icd10) {
        this.icd10 = icd10;
    }

    public String getIcd10() {
        return icd10;
    }
    public AgeBracketDeaths getByAge(int age)
    {
        int low, high;
        low = age / 5 * 5;
        high = low + 4;
        return new AgeBracketDeaths(low, high, deathByAge[age / 5]);
    }

    @Override
    public String toString() {
        return "DeathCauseStatistic{" +
                "icd10='" + icd10 + '\'' +
                ", deathByAge=" + Arrays.toString(deathByAge) +
                '}';
    }

    public static DeathCauseStatistic fromCsvLine(String line) {

        String[] parts = line.split(",");

        String icd10 = parts[0].trim();

        int[] deathByAge = new int[parts.length - 2];

        for (int i = 2; i < parts.length; i++) {
            String value = parts[i];

            if ("-".equals(value) || value.isEmpty()) {
                deathByAge[i-2] = 0;
            } else {
                deathByAge[i-2] = Integer.parseInt(value.trim());
            }
        }

        return new DeathCauseStatistic(icd10, deathByAge);


    }
}
