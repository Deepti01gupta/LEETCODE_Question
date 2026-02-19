class Solution {

    
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, List<Integer>> map=new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            map.computeIfAbsent(ch, k-> new ArrayList<>()).add(i);
        }

        int count=0;

        for(String word:words){
            int prev=-1;
            boolean issub=true;

            for(char ch:word.toCharArray()){
                if(!map.containsKey(ch)){
                    issub=false;
                    break;
                }

                List<Integer> list=map.get(ch);

                int pos=Collections.binarySearch(list, prev+1);

                if(pos<0){
                    pos=-(pos+1);
                }

                if(pos==list.size()){
                    issub=false;
                    break;
                }

                prev=list.get(pos);
            }

            if(issub){
                count++;
            }
        }

        return count;
    }
}