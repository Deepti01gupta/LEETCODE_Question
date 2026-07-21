class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        
        int count=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='1'){
                count++;
            }
        }

        s="1"+s+"1";

        List<Character> type=new ArrayList<>();
        List<Integer> len=new ArrayList<>();

        int i=0;
        while(i<s.length()){
            char ch=s.charAt(i);
            int j=i;
            while(j<s.length() && s.charAt(j)==ch){
                j++;
            }

            type.add(ch);
            len.add(j-i);

            i=j;
        }

        int gain=0;
        for( i=1; i<type.size()-1; i++){

            if(type.get(i)=='1' && type.get(i-1)=='0' && type.get(i+1)=='0'){

                int cur=len.get(i-1)+len.get(i+1);
                gain=Math.max(gain,cur);

            }
        }

        return gain+count;
    }
}