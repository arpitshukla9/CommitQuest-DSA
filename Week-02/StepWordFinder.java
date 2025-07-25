
import java.util.*;
public class StepWordFinder {
    // ---------- Brute Force Approach ----------
    // Try every letter, generate all permutations (n!), check in dictionary (O(1) via HashSet)
    // Time: O(26 * (L+1)!) where L = length of input word
    // Space: O((L+1)!) for storing permutations (worst case)
    public List<String> bruteForceStepWords(String word, Set<String> dictionary) {
        Set<String> result = new HashSet<>();
        for (char c = 'a'; c <= 'z'; c++) {
            String extended = word + c;
            List<String> permutations = new ArrayList<>();
            generatePermutations(extended.toCharArray(), 0, permutations);
            for (String perm : permutations) {
                if (dictionary.contains(perm)) {
                    result.add(perm);
                }
            }
        }
        List<String> sorted = new ArrayList<>(result);
        Collections.sort(sorted);
        return sorted;
    }
    private void generatePermutations(char[] arr, int index, List<String> result) {
        if (index == arr.length) {
            result.add(new String(arr));
            return;
        }
        Set<Character> seen = new HashSet<>();
        for (int i = index; i < arr.length; i++) {
            if (seen.contains(arr[i])) continue;
            seen.add(arr[i]);
            swap(arr, i, index);
            generatePermutations(arr, index + 1, result);
            swap(arr, i, index);
        }
    }
    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    // ---------- Optimized Approach using Frequency Counting ----------
    // Only consider words that are one character longer than input
    // Time: O(N * 26) = O(N), since 26 is constant
    // Space: O(N + 1) for storing dictionary and result
    public List<String> optimizedStepWords(String word, Set<String> dictionary) {
        int[] baseFreq = getFreqMap(word);
        List<String> result = new ArrayList<>();
        for (String candidate : dictionary) {
            if (candidate.length() != word.length() + 1) continue;
            int[] candFreq = getFreqMap(candidate);
            int diffCount = 0;
            for (int i = 0; i < 26; i++) {
                int diff = candFreq[i] - baseFreq[i];
                if (diff < 0 || diff > 1) {
                    diffCount = -1;
                    break;
                }
                if (diff == 1) diffCount++;
            }
            if (diffCount == 1) {
                result.add(candidate);
            }
        }
        Collections.sort(result);
        return result;
    }
    private int[] getFreqMap(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }
    // ---------- Main Method for Testing ----------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputWord = sc.nextLine().toLowerCase();
        int n = Integer.parseInt(sc.nextLine());
        Set<String> dictionary = new HashSet<>();
        for (int i = 0; i < n; i++) {
            dictionary.add(sc.nextLine().toLowerCase());
        }
        StepWordFinder finder = new StepWordFinder();
        // Choose one: Brute force OR Optimized
        // List<String> stepWords = finder.bruteForceStepWords(inputWord, dictionary);
        List<String> stepWords = finder.optimizedStepWords(inputWord, dictionary);
        for (String word : stepWords) {
            System.out.println(word);
        }
    }
}
