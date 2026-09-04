class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();

        solve(candidates, target, 0, new ArrayList<>(), 0, ans);

        return ans;
    }

    private void solve(int[] arr, int target, int idx, List<Integer> ll, int sum, List<List<Integer>> ans){
        if(sum==target){
            ans.add(new ArrayList<>(ll));
            return;
        }

        if(idx>=arr.length || sum>target){
            return;
        }

        ll.add(arr[idx]);
        solve(arr, target, idx, ll, sum+arr[idx], ans);
        ll.remove(ll.size()-1);

        solve(arr, target, idx+1, ll, sum, ans);
    }
}