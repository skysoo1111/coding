import kotlin.*

class Solution {
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        var answer: Int = 0

        val giftValue: MutableMap<String, Int> = mutableMapOf()
        friends.forEach { giftValue[it] = 0 }
        gifts.forEach {
            val split = it.split(" ")
            val from = split[0]
            val to = split[1]

            if (giftValue[from] != null) {
                giftValue[from] = giftValue[from]!!.plus(1)
            } else {
                giftValue[from] = 1
            }

            if (giftValue[to] != null) {
                giftValue[to] = giftValue[to]!!.minus(1)
            } else {
                giftValue[to] = -1
            }
        }

        val giftMap: MutableMap<String, Int> = mutableMapOf()
        for(fromFriend in friends) {
            for(toFriend in friends) {
                val key = "$fromFriend $toFriend"
                giftMap[key] = 0
            }
        }
        
        gifts.forEach {
            giftMap[it] = (giftMap[it] ?: 0) +1
        }

        val points: MutableMap<String, Int> = mutableMapOf()
        for(friend in friends) {
            points[friend] = 0
            val sender = giftMap.keys.filter { it.startsWith("$friend ") }.filterNot { it == "$friend $friend" }

            sender.forEach {
                val split = it.split(" ")
                val from = split[0]
                val to = split[1]
                val receiver = "$to $from"

                if (giftMap[it]!! > giftMap[receiver]!!) {
                    points[from] = points[from]!!.plus(1)
                } else if (giftMap[it] == giftMap[receiver]) {
                    if (giftValue[from]!! > giftValue[to]!!) {
                        points[from] = points[from]!!.plus(1)
                    }
                }
                answer = if(points[from]!! > answer) points[from]!! else answer
            }
        }
        return answer
    }
}