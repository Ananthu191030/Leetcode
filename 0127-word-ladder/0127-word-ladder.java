class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair<String,Integer>> q=new LinkedList<>();
        Set<String> st=new HashSet<>(wordList);
        q.add(new Pair<>(beginWord,1));
        st.remove(beginWord);
        while(!q.isEmpty()){
            String word=q.peek().getKey();
            int steps=q.peek().getValue();
            q.poll();
            if(word.equals(endWord)) return steps;
            for(int i=0;i<word.length();i++){
                char[] arr=word.toCharArray();
                char c=arr[i];
                for(char ch='a';ch<='z';ch++){
                    arr[i]=ch;
                    String newStr=new String(arr);
                    if(st.contains(newStr)){
                        st.remove(newStr);
                        q.add(new Pair<>(newStr,steps+1));

                    }
                }
                // arr[i]=c;
            }
        }
        return 0;
    }
}