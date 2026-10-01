class Solution {
    public boolean isValid(String s)
    {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);
            else{
                if(ch == ')'){
                    if(stack.isEmpty() == true || stack.peek() != '(')
                        return false;
                    stack.pop();
                }
                else if(ch == '}'){
                    if(stack.isEmpty() == true || stack.peek() != '{')
                        return false;
                    stack.pop();
                }
                else{
                    if(stack.isEmpty() == true || stack.peek() != '[')
                        return false;
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty() == false)
            return false;
        return true;
    }
}