/** String processing exercise 2. */
public class UniqueChars {
    public static void main(String[] args) {
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    /**
     * Returns a string which is identical to the original string,
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String s) {
        String noDuplicates = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean isDuplicate = false;

            // Check for duplicates
            for (int j = 0; j < noDuplicates.length(); j++) {
                if (c == noDuplicates.charAt(j)) {
                    isDuplicate = true;
                    break;
                }
            }

            // Add it if it's a space
            if (!isDuplicate || c == ' ') {
                noDuplicates += c;
            }
        }

        return noDuplicates;
    }
}
