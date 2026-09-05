class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map=new HashMap<>();
        int left=0;
        int ans=0;

        for(int right=0; right<fruits.length; right++){
            int val=fruits[right];
            map.put(val, map.getOrDefault(val, 0)+1);

            while(map.size()>2){
                int temp=fruits[left];
                map.put(temp, map.get(temp)-1);

                if(map.get(temp)==0){
                    map.remove(temp);
                }

                left++;
            }

            ans=Math.max(ans, right-left+1);
        }

        return ans;
    }
}