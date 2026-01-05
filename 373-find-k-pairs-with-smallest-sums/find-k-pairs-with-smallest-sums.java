class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ll=new ArrayList<>();
        if(nums1.length==0 || nums2.length==0 || k==0){
            return ll;
        }

        int n=nums1.length;
        int m=nums2.length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> Integer.compare(a[0],b[0]));

        for(int i=0; i<Math.min(k,nums1.length); i++){
            pq.add(new int[]{nums1[i]+nums2[0],i,0});
        }

        while(k-->0 && !pq.isEmpty()){
            int[] rp=pq.poll();
            int i=rp[1];
            int j=rp[2];

            ll.add(Arrays.asList(nums1[i], nums2[j]));

            if(j+1<nums2.length){
                pq.add(new int[]{nums1[i]+nums2[j+1],i,j+1});
            }
        }
        return ll;
    }


    // public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    //     PriorityQueue<List<Integer>> pq=new PriorityQueue<>(
    //         (a,b)-> Integer.compare(a.get(0)+a.get(1), b.get(0)+b.get(1))
    //     );

    //     for(int i=0; i<nums1.length; i++){
    //         for (int j = 0; j < nums2.length; j++) {
    //             pq.add(Arrays.asList(nums1[i], nums2[j]));
    //         }
    //     }

    //     List<List<Integer>> ll=new ArrayList<>();
    //     while(k-->0 && !pq.isEmpty()){
    //         ll.add(pq.poll());
    //     }
    //     return ll;
    // }
}