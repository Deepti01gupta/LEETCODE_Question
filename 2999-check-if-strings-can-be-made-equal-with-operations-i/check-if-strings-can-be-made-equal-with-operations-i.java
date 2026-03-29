class Solution {
    public boolean canBeEqual(String s1, String s2) {
        if(s1.equals(s2)){
            return true;
        }
        char[] arr=s1.toCharArray();

        // swap (0,2)
        char temp=arr[0];
        arr[0]=arr[2];
        arr[2]=temp;
        String t1=new String(arr);
        if(t1.equals(s2)){
            return true;
        }

        // swap (1,3)
        temp=arr[1];
        arr[1]=arr[3];
        arr[3]=temp;
        String t2=new String(arr);
        if(t2.equals(s2)){
            return true;
        }

        // reset and try only (1,3)
        arr=s1.toCharArray();
        temp=arr[1];
        arr[1]=arr[3];
        arr[3]=temp;
        String t3=new String(arr);
        if(t3.equals(s2)){
            return true;
        }

        return false;
    }
}