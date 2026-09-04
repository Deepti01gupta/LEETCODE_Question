class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();

        solve(s, new ArrayList<>(), ans);

        return ans;
    }

    private void solve(String s, List<String> ll, List<List<String>> ans){
        if(s.length()==0){
            ans.add(new ArrayList<>(ll));
            return;
        }

        for(int cut=1; cut<=s.length(); cut++){
            String str=s.substring(0,cut);

            if(ispal(str)){
                ll.add(str);
                solve(s.substring(cut), ll, ans);
                ll.remove(ll.size()-1);
            }
        }
    }

    public boolean ispal(String s){
        int i=0;
        int j=s.length()-1;

        while(i<j){
            
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}