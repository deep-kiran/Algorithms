class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<String> res =new Stack<>();
        int ind =0;
        res.push("");
        while(ind<s.length()){
            if(Character.isDigit(s.charAt(ind))){
                int start =ind;
                while(Character.isDigit(s.charAt(ind+1)))ind++;
                count.push(Integer.parseInt(s.substring(start,ind+1)));                
            }else if(s.charAt(ind)=='['){
                res.push("");
            }else if(s.charAt(ind)==']'){
                int c =count.pop();
                //System.out.print(c+" "+ res.peek());
                String t =res.pop();
                StringBuilder sb =new StringBuilder();
                while(c-->0){
                    sb.append(t);          
                }
                res.push(res.pop()+sb.toString());
            }
            else{
                res.push(res.pop()+s.charAt(ind));
            }      
            ind++;
        }
        return res.pop();
    }
}
