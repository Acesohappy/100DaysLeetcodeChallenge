class Trie{
    String word;
    Trie chars[];
    public Trie(){
        chars=new Trie[26];
    }
}
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans=new ArrayList<>();
        int R=board.length,C=board[0].length;
        Trie root=buildTrie(words);
        for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                int ti=board[row][col]-'a';
                dfs(R,C,row,col,board,root.chars[ti],ans);
            }
        }
        return ans;
    }
    int diff[][]=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    private void dfs(int R,int C,int row,int col,char board[][],
    Trie node,List<String> ans){
        
        if(node==null){
            return;
        }
        if(node.word!=null){
            ans.add(node.word);
            node.word=null;
        }
        char ch=board[row][col];
        board[row][col]='*';
        
        for(int i=0;i<4;i++){
            int adjr=row+diff[i][0];
            int adjc=col+diff[i][1];
            if(adjr>=0 && adjr <R && adjc >= 0 && adjc <C){
                if(board[adjr][adjc]!='*'){
                    int ti=board[adjr][adjc]-'a';
                    dfs(R,C,adjr,adjc,board,node.chars[ti],ans);
                }
                
            }
        }
        board[row][col]=ch;
    }

    private Trie buildTrie(String words[]){
        Trie root = new Trie();
        for(String word:words){
            Trie curr=root;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                int ti=ch-'a';
                if(curr.chars[ti]==null){
                    curr.chars[ti]=new Trie();
                }
                curr=curr.chars[ti];
                if(i==word.length()-1){
                    curr.word=word;
                }
            }
        }
        return root;
    }
    
}
