package assignment5_SearchingSortingPart2;

public class ReorganizeString {
    public int findMost(int[] arr, char chr) {
        int most = 0;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > most && (char)(i + 'a') != chr) {
                most = arr[i];
                index = i;
            }
        }
        return index;
    }

    public String reorganizeString(String S) {
        int[] countMap = new int[26];
        for (char chr : S.toCharArray()) {
            countMap[chr - 'a']++;
        }

        char[] newString = new char[S.length()];

        for (int i = 0; i < S.length(); i++) {
            if (i == 0) {
                int most = findMost(countMap, '%');
                newString[0] = (char)(most + 'a');
                countMap[most]--;
            } else {
                int mostCountIndex = findMost(countMap, newString[i - 1]);
                if (mostCountIndex == -1) {
                    return "";
                }
                newString[i] = (char)('a' + mostCountIndex);
                countMap[mostCountIndex]--;
            }
        }

        return new String(newString);
    }
}
