package 프로그래머스.가장큰수;

import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        List<String> nums = new ArrayList<>();

        for(int number : numbers){
            nums.add(String.valueOf(number));
        }

        //내림차순으로 정렬
        Collections.sort(nums, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return (s2+s1).compareTo(s1+s2);
            }
        });

        //가장 앞이 0인 경우, 0을 반환함
        if(nums.get(0).equals("0"))
            return "0";

        StringBuilder sb = new StringBuilder();
        for(String num : nums){
            sb.append(num);
        }

        return sb.toString();

    }
}