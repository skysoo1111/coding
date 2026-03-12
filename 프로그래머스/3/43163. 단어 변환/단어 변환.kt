class Solution {
    fun solution(begin: String, target: String, words: Array<String>): Int {
        var checked = BooleanArray(words.size)
        val queue = ArrayDeque<Pair<String, Int>>()

        queue.add(Pair(begin, 0))
        while (queue.isNotEmpty()) {
            val poll = queue.removeFirst()

            if (poll.first == target) {
                return poll.second
            }

            val beginArray = poll.first.toCharArray()
            for (i in words.indices) {
                val wordArray = words[i].toCharArray() 
                
                if (!checked[i] && isChange(beginArray, wordArray) ) {
                    checked[i] = true
                    queue.add(Pair(words[i], poll.second+1))
                }
            }
        }

        return 0
    }

    fun isChange(beginArray: CharArray, wordArray: CharArray): Boolean {
        var diff = 0
        for (j in beginArray.indices) {
            if (beginArray[j] != wordArray[j]) {
                diff++
            }
        }
        return diff == 1
    }
}