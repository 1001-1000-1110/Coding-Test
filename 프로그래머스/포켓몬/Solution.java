package 프로그래머스.포켓몬;

import java.util.*;
class Solution {
    public int solution(int[] nums) {

        Set<Integer> set = new HashSet<Integer>();
        for(int val : nums){
            set.add(val);
        }
        //nums.length/2 <= set.size() 인 경우, nums.length/2출력
        //nums.length/2 > set.size() 인 경우, set.size()출력
        if(nums.length/2 <= set.size())
            return nums.length/2;

        return set.size();

    }
}