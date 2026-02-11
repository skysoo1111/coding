import kotlin.*

class Solution {
    fun solution(n: Int, w: Int, num: Int): Int {
        var answer: Int = 1
        val baseHeight = (n-1)/w

        val even = IntArray(w)
        val odd = IntArray(w)
        for (i in 1 .. w) {
            val value = (i*2)-1
            odd[i-1] = value
            even[w-i] = value
        }

        val targetHeight = (num - 1) / w
        var targetNum = num
        for(i in targetHeight until baseHeight) {
            var targetCol = if(targetNum%w == 0) (targetNum%w) else (targetNum%w) - 1
            var rowSum = if (targetNum%w==0) odd[targetCol] else even[targetCol]
            if(i%2!=0) {
                if (targetNum + rowSum <= n) {
                    answer++
                    targetNum += rowSum
                } else break
            } else {
                rowSum = if (targetNum%w==0) odd[targetCol] else even[targetCol]
                if (targetNum + rowSum <= n) {
                    answer++
                    targetNum += rowSum
                } else break
            }
        }

        return answer
    }
}