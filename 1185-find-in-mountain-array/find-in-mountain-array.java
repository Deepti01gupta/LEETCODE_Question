/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray arr) {
        int idx=peak(arr);
        if(target==arr.get(idx)){
            return idx;
        }
        int a1=search(arr, target, 0, idx-1, true);
        if(a1!=-1){
            return a1;
        }
        int a2=search(arr, target, idx+1, arr.length()-1, false);
        return a2;
    }

    public int search(MountainArray arr, int t, int lo, int hi, boolean asc){
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            int val=arr.get(mid);
            if(val==t){
                return mid;
            }
            if(asc){
                if(val>t){
                    hi=mid-1;
                }
                else{
                    lo=mid+1;
                }
            }
            else{
                if(val>t){
                    lo=mid+1;
                }
                else{
                    hi=mid-1;
                }
            }
        }
        return -1;
    }

    public int peak(MountainArray arr) {
        int lo=0;
        int hi=arr.length()-1;
        while(lo<hi){
            int mid=lo+(hi-lo)/2;
            if(arr.get(mid)<arr.get(mid+1)){
                lo=mid+1;
            }
            else{
                hi=mid;
            }
        }
        return lo;
    }
}