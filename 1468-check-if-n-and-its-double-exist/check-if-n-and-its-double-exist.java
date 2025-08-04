class Solution {
    public boolean checkIfExist(int[] arr) {

        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(2 * num) || (num % 2 == 0 && set.contains(num / 2))) {
                return true;
            }
            set.add(num);
        }
        return false;



        // for(int i=0; i<arr.length; i++){
        //     for(int j=i+1; j<arr.length; j++){
        //         if(i != j && arr[i] == 2*arr[j]){
        //             return true;
        //         }
        //     }
        // }
        // return false;
    }
}