import kotlin.collections.*

class Solution {
    fun solution(schedules: IntArray, timelogs: Array<IntArray>, startday: Int): Int {
        var answer: Int = 0
        
        for(i in schedules.indices) {
            val time = schedules[i]
            val hour = time / 100
            val minutes = time % 100 + 10; 
            val endTime: Int = (hour+minutes/60)*100 + minutes%60;
    
            var flag: Boolean = true
            
            for(j in timelogs[i].indices) {
                val week = (startday + j - 1) % 7
                if (week != 5 && week != 6 && endTime < timelogs[i][j]) {
                    flag = false   
                    break
                }
            }
            
            if (flag) {
                answer++;
            }
        }
        
        return answer
    }
}