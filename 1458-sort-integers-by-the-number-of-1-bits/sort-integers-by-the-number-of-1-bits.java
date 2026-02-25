class Solution {
    public int[] sortByBits(int[] arr) {

        Integer[] temp=new Integer[arr.length];
        for(int i=0; i<arr.length; i++){
            temp[i]=arr[i];
        }

        Arrays.sort(temp,(a,b)-> {
            int aa=Integer.bitCount(a);
            int bb=Integer.bitCount(b);

            if(aa!=bb){
                return aa-bb;
            }

            return a-b;
        });

        for(int i=0; i<arr.length; i++){
            arr[i]=temp[i];
        }

        return arr;
    }
}