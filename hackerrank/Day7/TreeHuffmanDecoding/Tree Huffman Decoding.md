# Quiz Name
> ### HackerRank / [advanced] <a href = "https://www.hackerrank.com/challenges/one-week-preparation-kit-tree-huffman-decoding/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-seven"> Tree: Huffman Decoding </a>

<br>

## 💡 approaches
>  - 주어진 문자열 s를 0번째 인덱스부터 s.length()만큼 반복하여 값을 확인함
>    - 0이면 왼쪽노드, 1이면 오른쪽 노드로 이동함
>    - 이동한 노드가, leafnode(자식 노드가 없는 경우) 해당 노드가 가지고 있는 `문자`를 반환할 문자로 추가함.
    
<br>

## 🔑 quiz solution

```java
class Decoding {

/*  
	class Node
		public  int frequency; // the frequency of this tree
    	public  char data;
    	public  Node left, right;
    
*/

    void decode(String s, Node root) {
        StringBuilder sb = new StringBuilder();
        Node Root = root;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '0'){
                Root = Root.left;
            }else{
                Root = Root.right;
            }
            if(Root.left == null && Root.right == null){
                sb.append(Root.data);
                Root = root;
            }
        }
        System.out.println(sb.toString());

    }
}


```
### Time Complexity : O(N)
## 👩🏻‍🏫 TIL
>  -
>  -
