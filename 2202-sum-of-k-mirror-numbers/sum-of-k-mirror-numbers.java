class Solution {
    public long kMirror(int k, int n) {
        

        int L=1;
        long sum=0L;
        while(n>0){

            int half=(L+1)/2;
            int min=(int)Math.pow(10,half-1);
            int max=(int)Math.pow(10,half)-1;

            for(int num=min; num<=max; num++){
                StringBuilder sb=new StringBuilder(String.valueOf(num));
                String rev=new StringBuilder(sb).reverse().toString();
                if(L%2==0){
                    sb.append(rev);
                }
                else{
                    sb.append(rev.substring(1));
                }

                long val = Long.parseLong(sb.toString());
                String base_k=baseK(val,k);
                if(ispal(base_k)){
                    sum+=val;
                    n--;
                    if(n==0){
                        break;
                    }
                }
            }
            L++;
        }
        return sum;
    }

    public String baseK(long n, int k){
        StringBuilder sum=new StringBuilder();
        while(n>0){
            long rem=n%k;
            sum.append(rem);
            n=n/k;
        }
        return sum.toString();
    }

    public boolean ispal(String s){
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}