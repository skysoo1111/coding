class Solution {
    var networks = 0
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var visited = BooleanArray(n)

        for (i in 0 until n) {
            if (!visited[i]) {
                networks++
                dfs(n, computers, visited, i)
            }
        }

        return networks
    }

    fun dfs(n: Int, computers: Array<IntArray>, visited: BooleanArray, depth: Int) {
        visited[depth] = true

        for (i in 0 until n) {
            if(computers[depth][i] == 1 && depth != i && !visited[i]) {
                dfs(n, computers, visited, i)
            }
        }
    }
}