class Solution
{
    public int solution(String s)
    {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            int length = sb.length();
            char c = s.charAt(i);
            
            if (length > 0 && sb.charAt(length - 1) == c) {
                sb.deleteCharAt(length - 1); // 같으면 제거
            } else {
                sb.append(c); // 다르면 추가
            }
        }

        return sb.length() == 0 ? 1 : 0;
    }
}