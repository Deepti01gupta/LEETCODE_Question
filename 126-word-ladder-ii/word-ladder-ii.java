class Solution{
    Map<String, List<String>> parents=new HashMap<>();
    List<List<String>> ans=new ArrayList<>();
    String beginWord;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        this.beginWord=beginWord;
        Set<String> set=new HashSet<>(wordList);
        if (!set.contains(endWord)) return ans;
        Queue<String> q=new LinkedList<>();
        q.add(beginWord);
        Set<String> visited=new HashSet<>();
        visited.add(beginWord);
        boolean found=false;
        while(!q.isEmpty() && !found){
            int size=q.size();
            Set<String> levelVisited=new HashSet<>();
            for(int k=0; k<size; k++){
                String word=q.poll();
                char[] arr=word.toCharArray();
                for(int i=0; i<arr.length; i++){
                    char original=arr[i];
                    for(char ch='a'; ch<='z'; ch++){
                        if(ch==original) continue;
                        arr[i]=ch;
                        String next=new String(arr);
                        if(set.contains(next) && !visited.contains(next)){
                            parents.computeIfAbsent(next, x -> new ArrayList<>()).add(word);
                            if(levelVisited.add(next)){
                                q.add(next);
                            }
                            if(next.equals(endWord)){
                                found=true;
                            }
                        }
                    }
                    arr[i]=original;
                }
            }
            visited.addAll(levelVisited);
        }
        if(found){
            List<String> path=new ArrayList<>();
            path.add(endWord);
            backtrack(endWord, path);
        }
        return ans;
    }
    void backtrack(String word, List<String> path){
        if(word.equals(beginWord)){
            List<String> result=new ArrayList<>(path);
            Collections.reverse(result);
            ans.add(result);
            return;
        }
        for(String parent : parents.getOrDefault(word, new ArrayList<>())){
            path.add(parent);
            backtrack(parent, path);
            path.remove(path.size() - 1);
        }
    }
}



// class pair{
//     String s;
//     List<String> step;
//     pair(String s, List<String> step){
//         this.s=s;
//         this.step=step;
//     }
// }
// class Solution {
//     public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//         List<List<String>> ans=new ArrayList<>();
//         Set<String> set=new HashSet<>(wordList);
//         if(!set.contains(endWord)){
//             return ans;
//         } 
//         Queue<pair> q=new LinkedList<>();
//         List<String> start=new ArrayList<>();
//         start.add(beginWord);
//         q.add(new pair(beginWord, start));
//         while(!q.isEmpty()){
//             Set<String> used = new HashSet<>();
//             int size=q.size();
//             for(int turn=0; turn<size; turn++){
//                 pair rp=q.poll();
//                 String word=rp.s;
//                 List<String> st=rp.step;
//                 if(word.equals(endWord)){
//                     ans.add(new ArrayList<>(st));
//                     continue;
//                 }
//                 for(int i=0; i<word.length(); i++){
//                     char[] arr=word.toCharArray();
//                     for(char ch='a'; ch<='z'; ch++){
//                         char temp=arr[i];
//                         arr[i]=ch;
//                         String str=new String(arr);
//                         if(set.contains(str)){
//                             List<String> next=new ArrayList<>(st);
//                             next.add(str);
//                             q.add(new pair(str, next));
//                             used.add(str);
//                         }
//                         arr[i]=temp;
//                     }
//                 }
//             }
//             set.removeAll(used);
//         }
//         return ans;
//     }
// }