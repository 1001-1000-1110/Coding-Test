package 백준.이진검색트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 이진검색트리 {
    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        public void insert(int num){
            if(num < this.value){
                if(this.left == null){
                    this.left = new Node(num);
                }else{
                    this.left.insert(num);
                }
            }else{
                if(this.right == null){
                    this.right = new Node(num);
                }else{
                    this.right.insert(num);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> nums = new ArrayList<>();
        while(true){
            String input = br.readLine();
            if(input == null || input.equals("")) break;
            nums.add(Integer.parseInt(input));
        }

        Node root = new Node(nums.get(0));
        for(int i = 1; i < nums.size(); i++){
            int num =  nums.get(i);
            root.insert(num);
        }
        postOrder(root);
    }

    private static void postOrder(Node node) {
        if(node == null) return;
        //왼
        if(node.left != null) postOrder(node.left);
        //우
        if(node.right != null) postOrder(node.right);
        System.out.println(node.value);
    }
}
