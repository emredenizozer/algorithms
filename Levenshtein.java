import java.util.Arrays;

public class Levenshtein {
    public static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public static int levenshtein(String token1, String token2) {
        if (token1 == null && token2 == null)
            return -1;

        if (token1 == null || token1.isEmpty())
            return token2.length();

        if (token2 == null || token2.isEmpty())
            return token1.length();

        int diagonal = 0;
        int up = 1;
        int left = 1;

        int shortTokenLength;
        int longTokenLength;

        String shortToken;
        String longToken;

        if (token1.length() <= token2.length()) {
            shortToken = token1.trim();
            longToken = token2.trim();
            shortTokenLength = shortToken.length() + 1;
            longTokenLength = longToken.length() + 1;
        } else {
            shortToken = token2.trim();
            longToken = token1.trim();
            shortTokenLength = shortToken.length() + 1;
            longTokenLength = longToken.length() + 1;
        }

        int distanceArray[] = new int[longTokenLength];

        Arrays.setAll(distanceArray, p -> p);

        for (int i = 1; i < shortTokenLength; i++) {
            diagonal = i - 1;
            left = i;
            up = distanceArray[1];
            distanceArray[0] = left;

            for (int j = 1; j < longTokenLength; j++) {

                if(longToken.charAt(j - 1) == shortToken.charAt(i - 1)) {
                    up = distanceArray[j];
                    distanceArray[j] = diagonal;
                    diagonal = up;
                    left = distanceArray[j];
                } else {
                    up = distanceArray[j];
                    distanceArray[j] = min(left, diagonal, up) + 1;
                    diagonal = up;
                    left = distanceArray[j];
                }
            }

        }

        return distanceArray[longTokenLength - 1];
    }

    public static int levenshtein(String token1, String token2, int maxDist) {
        if (token1 == null && token2 == null)
            return -1;

        if (token1 == null || token1.isEmpty())
            return token2.length();

        if (token2 == null || token2.isEmpty())
            return token1.length();

        int minimum = 0;
        int localMinimum = 0;
        int diagonal = 0;
        int up = 1;
        int left = 1;

        int shortTokenLength;
        int longTokenLength;

        String shortToken;
        String longToken;

        if (token1.length() <= token2.length()) {
            shortToken = token1;
            longToken = token2;
            shortTokenLength = token1.length() + 1;
            longTokenLength = token2.length() + 1;
        } else {
            shortToken = token2;
            longToken = token1;
            shortTokenLength = token2.length() + 1;
            longTokenLength = token1.length() + 1;
        }

        int distanceArray[] = new int[longTokenLength];

        Arrays.setAll(distanceArray, p -> p);

        for (int i = 1; i < shortTokenLength; i++) {
            if (minimum > maxDist) {
                return maxDist + 1;
            }

            diagonal = i - 1;
            left = i;
            up = distanceArray[1];
            distanceArray[0] = left;
            localMinimum = min(left, diagonal, up);

            for (int j = 1; j < longTokenLength; j++) {
                up = distanceArray[j];

                if(longToken.charAt(j - 1) == shortToken.charAt(i - 1)) {
                    distanceArray[j] = diagonal;
                    diagonal = up;
                    left = distanceArray[j];
                } else {
                    distanceArray[j] = min(left, diagonal, up) + 1;
                    diagonal = up;
                    left = distanceArray[j];
                }

                if (localMinimum > distanceArray[j]) {
                    localMinimum = distanceArray[j];
                }

                if ((j == longTokenLength -1) && minimum < localMinimum) {
                    minimum = localMinimum;
                }
            }

        }

        return distanceArray[longTokenLength - 1];
    }

    public static void main(String[] args) {
        System.out.println(levenshtein("Haus", "Maus"));
        System.out.println(levenshtein("Haus", "Mausi"));
        System.out.println(levenshtein("Haus", "Häuser"));
        System.out.println(levenshtein("Kartoffelsalat", "Runkelrüben"));

        System.out.println(levenshtein("Haus", "Maus", 2));
        System.out.println(levenshtein("Haus", "Mausi", 2));
        System.out.println(levenshtein("Haus", "Häuser", 2));
        System.out.println(levenshtein("Kartoffelsalat", "Runkelrüben", 2));
    }

}
