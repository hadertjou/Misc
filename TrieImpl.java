class TrieNode {
    Character c;
    Boolean isLeaf = false;
    HashMap<Character, TrieNode> children = new HashMap<>();
    public TrieNode() {}
    public TrieNode(Character c) {
        this.c = c;
    }
}

class Trie {
    private TrieNode root;
    
    public Trie() {this.root = new TrieNode();}
    public void insertWord(String word) {
        if(word == null || word.length() == 0) {
            return;
        }
        TrieNode cur = this.root;
        for(char c : word.toCharArray())
        {
            if(cur.children.containsKey(c)) {
                cur = cur.children.get(c);
            }
            else {
                TrieNode letter = new TrieNode(c);
                cur.children.put(c, letter);
                cur = cur.children.get(c);
            }
            
        }
        
        if(cur.children.isEmpty())
        {
            cur.isLeaf = true;
        }
    }
    public Boolean searchWord(String word) {
        TrieNode cur = this.root;
        for(char c : word.toCharArray())
        {
        
            if(cur.children.containsKey(c))
            {
                cur = cur.children.get(c);
            }
            else {
                return false;
            }

        }
        
        return true;


    }
    public Boolean searchPrefix(String word) {
        TrieNode cur = this.root;
        for(char c : word.toCharArray())
        {
            if(cur.children.containsKey(c))
            {
                cur = cur.children.get(c);
            }
            else {
                return false;
            }

        }
        
        if(cur.isLeaf) {
            return false;
        }
        
        return true;
    }
    
    
}