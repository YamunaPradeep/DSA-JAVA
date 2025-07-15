public class Solution {
    public int solve(int[] A, int B) {
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());  // renamed from 'queue' to 'maxHeap'
        Arrays.sort(A);
        
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                for (int k = j + 1; k < A.length; k++) {
                    
                    long sum = 1L * A[i] + A[j] + A[k];

                    if (maxHeap.size() < B) {
                        maxHeap.offer(sum);
                    } else {
                        if (maxHeap.peek() >= sum) {
                            maxHeap.offer(sum);
                            maxHeap.poll();
                        }
                    }
                }
            }
        }

        return (int)(long)maxHeap.poll();  // final return uses 'maxHeap'
    }
}
