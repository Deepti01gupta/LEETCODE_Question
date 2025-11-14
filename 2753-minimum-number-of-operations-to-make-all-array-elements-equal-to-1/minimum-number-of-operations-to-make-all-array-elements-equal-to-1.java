class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        int c1=0;
        for(int i:nums){
            if(i==1) c1++;
        }
        if(c1>0) return n-c1;

        int ope=Integer.MAX_VALUE;
        for(int i=0 ;i<n; i++){
            int gcd=nums[i];
            for(int j=i+1; j<n; j++){
                gcd=gcd_find(gcd,nums[j]);
                if(gcd==1){
                    ope=Math.min(ope,j-i);
                    break;
                }
            }
        }
        if(ope==Integer.MAX_VALUE){
            return -1;
        }
        return ope+n-1;
    }

    public static int gcd_find(int a, int b) {
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}