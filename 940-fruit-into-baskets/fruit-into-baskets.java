class Solution {
    public int totalFruit(int[] fruits) {

        Map<Integer, Integer> mp=new HashMap<>();
        int left=0;
        int max=0;

        for(int right=0; right<fruits.length; right++){
            mp.put(fruits[right],mp.getOrDefault(fruits[right],0)+1);

            // jaise hi mp k size 2 se jyada hoga to left wale element ko check krke bahar krte rhenge
            while(mp.size()>2){
                mp.put(fruits[left],mp.get(fruits[left])-1);
                if(mp.get(fruits[left])==0){
                    mp.remove(fruits[left]);
                }
                left++;
            }
            max=Math.max(max,right-left+1);
        }
        return max;




        // Map<Integer, Integer> mp=new HashMap<>();
        // for(int i:fruits){
        //     mp.put(i,mp.getOrDefault(i,0)+1);
        // } 

        // List<Integer> ll=new ArrayList<>();
        // for(int i:mp.keySet()){
        //     ll.add(i);
        // }

        // ll.sort((a,b)->{
        //     if(mp.get(b).compareTo(mp.get(a))==0){
        //         return a-b;
        //     }
        //     return mp.get(b).compareTo(mp.get(a));
        // });

        // int ans=0;
        // for(int i=0; i<Math.min(2,ll.size()); i++){
        //     ans+=mp.get(ll.get(i));
        // }
        // return ans;
    }
}