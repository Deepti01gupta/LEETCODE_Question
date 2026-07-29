class Solution {

    public int findWinningPlayer(int[] skills, int k) {

        int winner=0;
        int count=0;

        for(int i=1; i<skills.length; i++){
            
            if(skills[winner]>skills[i]){
                count++;
            }
            else{
                winner=i;
                count=1;
            }

            if(count==k){
                return winner;
            }
        }

        int max=0;

        for(int i=1; i<skills.length; i++){
            if(skills[i]>skills[max]){
                max=i;
            }
        }

        return max;
    }

    // public int findWinningPlayer(int[] skills, int k) {
    //     Deque<Integer> q=new LinkedList<>();

    //     for(int i=0; i<skills.length; i++){
    //         q.addLast(i);
    //     } 

    //     int t=0;
    //     int ele=-1;
        
    //     while(true){

    //         int a=q.removeFirst();
    //         int b=q.removeFirst();

    //         if(skills[a]>skills[b]){

    //             q.addFirst(a);
    //             q.addLast(b);

    //             if(ele!=-1 && skills[ele]==skills[a]){
    //                 t++;
    //             }
    //             else{
    //                 ele=a;
    //                 t=1;
    //             }

    //             if(t==k){
    //                 return a;
    //             }
    //         }

    //         else{

    //             q.addFirst(b);
    //             q.addLast(a);

    //             if(ele!=-1 && skills[ele]==skills[b]){
    //                 t++;
    //             }

    //             else{
    //                 ele=b;
    //                 t=1;
    //             }

    //             if(k==t){
    //                 return b;
    //             }
    //         }
    //     }
    // }
}