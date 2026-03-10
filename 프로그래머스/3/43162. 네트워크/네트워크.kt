class Solution {
    
    fun solution(n: Int, computers: Array<IntArray>): Int {
        dfs(n, computers, 0)

        return if (n-graph.size == 0) 1 else n-graph.size 
    }
    
    var count = 0
    var graph = mutableMapOf<Int, MutableList<Int>>()
    fun dfs(n: Int, computers: Array<IntArray>, depth: Int) {
        if (n == depth + 1) {
            return
        }

        for (i in computers[depth].indices) {
            if (depth != i && computers[depth][i] == 1) {
                graph.getOrPut(depth) { mutableListOf() }.add(i)
                if (graph[i]?.contains(i) == null) count++
            }
        }

        dfs(n, computers, depth + 1)
    }
}