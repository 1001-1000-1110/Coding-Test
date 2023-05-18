# Quiz Name
> ### HackerRank / [intermediate] <a href = "https://www.hackerrank.com/challenges/one-week-preparation-kit-simple-text-editor/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-six"> Simple Text Editor </a>

<br>

## 💡 approaches
>  - 구현문제
>  - 1 string : 기존문자열에 string을 더한다.
>  - 2 k : 뒤에서 부터 문자열을 k개 삭제한다.
>  - 3 k : k번째 문자를 출력한다.
>  - 4 : 최근의 실행한 명령어(1 or 2)를 실행 이전으로 되돌린다. -> stack을 활용함.

<br>

## 🔑 quiz solution

```java
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int q = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();
        
        for(int i = 0; i < q; i++){
            String[] command = br.readLine().split(" ");
            // System.out.println(Arrays.toString(command));
            if(command[0].equals("1")){
                StringBuilder sb = new StringBuilder();
                if(!stack.isEmpty()){
                   sb.append(stack.peek());
                }
                stack.add(sb.append(command[1]).toString());
            }else if(command[0].equals("2")){
                int k = Integer.parseInt(command[1]);
                String str = stack.peek();
                str = str.substring(0,str.length() - k);
                stack.add(str);
            }else if(command[0].equals("3")){
                String str = stack.peek();
                int k = Integer.parseInt(command[1]);
                // System.out.println(stack.peek() +" " + k);
                bw.write(str.substring(k-1, k)+"\n");
            }else if(command[0].equals("4")){
                stack.pop();
            }
        }
        bw.flush();
        bw.close();
        
    }
}

```
### Time Complexity : O(N)
## 👩🏻‍🏫 TIL
>  - 
>  -
