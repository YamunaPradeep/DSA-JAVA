public class Solution {
    public int[] plusOne(int[] A) {
        int n = A.length;
        if(n==1 && A[0] == 0){
            A[0] += 1;
            return A;
        }

        int idx = 0;
        while(A[idx] == 0){
            idx++;
        }

        int[] B = new int[n-idx];
        for(int i=0; i<B.length; i++){
            B[i] = A[idx];
            idx++;
        }

        int c = B.length;
        for(int i=c-1; i>=0; i--){
            if(B[i] +1  != 10){
                B[i]+=1;
                return B;
            }else{
                B[i] = 0;
            }
        }

        int[] newans = new int[c+1];
        newans[0] = 1;
        return newans;

        
    }
}
