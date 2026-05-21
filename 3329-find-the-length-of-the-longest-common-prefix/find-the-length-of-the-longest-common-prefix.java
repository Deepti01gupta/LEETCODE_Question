class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> set=new HashSet<>();
        for(int i:arr1){
            while(i>0){
                set.add(i);
                i=i/10;
            }
        }

        int ans=0;
        for(int i:arr2){
            while(i>0){
                if(set.contains(i)){
                    ans=Math.max(ans, String.valueOf(i).length());
                }
                i=i/10;
            }
        }

        return ans;
    }
}