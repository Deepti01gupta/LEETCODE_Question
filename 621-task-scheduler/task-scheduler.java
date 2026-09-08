class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map=new HashMap<>();
        int max=0;

        for(char ch:tasks){
            map.put(ch, map.getOrDefault(ch, 0)+1);
            max=Math.max(map.get(ch), max);
        }

        int count=0;
        for(char key:map.keySet()){
            if(map.get(key)==max){
                count++;
            }
        }

        int val=(max-1)*(n+1) + count;

        return Math.max(val, tasks.length);
    }
}