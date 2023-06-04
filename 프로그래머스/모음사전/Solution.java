package 프로그래머스.모음사전;

class Solution {
    static int seq;
    static int answer;
    static char[] alpha;
    public int solution(String word) {
        alpha = new char[]{'A','E','I','O','U'};

        dfs(word, "");
        return answer;
    }
    //순서를 파악해야하는 단어, dfs메소드를 통해 만들어진 단어
    private static void dfs(String word, String now){

        if(word.equals(now)){ //word와 now가 동일한 경우 종료
            answer = seq;
            return;
        }

        if(now.length() == 5){
            return;
        }

        for(int i = 0;  i < alpha.length; i++){
            seq++;//전역변수 seq를 증가시킴
            dfs(word,now + alpha[i]);
        }
    }
}