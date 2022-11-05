class Graph {
	private int[][] mat;
	private final int Infinit = 9500;
	private int n;
	
	public Graph(int n) {
		this.n = n;
		mat = new int[n + 1][n + 1];
		
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				mat[i][j] = 0;
			}
		}
	}
	
	public int getSize() {
		return n;
	}
	
	public void addArc(int v, int w, int cost) {
		mat[v][w] = cost;
	}
	
	public boolean isArc(int v, int w) {
		if (mat[v][w] != 0) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		String ans = "";
		for (int i = 1; i < n + 1; i++) {
			for(int j = 1; j < n + 1; j++) {
				ans += mat[i][j] + " ";
			}
			ans += "\n";
		}
		return ans;
	}
	
	public int[][] floydWarshall() {
		int result[][];
		result = new int[n + 1][n + 1];
		int k, i, j;
		for(i = 1; i <= n; i++) {
			for(j = 1; j <= n; j++) {
				if(i == j) {
					result[i][j] = 0;
				} else if(isArc(i, j)) {
					result[i][j] = mat[i][j];
				} else {
					result[i][j] = Infinit;
				}
			}
		}
		for(k = 1; k <= n; k++) {
			for(i = 1; i <= n; i++) {
				for(j = 1; j <= n; j++) {
					int dist;
					dist = result[i][k] + result[k][j];
					if(result[i][j] > dist) {
						result[i][j] = dist;
					}
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(4);
		g.addArc(1, 3, 2);
		g.addArc(1, 2, 3);
		g.addArc(2, 4, 6);
		g.addArc(2, 3, 2);
		System.out.println(g);
		System.out.println("Floyd-Warshall");
		int [][] my_matrix = g.floydWarshall();
		System.out.println("distanta minima dintre nodurile 1 si 4 este "+ my_matrix[1][4]); // rezultat - 9
	}
}
