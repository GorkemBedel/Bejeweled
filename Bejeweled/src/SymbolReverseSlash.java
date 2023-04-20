import java.io.PrintWriter;

public class SymbolReverseSlash extends symbols {
	
	public boolean left_diagonal = false;

	String name = "\\";
	int count = 0;
	int count2 = 0;
	
	@Override
	public void check(int a, int b, jewels[][] list, PrintWriter file) {
		PrintWriter file_1 = new PrintWriter(file);
		if( (a-1) >= 0 && (b-1) >= 0 && list[a-1][b-1] instanceof jewel_d) {  // SOL UST			
			if(0 <= (a-2) && 0 <= (b-2) && list[a-2][b-2] instanceof jewel_d) {  // SOL UST VAR SAG ALT YOK SOL USTUN SOL USTU KONTROL EDILECEK ( 9DA ISE)
				count +=1;
				list[a][b] = new jewel_space();
				list[a-1][b-1] = new jewel_space();
				list[a-2][b-2] = new jewel_space();
				ScoreOfPlayer.scoreOfPlayer += 90;
				file_1.write("Score: 90 points" + "\n");
				left_diagonal = true;

			}
					
		}if(left_diagonal == false) {
			if( (a+1) < list.length && (b+1) < list[0].length && list[a+1][b+1] instanceof jewel_d) { // SOL UST YOK SAG ALT VAR 
				if( (a+2) < list.length && (b+2) < list[0].length && list[a+2][b+2] instanceof jewel_d) { //SAG ALT VAR SAG ALTIN SAG ALTI DA VAR (1DE ISE)
					count2 += 1;
					list[a][b] = new jewel_space();
					list[a+1][b+1] = new jewel_space();
					list[a+2][b+2] = new jewel_space();
					ScoreOfPlayer.scoreOfPlayer += 90;
					file_1.write("Score: 90 points" + "\n");
				}	
		
		

			}
		}
	}

	@Override
	public String toString() {
		return this.name;
		
	}
	
	
}
