import java.io.PrintWriter;

public class jewel_d extends jewels {
	
	//DIAMOND = 30 PUAN
	String name = "D";
	public boolean left_diagonal = false;

	int count = 0;
	int count2 = 0;
	
	public  jewel_d() {
	}
		
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

		if(count == 0 && count2 == 0) {
			if( (a-1) >= 0 && (b+1) < list[0].length && list[a-1][b+1] instanceof jewel_d) {  // SAG UST
				if( 0 <= (a-2) && (b+2) < list[0].length && list[a-2][b+2] instanceof jewel_d) { // SAG UST VAR SOL ALT YOK SAG USTUN SAG USTU KONTROL EDILECEK ( 7DE ISE)
					list[a][b] = new jewel_space();
					list[a-1][b+1] = new jewel_space();
					list[a-2][b+2] = new jewel_space();
					ScoreOfPlayer.scoreOfPlayer += 90;
					file_1.write("Score: 90 points" + "\n");
				}
				
				
			}else if( (a+1) < list.length && (b-1) >= 0 && list[a+1][b-1] instanceof jewel_d) { // SAG UST YOK SOL ALT VAR
				if( (a+2) < list.length && 0 <= (b-2) && list[a+2][b-2] instanceof jewel_d) { // SOL ALT VAR SOL ALTIN SOL ALTI DA VAR ( 3TE ISE)
					list[a][b] = new jewel_space();
					list[a+1][b-1] = new jewel_space();
					list[a+2][b-2] = new jewel_space();
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

