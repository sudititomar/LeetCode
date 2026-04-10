class Solution {
    public int maxDepth(String s) {
        int current=0;
        int max=0;

        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);

            if(ch=='(')
            {
                current++;
                max=Math.max(max,current);
            }
            else if(ch==')')
            {
                current--;
            }

        }
        return max;
        
    }
}