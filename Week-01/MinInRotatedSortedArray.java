import java.util.Scanner;

// Find minimum in rotated sorted array
// Time: O(log n), Space: O(1)
public class MinInRotatedSortedArray {
    
    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // If mid > right, min is in right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Min is in left half (including mid)
                right = mid;
            }
        }
        
        return nums[left];
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
        
        int result = findMin(nums);
        System.out.println("Minimum element: " + result);
        
        sc.close();
    }
}
