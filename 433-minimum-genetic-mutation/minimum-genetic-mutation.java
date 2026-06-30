class Pair{
    String first;
    int second;
    Pair(String first, int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(startGene,0));
        Set<String> set=new HashSet<String>();
        int n=bank.length;
        for(int i=0; i<n; i++){
            set.add(bank[i]);
        }

        char[] arr={'A','C','G','T'};

        set.remove(startGene);
        while(!q.isEmpty()){
            String word=q.peek().first;
            int step=q.peek().second;
            q.remove();
            if(word.equals(endGene) == true){
                return step;
            }
            for(int i=0; i<word.length(); i++){
                for(char ch:arr){
                    char replace[]=word.toCharArray();
                    replace[i]=ch;
                    String replaceword=new String(replace);

                    if(set.contains(replaceword)==true){
                        set.remove(replaceword);
                        q.add(new Pair(replaceword,step+1));
                    }
                }
            }
        }
        return -1;
    }
}