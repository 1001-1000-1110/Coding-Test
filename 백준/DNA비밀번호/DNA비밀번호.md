# Quiz Name
> ### BaekJoon / [Silver2] <a href = "https://www.acmicpc.net/problem/12891"> DNA비밀번호 </a>

<br>

## 💡 approaches
>  - 슬라이딩 윈도우 알고리즘
>   - 문제에서 제시하는 부분문자열의 포함되어야하는 최소 A,C,G,T의 개수를 condition배열에 저장함.
>   - 부분문자열에서 A,C,G,T의 개수를 카운트하여 countP배열에 저장
>   - 부분문자열의 길이는 변화하지 않으므로, 한칸씩 우측으로 이동시켜주면서 countP배열을 갱신함
>     - 우측으로 이동시키면 `기존` 부분문자열의 `시작지점`의 알파벳을 카운트하는 countP배열의 요소에 `-1`을 함
>     - 우측으로 이동시키면 `새로 포함된` 부분문자열의 `종료지점`의 알파벳을 카운트하는 countP배열의 요소에 `+1`을 함

<br>

## 🔑 quiz solution

```java

import java.io.*;
import java.util.StringTokenizer;

//백준 12891번
public class Main {
    static int s,p;//문자열의 길이, 부분문자열의 길이
    static int cnt;//만들수 있는 비밀번호의 개수
    static char[] dna;//dna문자열 저장
    static int[] condition = new int[4];//문제에서 제시한 A,C,G,T의 개수를 저장
    static int[] countP = new int[4];//dna문자열의 부문문자열의 ACGT의 개수를 저장하는 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        dna = new char[s];
        String temp = br.readLine();
        for(int i = 0; i < s; i++){
            dna[i] = temp.charAt(i);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            condition[i] = Integer.parseInt(st.nextToken());
        }

        //초기 부분문자열의 길이만큼  A,C,G,T의 개수를 카운트함.
        for(int i = 0; i < p; i++){
            char currChar = dna[i];
            addDNA(currChar);
        }
        //유요한 비밀번호인지 확인
        checkPWD();

        int left = 0;
        int right = p - 1;
        for(int i = 0; i < s - p; i++){
            right++;
            addDNA(dna[right]);
            removeDNA(dna[left]);
            left++;
            checkPWD();
        }

        bw.write(cnt+"");
        bw.flush();
        bw.close();
    }

    //비밀번호 조건인 ACGT의 개수를 현재 부분 문자열의 ACGT의 개수와 비교하여, 조건을 충족하면 cnt++
    private static void checkPWD() {
        for(int i = 0;  i < 4; i++){
            if(countP[i] < condition[i]) return;
        }
        cnt++;
    }

    private static void addDNA(char currChar){
        if(currChar == 'A') countP[0]++;
        else if(currChar == 'C') countP[1]++;
        else if(currChar == 'G') countP[2]++;
        else countP[3]++;//if(currChar =='T')
    }

    private static void removeDNA(char currChar){
        if(currChar == 'A') countP[0]--;
        else if(currChar == 'C') countP[1]--;
        else if(currChar == 'G') countP[2]--;
        else countP[3]--;//if(currChar =='T')
    }
}

```
### Time Complexity : O(N)
## 👩🏻‍🏫 TIL
>  - 슬라이딩 윈도우알고리즘은 투포인터 알고리즘과 유사하다.
>    - 시작점과 종료점의 차이가 계속 일정한 투포인터 배열
