class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0){
            return "0";
        }

        StringBuilder res=new StringBuilder();

        if((long)numerator * (long) denominator < 0){
            res.append("-");
        }

        long absNum=Math.abs((long)numerator);
        long absDen=Math.abs((long)denominator);

        long div= absNum/absDen;

        res.append(div);

        long remain=absNum%absDen;
        if(remain==0){
            return res.toString();
        }

        res.append(".");

        Map<Long, Integer> map = new HashMap<>();

        while(remain!=0){
            if(map.containsKey(remain)){
                res.insert(map.get(remain),"(");
                res.append(")");
                break;
            }

            map.put(remain,res.length());

            remain*=10;
            long digit=remain/absDen;
            res.append(digit);

            remain%=absDen;
        }
        return res.toString();
    }
}