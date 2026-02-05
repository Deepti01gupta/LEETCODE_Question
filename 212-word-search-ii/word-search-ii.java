class Solution {

    static List<String> ll;

    static class Trie{
		class Node{
			char ch;
			String isterminal;
			HashMap<Character, Node> child;
			public Node(char ch) {
				this.ch=ch;
				child=new HashMap<>();
			}
		}
		
		private Node root=new Node('*');
		
		public void insert(String word) {
			Node curr=root;
			for(int i=0; i<word.length(); i++) {
				char ch=word.charAt(i);
				if(curr.child.containsKey(ch)) {
					curr=curr.child.get(ch);
				}
				else {
					Node nn=new Node(ch);
					curr.child.put(ch, nn);
					curr=nn;
				}
			}
			curr.isterminal=word;
	    }
		
		public void Search(char[][] maze, int i, int j, Node node) {

			if(i<0 || j<0 || i>=maze.length || j>=maze[0].length || !node.child.containsKey(maze[i][j]) || maze[i][j]=='*') {
				return;
			}
			char temp=maze[i][j];
			node=node.child.get(temp);
			if(node.isterminal!=null) {
				ll.add(node.isterminal);
				node.isterminal=null;
			}
			maze[i][j]='*';
			Search(maze,i+1,j,node);
			Search(maze,i-1,j,node);
			Search(maze,i,j+1,node);
			Search(maze,i,j-1,node);
			maze[i][j]=temp;
			
		}
	}

    

    public List<String> findWords(char[][] maze, String[] words) {
        ll=new ArrayList<>();

        Trie t= new Trie();
		for(String s:words) {
			t.insert(s);
		}
		
		for(int i=0; i<maze.length; i++) {
			for(int j=0; j<maze[0].length; j++) {
				if(t.root.child.containsKey(maze[i][j])) {
					t.Search(maze,i,j,t.root);
				}
			}
		}
        return ll;
    }
}