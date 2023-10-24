package 백준.전화번호목록;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class 전화번호목록 {
    static class TrieNode {
        Map<Character, TrieNode> childNode = new HashMap<>();
        boolean isEnd;

        public void insert(String word) {
            TrieNode trieNode = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                trieNode.childNode.putIfAbsent(c, new TrieNode());

                trieNode = trieNode.childNode.get(c);
            }
            trieNode.isEnd = true;
        }

        public boolean contains(String word) {
            TrieNode trieNode = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (trieNode.childNode.get(c) == null) {
                    return false;
                }
                trieNode = trieNode.childNode.get(c);
            }

            if(trieNode.isEnd) {
                if(trieNode.childNode.isEmpty()) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            TrieNode trieNode = new TrieNode();
            String[] nums = new String[n];
            for (int j = 0; j < n; j++) {
                String str = br.readLine();
                trieNode.insert(str);
                nums[j] = str;
            }

            boolean flag = false;
            for (String num : nums) {
                if (trieNode.contains(num)) {
                    bw.write("NO"+"\n");
                    flag = true;
                    break;
                }
            }
            if(flag) continue;
            bw.write("YES"+"\n");

        }
        bw.flush();
        bw.close();
    }
}
