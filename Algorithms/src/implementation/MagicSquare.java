package implementation;

import java.util.Arrays;

public class MagicSquare {

    private static int[] first = new int[] {0, 0};
    private static int[] second = new int[] {0, 2};
    private static int[] third = new int[] {2, 2};
    private static int[] fourth = new int[] {2, 0};

    public static class FindEdgeResult  {
        int firstMath;
        int[] firstMatchLocation;

        int secondMath;
        int[] secondMatchLocation;

        int thirdMath;
        int[] thirdMatchLocation;

        int fourthMath;
        int[] fourthMatchLocation;
    }

    public static void main(String[] args) {
        int[][] test = {
            {5, 3, 4},
            {1, 5, 8},
            {6, 4, 2}
        };

        FindEdgeResult result = findEdgePatternValue(test);

    }

    static int formingMagicSquare(int[][] s) {
        int numOfPossibleCombinations = 8;
        int minCost = Integer.MAX_VALUE;
        int[][][] combinations = {
                {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
                {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
                {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
                {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
                {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
                {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
                {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
                {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},
        };

        for (int comb = 0; comb < numOfPossibleCombinations; comb++)
        {
            int currentCost = 0;
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                    currentCost += Math.abs(s[i][j] - combinations[comb][i][j]);
            }
            minCost = Math.min(minCost, currentCost);
        }

        return minCost;
    }

    static int computeCost(int[][] s, FindEdgeResult result) {
        int cost = Math.abs(s[1][1] - 5);

        if (result.firstMath != 0) {
            if (result.firstMath == 2) {

            }
        }

        return 0;
    }


    static FindEdgeResult findEdgePatternValue(int[][] s) {
        FindEdgeResult result = new FindEdgeResult();
        int numOfEdges = 4;

        for (int i = 0; i < numOfEdges; i++) {
            int[] indexes = getEdgeIndexes(i);

            int patternValue = getEdgePattern(s, indexes[0], indexes[1]);

            if (patternValue != 0) {
                setMatch(result, indexes, patternValue);
            }

            int opposite = getOpposite(patternValue);

            if (opposite != 0) {
                int[] oppositeIndexes = getOppositeIndexes(indexes);

                if (opposite == s[oppositeIndexes[0]][oppositeIndexes[1]]) {
                    setMatch(result, oppositeIndexes, opposite);
                    return result;
                }
            }
        }

        return null;
    }


    static int[] getOppositeIndexes(int[] indexes) {
        if (Arrays.equals(indexes, first)) return third;
        if (Arrays.equals(indexes, second)) return fourth;
        if (Arrays.equals(indexes, third)) return first;
        if (Arrays.equals(indexes, fourth)) return second;

        return new int[] {};
    }

    static int[] getEdgeIndexes(int i) {
        if (i == 0) return first;
        if (i == 1) return second;
        if (i == 2) return third;
        if (i == 3) return fourth;

        return new int[] {};
    }

    static int getEdgePattern(int[][] s, int i, int j) {
        if (s[i][j] == 2) return 2;
        if (s[i][j] == 4) return 4;
        if (s[i][j] == 6) return 6;
        if (s[i][j] == 8) return 8;

        return 0;
    }

    static int getOpposite(int number) {
        if (number == 2) return 8;
        if (number == 6) return 4;
        if (number == 4) return 6;
        if (number == 8) return 2;

        return 0;
    }

    static int getNeighbour(int number) {
        if (number == 2) return 6;
        if (number == 6) return 2;
        if (number == 4) return 8;
        if (number == 8) return 4;

        return 0;
    }

    static void setMatch(FindEdgeResult result, int[] matchIndexes, int value) {
        if (Arrays.equals(matchIndexes, first)) {
            result.firstMath = value;
            result.firstMatchLocation = matchIndexes;
        }

        if (Arrays.equals(matchIndexes, second)) {
            result.secondMath = value;
            result.secondMatchLocation = matchIndexes;
        }

        if (Arrays.equals(matchIndexes, third)) {
            result.thirdMath = value;
            result.thirdMatchLocation = matchIndexes;
        }

        if (Arrays.equals(matchIndexes, fourth)) {
            result.fourthMath = value;
            result.fourthMatchLocation = matchIndexes;
        }
    }
}
