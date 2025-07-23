import java.util.*;

public class SmallestNonRepresentableSum {

    // ---------- Brute Force (Power Set) ----------
    // Try all subsets and find the smallest missing sum
    // Time: O(2^N) — Not feasible for N > 20
    public int bruteForce(int[] coins) {
        Set<Integer> allSums = new HashSet<>();
        generateSums(coins, 0, 0, allSums);

        for (int i = 1; ; i++) {
            if (!allSums.contains(i)) return i;
        }
    }

    private void generateSums(int[] coins, int index, int currentSum, Set<Integer> allSums) {
        if (index == coins.length) {
            allSums.add(currentSum);
            return;
        }
        generateSums(coins, index + 1, currentSum + coins[index], allSums);
        generateSums(coins, index + 1, currentSum, allSums);
    }

    // ---------- Optimized Greedy Approach ----------
    // Time: O(N) |  Space: O(1)
    // Let res = smallest sum we can't represent so far.
    // If current coin <= res, we can extend the range to res + coin
    public int optimizedGreedy(int[] coins) {
        int res = 1; // Smallest unrepresentable sum starts at 1

        for (int coin : coins) {
            if (coin > res) break;
            res += coin;
        }

        return res;
    }

    // ---------- Main Method ----------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] coins = Arrays.stream(sc.nextLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();

        SmallestNonRepresentableSum solver = new SmallestNonRepresentableSum();

        // Choose:
        // int result = solver.bruteForce(coins);
        int result = solver.optimizedGreedy(coins);

        System.out.println(result);
    }
}
