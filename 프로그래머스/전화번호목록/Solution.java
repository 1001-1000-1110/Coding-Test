package 프로그래머스.전화번호목록;
import java.util.*;
class Solution {
    public static boolean solution(String[] phone_book) {
        //모든 번호를 set에 추가함
        Set<String> set = new HashSet<>();
        for(String val: phone_book){
            set.add(val);
        }
        //접두어가 존재하면 종료
        for(String val : phone_book){
            for(int i = 1; i < val.length(); i++){
                if(set.contains(val.substring(0,i)))
                    return false;
            }
        }
        return true;
    }
}