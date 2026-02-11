class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        var answer: IntArray = intArrayOf()

        val zeroCount = lottos.count { it == 0 } //2
        val matchCount = lottos.filter { it != 0 }.count { it in win_nums } //2

        answer = intArrayOf(7-(matchCount+zeroCount).coerceAtLeast(1), (7 - matchCount).coerceAtMost(6))

        return answer
    }
}