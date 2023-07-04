# Quiz Name
> ### BaekJoon / [Gold4] <a href = "https://www.acmicpc.net/problem/2064"> IP 주소 </a>

<br>

## 💡 approaches
>  - 비트마스킹

<br>

## 🔑 quiz solution

```java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int latestIp = 0;
        int ip[] = new int[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(),".");
            int currip = 0;
            for(int j = 0; j < 4; j++){
                currip = currip << 8;
                currip = currip | Integer.parseInt(st.nextToken());
            }
            ip[i] = currip;
        }

        //네트워크 마스크 구하기
        int netmask = 0;

        point:
        for(int i = 32 - 1; i >= 0; i--){
            int bit = 1 << i;
            for(int j = 1;  j < n; j++){
                if((ip[0] & bit) != (ip[j] & bit)){
                    break point;
                }
            }
            netmask |= bit;
        }

        int network = netmask & ip[0];

        int[] networks = getIpAsArray(network);
        int[] netmasks = getIpAsArray(netmask);

        //네트워크 주소 출력
        for(int i = 0; i < 4; i++){
            System.out.print(networks[i]);
            if(i < 3){
                System.out.print(".");
            }
        }
        System.out.println();

        //네트워크마스크 출력
        for(int i = 0; i < 4; i++){
            System.out.print(netmasks[i]);
            if(i < 3){
                System.out.print(".");
            }
        }
        System.out.println();
    }

    private static int[] getIpAsArray(int ip) {
        int[] network = new int[4];
        int move = 24;

        for(int i = 0; i < 4; i++){
            int temp = 255 << move;
            int now = ip & temp;
            now = now >>> move;
            network[i] = now;
            move -= 8;
        }
        return network;
    }

}

```
### Time Complexity : O(N)
## 👩🏻‍🏫 TIL
>  - 자바에서 ">>"은 좌측을 최상단 비트로 채우는 반면,  
>  ">>>"은 좌측을 모두 0으로 채운다.
