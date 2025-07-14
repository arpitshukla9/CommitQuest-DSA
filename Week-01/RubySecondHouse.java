import java.util.Scanner;

// Paint houses with k colors - no adjacent houses same color
// Time: O(n * k), Space: O(1)
public class RubySecondHouse {
    
    public static int minCost(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        
        // Track two minimum costs from previous house
        int min1 = -1, min2 = -1;
        
        for (int i = 0; i < n; i++) {
            int prevMin1 = min1, prevMin2 = min2;
            min1 = -1;
            min2 = -1;
            
            for (int j = 0; j < k; j++) {
                // Add cost from previous house (avoiding same color)
                if (i > 0) {
                    if (j != prevMin1) {
                        costs[i][j] += costs[i - 1][prevMin1];
                    } else {
                        costs[i][j] += costs[i - 1][prevMin2];
                    }
                }
                
                // Track two minimum costs for current house
                if (min1 == -1 || costs[i][j] < costs[i][min1]) {
                    min2 = min1;
                    min1 = j;
                } else if (min2 == -1 || costs[i][j] < costs[i][min2]) {
                    min2 = j;
                }
            }
        }
        
        return costs[n - 1][min1];
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of houses and colors (n k): ");
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[][] costs = new int[n][k];
        System.out.println("Enter painting costs row by row:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                costs[i][j] = sc.nextInt();
            }
        }
        
        int result = minCost(costs);
        System.out.println("Minimum total cost: " + result);
        
        sc.close();
    }
}
