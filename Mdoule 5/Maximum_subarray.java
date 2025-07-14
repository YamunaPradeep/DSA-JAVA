//✅ Approach 1: Brute Force (O(n³))
//We try every possible subarray and calculate the sum using another loop.


public class Main {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                maxSum = Math.max(maxSum, sum);
            }
        }

        System.out.println("Maximum Subarray Sum (O(n^3)): " + maxSum);
    }
}

//✅ Approach 2: Prefix Sum (O(n²))
//We compute a prefix sum array to avoid recomputing sums again and again.


public class Main {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;

        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = (i == 0) ? prefix[j] : prefix[j] - prefix[i - 1];
                maxSum = Math.max(maxSum, sum);
            }
        }

        System.out.println("Maximum Subarray Sum (Prefix Sum O(n^2)): " + maxSum);
    }
}

//✅ Approach 3: Carry Forward Method (O(n²))
//Instead of using prefix sum, we calculate the sum for every i to j in one pass.


public class Main {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                maxSum = Math.max(maxSum, sum);
            }
        }

        System.out.println("Maximum Subarray Sum (Carry Forward O(n^2)): " + maxSum);
    }
}

//✅ Kadane’s Algorithm – Clean Java Code

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxSubArray(final int[] A) {
        int maxSum = Integer.MIN_VALUE; // Stores the maximum sum found so far
        int currSum = 0;                // Stores the current subarray sum

        for (int i = 0; i < A.length; i++) {
            currSum += A[i]; // Add current element to the current sum

            // Update the maxSum if the current sum is greater
            if (currSum > maxSum) {
                maxSum = currSum;
            }

            // If current sum becomes negative, reset it to 0
            if (currSum < 0) {
                currSum = 0;
            }
        }

        return maxSum;
    }
}


/*Approach	Time Complexity	Space Complexity	Notes
Brute Force	O(n³)	O(1)	Very inefficient
Prefix Sum	O(n²)	O(n)	Avoids recomputation of sums
Carry Forward	O(n²)	O(1)	Simpler than prefix, no extra space
Kadane’s	O(n)	O(1)	Best method – used in interviews */

//✅ Modified Kadane’s Algorithm to Return the Subarray

public class Solution {

    public Result maxSubArray(int[] A) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        List<Integer> current = new ArrayList<>();
        List<Integer> best = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            currSum += A[i];
            current.add(A[i]);

            if (currSum > maxSum) {
                maxSum = currSum;
                best = new ArrayList<>(current); // Copy the current subarray
            }

            if (currSum < 0) {
                currSum = 0;
                current.clear(); // Reset current subarray
            }
        }

        return new Result(maxSum, best);
    }
}




