# Quiz Name
> ### HackerRank / [level] <a href = ""> Tree: Preorder Traversal </a>

<br>

## 💡 approaches
>  - 
>  - 

<br>

## 🔑 quiz solution

```java
import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

/* you only have to complete the function given below.  
Node is defined as  

class Node {
    int data;
    Node left;
    Node right;
}

*/  
    private static void dfs(Node node, StringBuilder sb){
        sb.append(node.data+" ");
        if(node.left != null){
            dfs(node.left, sb);
        }
        if(node.right != null){
            dfs(node.right,sb);
        }
    }

    public static void preOrder(Node root) {
        //dfs
        StringBuilder sb = new StringBuilder();
        
        dfs(root, sb);
        System.out.println(sb.toString());
        
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        preOrder(root);
    }	
}
```
### Time Complexity : O(N)
## 👩🏻‍🏫 TIL
>  -
>  -
