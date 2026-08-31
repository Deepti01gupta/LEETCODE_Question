class Solution {
    class Pair{
        int freq;
        char ch;
        Pair(int f, char c){
            this.freq=f;
            this.ch=c;
        }
    }

    public String frequencySort(String s) {
        HashMap<Character, Integer> map=new HashMap<>();

        for(char ch:s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        Pair[] freq=new Pair[map.size()];

        int idx=0;

        for(Map.Entry<Character, Integer> entry:map.entrySet()){
            freq[idx++]=new Pair(entry.getValue(), entry.getKey());
        }

        Arrays.sort(freq, (p1, p2) -> {
            if(p1.freq != p2.freq){
                return p2.freq - p1.freq;
            }

            return p1.ch - p2.ch;
        });

        StringBuilder result=new StringBuilder();

        for(Pair p : freq){
            for(int i=0; i<p.freq; i++){
                result.append(p.ch);
            }
        }

        return result.toString();

    }
}