import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0, j = 0;

        while (i < A.length && j < A.length) {
            if (B[j] > A[i]) {
                answer++;
                i++;
            }
            j++;
        }

        return answer;
    }
    
    
}