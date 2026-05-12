class Solution {
    public String decodeString(String s) {
        Stack<Integer> num_stack= new Stack<>();
        Stack<String> main_stack=new Stack<>();

        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);

            if(ch>='0' && ch<='9'){
                int num=0;

                while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9'){
                    num=num*10 + (int)(s.charAt(i)-'0');
                    i++;
                }
                i--;

                num_stack.push(num);
            }
            else if(ch!=']'){
                main_stack.push(ch+"");
            }
            else{
                String str="";
                while(!main_stack.peek().equals("[")){
                    str=main_stack.pop()+str;
                }
                main_stack.pop();
                int rep_num=num_stack.pop();
                
                StringBuilder sb=new StringBuilder("");
                while(rep_num>0){
                    sb.append(str);
                    rep_num--;
                }
                main_stack.push(sb.toString());
            }
        }
        StringBuilder ans=new StringBuilder("");
        while(main_stack.size()>0){
            ans.insert(0,main_stack.pop());
        }
        return ans.toString();
    }
}