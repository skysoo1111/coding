import kotlin.*

class Solution {
    // n: 상자, w: 라인, num: 꺼내야하는 상자 번호, answer: 꺼내야하는 상자를 포함해서 몇개를 걷어내야 하는가?
    fun solution(n: Int, w: Int, num: Int): Int {
        var answer: Int = 0
        
        val baseHeight = (n+w-1)/w - 1
        var boxArray = Array(baseHeight + 1) {IntArray(w) {0}} // 5,3
        
        var i=0
        var boxNum = 1
        while(boxNum <= n) {
            if(i%2==1) {
                for(j in w-1 downTo 0) {
                    if(boxNum > n) break
                    boxArray[i][j] = boxNum++
                }
            } else {
                for(j in 0 until w) {
                    if(boxNum > n) break
                    boxArray[i][j] = boxNum++
                }
            }
            i++
        }
        
        var row = 0
        var col = 0
        for (i in boxArray.indices) { // 0..4
            for (j in boxArray[i].indices) { // 0..2
                val target = boxArray[i][j]
                if (num == target) {
                    row = i // 1
                    col = j // 0
                    break
                }
            }
        }
        
        for(i in row..baseHeight) { // 1..4
            if(boxArray[i][col] != 0) answer++
        }

        return answer
    }
}