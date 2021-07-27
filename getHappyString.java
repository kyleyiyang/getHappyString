class Solution {
    Queue<String> pq;
    public String getHappyString(int n, int k) {
        pq=new PriorityQueue<>((x,y)->y.compareTo(x));
        char[] chars={'a','b','c'};
        backtrack(n,k,new StringBuilder(),chars);
        if (k>pq.size()) return "";
        return pq.poll();
    }
    public void backtrack(int n,int k,StringBuilder sb,char[] chars) {
        if (sb.length()==n) {
            pq.offer(sb.toString());
            if (pq.size()>k) pq.poll();
            return;
        }
        for (char c:chars) {
            if (sb.length()>0 && c==sb.charAt(sb.length()-1)) continue;
            sb.append(c);
            backtrack(n,k,sb,chars);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
