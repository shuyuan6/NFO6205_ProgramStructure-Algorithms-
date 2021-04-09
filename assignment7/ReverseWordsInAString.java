package assignment7;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].length() > 0) {
                sb.append(words[i]).append(" ");
            }
        }

        return sb.toString().substring(0, sb.length() - 1);
    }
}
