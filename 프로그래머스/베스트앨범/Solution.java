package 프로그래머스.베스트앨범;

import java.util.*;
import java.util.Map.Entry;
class Solution {
    public static class Info implements Comparable<Info>{
        int number;
        int play;

        public Info(int number, int play){
            this.number = number;
            this.play = play;
        }
        @Override
        public int compareTo(Info i){
            return Integer.compare(this.play, i.play);
        }



    }
    public int[] solution(String[] genres, int[] plays) {
        //어떤 장르가 가장많이 재생 됬는지 파악해야함.
        //장르별 재생수를 파악하여 정렬해야함
        //장르순서별로, 재생수가 많은 최대 2개의 고유번호를 반환해야함

        //장르를 key, 재생수를 value로하는 map을 사용하여 반환되는 순서 결정함
        Map<String,Integer> genreMap = new HashMap<>();

        for(int i = 0; i < genres.length; i++){
            if(genreMap.containsKey(genres[i])){
                genreMap.put(genres[i], genreMap.get(genres[i]) + plays[i]);

            }else{
                genreMap.put(genres[i], plays[i]);
            }
        }

        List<Entry<String,Integer>> gen = new ArrayList<Entry<String,Integer>>(genreMap.entrySet());


        Collections.sort(gen, new Comparator<Entry<String,Integer>>(){ //장르별 재생수를 오름차순으로 정렬함.
            @Override
            public int compare(Entry<String,Integer> e1, Entry<String,Integer> e2){
                return Integer.compare(e2.getValue(), e1.getValue());
            }
        });

        //장르별 재생수가 높은 음악의 고유넘버를 리스트에 넣음
        List<Integer> answer = new ArrayList<>();
        for(Map.Entry<String,Integer> entry :  gen){
            String key = entry.getKey();//장르명
//            System.out.println(key);
            List<Info> list = new ArrayList<>();//임시로 음악의 정보를 저장할 리스트 , 아래의 코드에서 정렬하여 사용할 예정
            for(int i = 0;  i < genres.length; i++){
                if(genres[i].equals(key)){//같은 장르의 음악인 경우 리스트에 추가함
                    list.add(new Info(i,plays[i]));
                }
            }
            Collections.sort(list, Collections.reverseOrder()); //내림차순 정렬함
            for(int i = 0 ; i < list.size() && i < 2; i++){ //플레이수가 많은 음악의 고유번호를 최대2개를 반환할 리스트에 넣음
                answer.add(list.get(i).number);
            }
        }

        //리스트를 배열로 변환함.
        int[] result = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++){
            result[i] = answer.get(i);
        }
        return result;
    }
}