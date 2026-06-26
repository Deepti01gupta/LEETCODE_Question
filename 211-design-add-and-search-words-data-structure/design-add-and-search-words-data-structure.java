// GIVE TLE IN 1 TEST CASE:

// class WordDictionary {
//     Set<String> st;
//     public WordDictionary() {
//         st=new HashSet<>();
//     }
//     public void addWord(String word) {
//         st.add(word);
//     }
//     public boolean search(String word) {
//         if (!word.contains(".")) {
//             return st.contains(word);
//         }
//         for(String s:st){
//             if(s.length()!=word.length()){
//                 continue;
//             }
//             boolean match=true;
//             for(int i=0; i<s.length(); i++){
//                 if(word.charAt(i)!='.' && word.charAt(i)!=s.charAt(i)) {
//                     match=false;
//                     break;
//                 }
//             }
//             if(match) return true;
//         }
//         return false;
//     }
// }

class WordDictionary {

    class TrieNode{
        TrieNode[] child=new TrieNode[26];
        boolean isend;
    }

    private TrieNode root;

    public WordDictionary() {
        root=new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode cur=root;

        for(char ch:word.toCharArray()){
            int idx=ch-'a';

            if(cur.child[idx]==null){
                cur.child[idx]=new TrieNode();
            }

            cur=cur.child[idx];
        }

        cur.isend=true;
    }
    
    public boolean search(String word) {
        return dfs(word,0,root);    
    }

    private boolean dfs(String word, int idx, TrieNode root){
        
        if(root==null){
            return false;
        }

        if(idx==word.length()){
            return root.isend;
        }

        char ch=word.charAt(idx);

        if(ch=='.'){
            for(TrieNode node:root.child){
                if(node!=null && dfs(word,idx+1,node)){
                    return true;
                }
            }

            return false;
        }

        return dfs(word, idx+1, root.child[ch-'a']);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */