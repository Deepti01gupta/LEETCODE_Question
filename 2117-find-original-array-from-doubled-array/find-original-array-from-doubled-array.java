class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n=changed.length;
        if(n%2!=0){
            return new int[0];
        }

        Arrays.sort(changed);

        Map<Integer,Integer> freq=new HashMap<>();
        for(int x:changed){
            freq.put(x, freq.getOrDefault(x,0)+1);
        }

        int[] ans=new int[n/2];
        int idx=0;

        for(int i:changed){
            if(freq.get(i)==0){
                continue;
            }

            if(i==0){
                if(freq.get(i)<2) return new int[0];
                ans[idx++]=0;
                freq.put(i, freq.get(i)-2);
            }
            else{
                if(freq.getOrDefault(2*i,0)==0){
                    return new int[0];
                }
                ans[idx++]=i;
                freq.put(i, freq.get(i)-1);
                freq.put(2 * i, freq.get(2 * i) - 1);
            }
        }

        return ans;
    }
}