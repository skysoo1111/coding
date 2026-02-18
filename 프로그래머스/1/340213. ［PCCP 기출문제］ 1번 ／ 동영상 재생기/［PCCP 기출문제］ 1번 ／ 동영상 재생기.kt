class Solution {
    fun solution(video_len: String, pos: String, op_start: String, op_end: String, commands: Array<String>): String {
        var answer: String = ""

        val video_len_time = video_len.split(":")
        val pos_time = pos.split(":")
        val op_start_time = op_start.split(":")
        val op_end_time = op_end.split(":")

        val videoLenTime = (video_len_time[0].toInt() * 60) + video_len_time[1].toInt()
        var posTime = (pos_time[0].toInt() * 60) + pos_time[1].toInt()
        val opStartTime = (op_start_time[0].toInt() * 60) + op_start_time[1].toInt()
        val opEndTime = (op_end_time[0].toInt() * 60) + op_end_time[1].toInt()

        posTime = skipOpening(posTime, opStartTime, opEndTime)

        commands.forEach {
            when(it) {
                "prev" -> {
                    posTime = maxOf(0,posTime-10)
                }
                "next" -> {
                    posTime = minOf(videoLenTime,posTime+10)
                }
            }
            posTime = skipOpening(posTime, opStartTime, opEndTime)
        }

        val minutes = posTime/60
        val seconds = posTime%60

        answer = minutes.toString().padStart(2,'0').plus(":").plus(seconds.toString().padStart(2,'0'))
        return answer
    }

    private fun skipOpening(posTime: Int, opStartTime: Int, opEndTime: Int): Int {
        if (posTime in opStartTime..opEndTime) return opEndTime else return posTime
    }
}