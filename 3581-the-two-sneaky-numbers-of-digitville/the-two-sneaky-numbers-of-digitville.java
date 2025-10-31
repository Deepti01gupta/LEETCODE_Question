class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        List<Integer> ll=new ArrayList<>();
        Map<Integer, Integer> mp=new HashMap<>();
        for(int i:nums){
            mp.put(i,mp.getOrDefault(i,0)+1);
            if(mp.get(i)==2){
                ll.add(i);
            }
        }
        Collections.sort(ll);
        return new int[]{ll.get(0),ll.get(1)};
    }
}