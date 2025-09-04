import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void findPair(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            int comp = target - num;
            if (set.contains(comp)) {
                System.out.println("Found pair: " + num + ", " + comp);
                return;
            }
            set.add(num);
        }

        System.out.println("No pair found");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements in the array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements in the array: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Enter the target: ");
        int target = sc.nextInt();

        findPair(nums, target);

        sc.close();
    }
}