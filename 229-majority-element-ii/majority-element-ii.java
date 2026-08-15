class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int ele1=0;
        int ele2=0;

        int c1=0;
        int c2=0;

        for(int i:nums){
            if(ele1==i){
                c1++;
            }
            else if(ele2==i){
                c2++;
            }
            else if(c1==0){
                ele1=i;
                c1=1;
            }
            else if(c2==0){
                ele2=i;
                c2=1;
            }
            else{
                c1--;
                c2--;
            }
        }

        c1=0;
        c2=0;

        for(int n:nums){
            if(n==ele1) c1++;
            else if(n==ele2) c2++;
        }

        List<Integer> ans = new ArrayList<>();

        if(c1>nums.length/3){
            ans.add(ele1);
        }
        if(c2>nums.length/3){
            ans.add(ele2);
        }

        return ans;
    }
}