import java.util.*;

class Solution {
    int convertMs(String time) {
        String[] temp = time.split(":");
        return (int)((Integer.parseInt(temp[0])*60*60+Integer.parseInt(temp[1])*60+Double.parseDouble(temp[2]))*1000);
    }
    
    public int solution(String[] lines) {
        int answer = 0;
        List<Request> list = new ArrayList<>();
        int start = 0, end = 0;
        
        for (int i=0;i<lines.length;i++) {
            String[] temp;
            temp = lines[i].split(" ");
            end = convertMs(temp[1]);
            
            if (end == 0) {
                start = 0;
            } else {
                temp[2] = temp[2].substring(0, temp[2].length()-1);
                start = end - (int)((Double.parseDouble(temp[2]) * 1000)) + 1;
            }
            list.add(new Request(start, end));
        }
        
        int temp;
        for (int i=0;i<list.size();i++) {
            temp = 1;
            for (int j=i+1;j<list.size();j++){
                if (list.get(j).start <= list.get(i).end+999) {
                    temp++;
                }
            }
            if (answer<temp){
                answer = temp;
            }
        }
        return answer;
    }
    
    class Request {
        int start;
        int end;
        
        Request(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}