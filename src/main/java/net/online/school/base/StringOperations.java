package net.online.school.base;

public class StringOperations {

    public static int getSummaryLength(String[] strings) {
        int count = 0;
        for (String string : strings) {
            count += string.length();
        }
        return count;
    }

    public static String getFirstAndLastLetterString(String string) {
        return "" + string.charAt(0) + string.charAt(string.length() - 1);
    }

    public static boolean isSameCharAtPosition(String string1, String string2, int index) {
        return string1.charAt(index) == string2.charAt(index);
    }

    public static boolean isSameFirstCharPosition(String string1, String string2, char character) {
        return string1.indexOf(character) == string2.indexOf(character);
    }

    public static boolean isSameLastCharPosition(String string1, String string2, char character) {
        return string1.lastIndexOf(character) == string2.lastIndexOf(character);
    }

    public static boolean isSameFirstStringPosition(String string1, String string2, String str) {
        return string1.indexOf(str) == string2.indexOf(str);
    }

    public static boolean isSameLastStringPosition(String string1, String string2, String str) {
        return string1.lastIndexOf(str) == string2.lastIndexOf(str);
    }

    public static boolean isEqual(String string1, String string2) {
        return string1.equals(string2);
    }

    public static boolean isEqualIgnoreCase(String string1, String string2) {
        return string1.equalsIgnoreCase(string2);
    }

    public static boolean isLess(String string1, String string2) {
        return string1.compareTo(string2) < 0;
    }

    public static boolean isLessIgnoreCase(String string1, String string2) {
        return string1.compareToIgnoreCase(string2) < 0;
    }

    public static String concat(String string1, String string2) {
        return string1 + string2;
    }

    public static boolean isSamePrefix(String string1, String string2, String prefix) {
        return string1.startsWith(prefix) && string2.startsWith(prefix);
    }

    public static boolean isSameSuffix(String string1, String string2, String suffix) {
        return string1.endsWith(suffix) && string2.endsWith(suffix);
    }

    public static String getCommonPrefix(String string1, String string2) {
        StringBuilder commonPrefix = new StringBuilder();
        for (int i = 0; i < string1.length() && i < string2.length() && isSameCharAtPosition(string1, string2, i); i++) {
            commonPrefix.append(string1.charAt(i));
        }
        return commonPrefix.toString();
    }

    public static String reverse(String string) {
        StringBuilder temp = new StringBuilder(string);
        return temp.reverse().toString();
    }

    public static boolean isPalindrome(String string) {
        return string.equals(reverse(string));
    }

    public static boolean isPalindromeIgnoreCase(String string) {
        return string.equalsIgnoreCase(reverse(string));
    }

    public static String getLongestPalindromeIgnoreCase(String[] strings) {
        String longestPalindrome = "";
        for (String elem : strings) {
            if (isPalindromeIgnoreCase(elem) && elem.length() > longestPalindrome.length()) {
                longestPalindrome = elem;
            }
        }
        return longestPalindrome;
    }

    public static boolean hasSameSubstring(String string1, String string2, int index, int length) {
        return string1.regionMatches(index, string2, index, length);
    }

    public static boolean isEqualAfterReplaceCharacters(String string1, char replaceInStr1, char replaceByInStr1, String string2, char replaceInStr2, char replaceByInStr2) {
        return string1.replace(replaceInStr1, replaceByInStr1).equals(string2.replace(replaceInStr2, replaceByInStr2));
    }

    public static boolean isEqualAfterReplaceStrings(String string1, String replaceInStr1, String replaceByInStr1, String string2, String replaceInStr2, String replaceByInStr2) {
        return string1.replace(replaceInStr1, replaceByInStr1).equals(string2.replace(replaceInStr2, replaceByInStr2));
    }

    public static boolean isPalindromeAfterRemovingSpacesIgnoreCase(String string) {
        return isPalindromeIgnoreCase(string.replace(" ", ""));
    }

    public static boolean isEqualAfterTrimming(String string1, String string2) {
        return string1.trim().equals(string2.trim());
    }

    public static String makeCsvStringFromInts(int[] array) {
        StringBuilder string = new StringBuilder();
        for (int elem : array) {
            string.append(elem + ",");
        }
        String string1 = string.toString();
        if (string1.endsWith(",")) {
            string1 = string1.substring(0, string1.length() - 1);
        }
        return string1;
    }

    public static String makeCsvStringFromDoubles(double[] array) {
        StringBuilder string = new StringBuilder();
        for (double elem : array) {
            string.append(String.format("%.2f", elem) + ",");
        }
        String string1 = string.toString();
        if (string1.endsWith(",")) {
            string1 = string1.substring(0, string1.length() - 1);
        }
        return string1;
    }

    public static StringBuilder makeCsvStringBuilderFromInts(int[] array) {
        StringBuilder string = new StringBuilder();
        for (int elem : array) {
            string.append(elem + ",");
        }
        if (string.length() == 0) {
            return string;
        }
        int a = string.length() - 1;
        string.delete(a, a + 1);
        return string;
    }

    public static StringBuilder makeCsvStringBuilderFromDoubles(double[] array) {
        StringBuilder string = new StringBuilder();
        for (double elem : array) {
            string.append(String.format("%.2f", elem) + ",");
        }
        if (string.length() == 0) {
            return string;
        }
        int a = string.length() - 1;
        string.delete(a, a + 1);
        return string;
    }

    public static StringBuilder removeCharacters(String string, int[] positions) {
        StringBuilder string1 = new StringBuilder(string);
        for (int i = positions.length - 1; i >= 0; i--) {
            string1.delete(positions[i], positions[i] + 1);
        }
        return string1;
    }

    public static StringBuilder insertCharacters(String string, int[] positions, char[] characters) {
        StringBuilder string1 = new StringBuilder(string);
        for (int i = positions.length - 1; i >= 0; i--) {
            string1.insert(positions[i], characters[i]);
        }
        return string1;
    }
}
