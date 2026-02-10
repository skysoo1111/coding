import kotlin.*

class Solution {
    // answer에는 id_list 대상들의 메일을 받은(신고한 유저가 정지된 경우) 횟수
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        var answer = IntArray(id_list.size)

        //id별 신고 당한 횟수
        val reportedCountById = IntArray(id_list.size)
        //중복 제거 필요
        val reportSet = report.toSet()
        //id별 신고한 user의 index들
        val reportingIndexById = mutableMapOf<String, MutableList<Int>>()
        for(target in reportSet) {
            val split = target.split(" ")
            val from = split[0]
            val to = split[1]
            val toIndex = id_list.indexOf(to)

            reportedCountById[toIndex]++
            reportingIndexById.getOrPut(from) { mutableListOf() }.add(toIndex)
        }

        reportingIndexById.forEach{
            val key = it.key
            val value = it.value

            val idIndex = id_list.indexOf(key)

            value.forEach {
                if (reportedCountById[it] >= k) answer[idIndex]++
            }
        }

        return answer
    }
}
