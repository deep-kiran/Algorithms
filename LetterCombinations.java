class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        String arr[] ={"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res =new ArrayList<>();
        if(digits==null ||digits.length()==0)return res;
        res.add("");
        for(int i=0;i<digits.length();i++){
            String chars =arr[digits.charAt(i)-'0'];
            ArrayList<String> temp =new ArrayList<>();
            for(int c=0;c<chars.length();c++){
                for(int j=0;j<res.size();j++){
                    temp.add(res.get(j)+chars.charAt(c));
                }
            }
            res =temp;
        }            
        return res;        
    }
}
