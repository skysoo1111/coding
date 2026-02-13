import java.util.regex.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;

        String[] split = dartResult.split("(?<=\\D)(?=\\d)");
        for (int i = 0; i < split.length; i++) {
            if (split[i].contains("*") && i>0) split[i-1] = split[i-1].concat("*");
        }

        for (int i = 0; i < split.length; i++) {
            int num = Integer.parseInt(split[i].replaceAll("\\D", ""));

            if (split[i].contains("D")) {
                num *= num;
            } else if (split[i].contains("T")) {
                num = num * num * num;
            }

            int asterCount = Integer.parseInt(String.valueOf(Pattern.compile("\\*").matcher(split[i]).results().count()));
            int sharpCount = Integer.parseInt(String.valueOf(Pattern.compile("\\#").matcher(split[i]).results().count()));
            if (split[i].contains("*") && sharpCount==0) {
                num = num * 2 * asterCount;
            } else if (split[i].endsWith("#") && asterCount==0) {
                num = num * (-1);
            } else if (split[i].endsWith("#*")) {
                num = num * -2;
            }

            answer += num;
        }

        return answer;
    }
}