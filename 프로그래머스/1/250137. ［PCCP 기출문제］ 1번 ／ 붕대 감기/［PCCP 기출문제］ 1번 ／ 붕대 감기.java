import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;

        int itemCount = bandage[0];
        int addHealth = bandage[1];
        int itemHealth = bandage[2];

        int previousAttackCount = 0;
        for (int i = 0; i < attacks.length; i++) {

            int attackCount = attacks[i][0];
            int damage = attacks[i][1];

            // 붕대
            if (i != 0) {
                previousAttackCount = attacks[i - 1][0];
                int addHealthTime = attackCount - previousAttackCount - 1;
                int plusItemHealth = (addHealthTime / itemCount) * itemHealth + (addHealth * addHealthTime);
                answer += plusItemHealth;
            }
            if (answer > health) answer = health;

            // 공격
            answer -= damage;
            if (answer <= 0) return -1;
        }

        return answer;
    }
}