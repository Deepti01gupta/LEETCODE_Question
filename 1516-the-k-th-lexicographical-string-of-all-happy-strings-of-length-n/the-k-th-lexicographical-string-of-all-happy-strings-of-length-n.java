class Solution {
    List<String> ll=new ArrayList<>();
    
    public String getHappyString(int n, int k) {

        solve(n,'*',new StringBuilder());
        Collections.sort(ll);

        if(k>ll.size()){
            return "";
        }
        return ll.get(k-1);
    }

    private void solve(int n, char prev, StringBuilder sb){
        if(n==0){
            ll.add(sb.toString());
            return;
        }

        if(prev!='a'){
            sb.append('a');
            solve(n-1,'a',sb);
            sb.deleteCharAt(sb.length()-1);
        }

        if(prev!='b'){
            sb.append('b');
            solve(n-1,'b',sb);
            sb.deleteCharAt(sb.length()-1);
        }

        if(prev!='c'){
            sb.append('c');
            solve(n-1,'c',sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}