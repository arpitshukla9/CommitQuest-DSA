import java.util.*;

// Count subarrays with sum equals k
// Time: O(n), Space: O(n)
public class SubarraySumEqualsK {
    
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        // Base case: empty subarray has sum 0
        map.put(0, 1);
        
        for (int num : nums) {
            sum += num;
            
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            
            // Update frequency of current sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        
        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        
        System.out.print("Enter target sum k: ");
        int k = sc.nextInt();
        
        int result = subarraySum(nums, k);
        System.out.println("Number of subarrays with sum " + k + ": " + result);
        
        sc.close();
    }
}