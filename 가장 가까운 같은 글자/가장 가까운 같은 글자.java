import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<Integer> answer = new ArrayList();
        Map<Character, Integer> map = new HashMap();
        char c;
        
        for (int i=0;i < s.length();i++) {
            c = s.charAt(i);
            if (map.containsKey(c)) {
                answer.add(i - map.get(c));
            } else {
                answer.add(-1);
            }
            
            map.put(c, i);
        }
        return answer.stream().mapToInt(integer -> integer).toArray();
    }
}