class Solution {
    public long dividePlayers(int[] skill) {
        long total=0;
        for(int i:skill){
            total+=i;
        }
        
        int n=skill.length/2;
        if(total%n!=0){
            return -1;
        }

        Arrays.sort(skill);
        long sum=total/n;
        long ans=0;
        int i=0, j=skill.length-1;
        while(i<j){
            int cur=skill[i]+skill[j];
            if(cur==sum){
                ans+=(skill[i]*skill[j]);
            }
            else{
                return -1;
            }
            i++;
            j--;
        }

        return ans;

    }
}