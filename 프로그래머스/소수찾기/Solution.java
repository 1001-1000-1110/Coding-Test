package 프로그래머스.소수찾기;

import java.util.*;
class Solution {
    static boolean[] visit;
    static Set<Integer> set = new HashSet<Integer>(); //소수인 숫자를 중복없이 담기 위한 set
    public int solution(String numbers) {
        visit = new boolean[numbers.length()];
        dfs(0, numbers, 0);
        return set.size();
    }
    private void dfs(int depth, String numbers, int num){
        if(depth == numbers.length()){
            isPrime(num);
            return;
        }
        for(int i = 0; i < numbers.length(); i++){
            if(visit[i] != true){
                visit[i] = true;
                isPrime(num*10 + (numbers.charAt(i) - '0'));
                dfs(depth + 1, numbers, num*10 + (numbers.charAt(i) - '0'));
                visit[i] = false;
            }
        }
    }
    //소수인지 확인하는 메소드
    private void isPrime(int num){
        if(num < 2)
            return;
        for(int i = 2; i < num; i++){
            if(num % i == 0){
                return;
            }
        }
        set.add(num);
    }
}

