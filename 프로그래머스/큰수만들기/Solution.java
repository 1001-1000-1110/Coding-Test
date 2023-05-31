package 프로그래머스.큰수만들기;

class Solution {
    public String solution(String number, int k) {
        int n = number.length() - k; //만들어야 할 문자열의 길이
        StringBuilder sb = new StringBuilder();
        int index = 0;//가장 큰 숫자의 인덱스를 저장함.
        for(int i = 0; i < n; i++){
            int max = 0; //탐색 중 가장 큰 숫자를 저장함.
            for(int j = index + 1; j <= number.length() - n + i; j++){ //i - 1번째에서 찾은 가장큰 숫자의 인덱스 + 1 부터 반복문을 시작함.
                if(number.charAt(j) - '0' > max){ //현재 j위치의 숫자가 max보다 큰 경우
                    max = (number.charAt(j) - '0'); // max값 갱신
                    index = j;//max값의 인덱스를 저장함.
                }
            }
            sb.append(max);//해당 숫자를 반환할 문자열에 더함.
        }
        return sb.toString();
    }
}