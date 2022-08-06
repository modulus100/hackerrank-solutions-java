package warm.up;

public class CountingValleys {

    static int countingValleys(int n, String s) {
        int seaLevel = 0;
        int numOfValleys = 0;

        for (char currentStep : s.toCharArray()) {
            if (currentStep == 'U') {
                seaLevel++;
            } else {
                seaLevel--;
            }

            if (seaLevel == 0 && currentStep == 'U') {
                numOfValleys++;
            }
        }

        return numOfValleys;
    }
}
