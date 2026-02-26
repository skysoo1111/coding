class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        val lastTime = convertingTime("23:59")

        val map = HashMap<String, Int>()
        val resultMap = HashMap<String, Int>()
        
        records.forEachIndexed { index, record ->
            val split = record.split(" ")
            val currentTime = convertingTime(split[0])
            val number = split[1]
            val act = split[2]

            if (act == "IN") {
                map.put(number, currentTime)
            } else {
                val inTime = map.remove(number)!!
                resultMap.merge(number, currentTime-inTime) {old, new -> old + new}
            }
        }

        for (last in map) {
            resultMap.merge(last.key, lastTime-last.value) {old, new -> old + new}
        }

        return resultMap.toSortedMap().map { calculateFee(fees, it.value) }.toIntArray()
    }
    
    fun calculateFee(fees: IntArray, time: Int): Int {
        val defaultTime = fees[0]
        val defaultFee = fees[1]
        val unitTime = fees[2]
        val unitFee = fees[3]

        return if (time > defaultTime) {
            defaultFee + roundTime(time, defaultTime, unitTime) * unitFee
        } else {
            defaultFee
        }
    }

    fun convertingTime(time: String): Int {
        val split = time.split(":")
        return (split[0].toInt() * 60) + split[1].toInt()
    }

    fun roundTime(time: Int, defaultTime: Int, unitTime: Int): Int {
        val addTime = time - defaultTime
        val i = addTime / unitTime
        val j = if (addTime % unitTime > 0) 1 else 0
        return i + j
    }
}