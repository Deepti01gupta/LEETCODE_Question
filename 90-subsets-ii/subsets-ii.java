class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);

        solve(nums, 0, new ArrayList<>(), ans);

        return ans;
    }

    private void solve(int[] arr, int idx, List<Integer> ll, List<List<Integer>> ans){
        if(ans.contains(ll)){
            return;
        }

        ans.add(new ArrayList<>(ll));

        for(int i=idx; i<arr.length; i++){
            if(i>idx && arr[i]==arr[i-1]){
                continue;
            }

            ll.add(arr[i]);
            solve(arr, i+1, ll, ans);
            ll.remove(ll.size()-1);
        }
    }
}