package leetCode.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private static class TrieNode{
        Map<Character,TrieNode> trieNodeMap;
        boolean endOfWord = false;

        public TrieNode(){
            trieNodeMap = new HashMap<>();
        }

        public TrieNode addNode(Character key){
            TrieNode value = trieNodeMap.get(key);
            if(value ==null ){
                value = new TrieNode();
                trieNodeMap.put(key, value);
            }
            return value;
        }

        public TrieNode getNode(Character key){
            return trieNodeMap.get(key);
        }

        public void setEndOfWord(boolean endOfWord){
            this.endOfWord = endOfWord;
        }

        public boolean getEndOfWord(){
            return this.endOfWord;
        }
    }

    TrieNode rootNode;
    public Trie() {
        rootNode = new TrieNode();
    }

    public void insert(String word) {
        TrieNode currentNode = rootNode;
        for(int i = 0; i< word.length();i++){
            Character character = word.charAt(i);
            currentNode = currentNode.addNode(character);
        }
        currentNode.setEndOfWord(true);
    }

    public boolean search(String word) {
        TrieNode currentNode = rootNode;

        for(int i = 0; i< word.length();i++){
            Character character = word.charAt(i);
            currentNode = currentNode.getNode(character);
            if(currentNode == null){
                return false;
            }
        }

        return currentNode.getEndOfWord();
    }

    public boolean startsWith(String prefix) {
        TrieNode currentNode = rootNode;

        for(int i = 0; i< prefix.length();i++){
            Character character = prefix.charAt(i);
            currentNode = currentNode.getNode(character);
            if(currentNode == null){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True
    }
}


