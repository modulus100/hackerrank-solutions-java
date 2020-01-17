package warm.up;

public class JumpingOnTheClouds {

    static int jumpingOnClouds(int[] c) {
        int numOfSteps = 0;

        for (int i = 0; i < c.length - 1; i++) {
            if (i + 2 < c.length) {
                if (nextNextStepFree(i, c)) {
                    i++;
                    numOfSteps++;
                } else if (nextStepFree(i, c)) {
                    numOfSteps++;
                } else {
                    i++;
                }
            } else if (i + 1 < c.length) {
                if (nextStepFree(i, c)) {
                    numOfSteps++;
                }
            } else {
                numOfSteps++;
            }
        }

        return numOfSteps;
    }

    static boolean nextStepFree(int index, int[] arr) {
        return arr[index + 1] != 1;
    }

    static boolean nextNextStepFree(int index, int[] arr) {
        return /*nextStepFree(index, arr) && */arr[index + 2] != 1;
    }
}
