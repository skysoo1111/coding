class Solution {
    fun solution(s: String): IntArray {
        var answer: IntArray = intArrayOf()
        var target = s
        var count = 0
        var zeroCount = 0

        while (target != "1") {
            var x = ""
            for (c in target.toCharArray()) {
                if (c == '1') {
                    x += c.toString()
                } else {
                    zeroCount++
                }
            }
            target = Integer.toBinaryString(x.toCharArray().size)
            count++
        }

        answer = intArrayOf(count, zeroCount)
        return answer
    }
}