class Solution {
    fun solution(diffs: IntArray, times: IntArray, limit: Long): Int {
        var minDiff = 1
        var maxDiff = diffs.maxOrNull() ?: 0
        var answer = 0

        while (minDiff <= maxDiff) {
            var total = 0L
            var average = (minDiff + maxDiff) / 2
            for (i in diffs.indices) {
                if (diffs[i] <= average) {
                    total += times[i]
                } else {
                    total += ((times[i-1] + times[i]) * (diffs[i] - average) + times[i])
                }
                if (total > limit) break
            }

            if (limit > total) {
                answer = average
                maxDiff = average - 1
            } else if (limit == total) {
                return average
            } else {
                minDiff = average + 1
            }
        }

        return answer
    }
}