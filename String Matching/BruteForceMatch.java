public class BruteForceMatch {
    public static int match(String text, String pattern) {
        int n = text.length(), m = pattern.length();

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j))
                    break;
            }
            if (j == m)
                return i; // Match found
        }
        return -1; // No match
    }

    public static void main(String[] args) {
        String text = "ABAAABCDBBABCDDEBCABC";
        String pattern = "ABC";
        int index = match(text, pattern);

        if (index != -1)
            System.out.println("Pattern found at index: " + index);
        else
            System.out.println("Pattern not found.");
    }
}
