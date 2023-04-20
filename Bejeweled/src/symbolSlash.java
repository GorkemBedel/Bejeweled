import java.io.PrintWriter;

public class symbolSlash extends symbols{
	
	
	String name = "/";

	
	@Override
	public void check(int a, int b, jewels[][] list, PrintWriter file) {
		PrintWriter file_1 = new PrintWriter(file);

		if( (a-1) >= 0 && (b+1) < list[0].length && list[a-1][b+1] instanceof symbols) {  // SAG UST
			if( 0 <= (a-2) && (b+2) < list[0].length && list[a-2][b+2] instanceof symbols ) { // SAG UST VAR SOL ALT YOK SAG USTUN SAG USTU KONTROL EDILECEK ( 7DE ISE)
				list[a][b] = new jewel_space();
				list[a-1][b+1] = new jewel_space();
				list[a-2][b+2] = new jewel_space();
				ScoreOfPlayer.scoreOfPlayer += 60;
				file_1.write("Score: 60 points" + "\n");
			}
			
			
		}else if( (a+1) < list.length && (b-1) >= 0 && list[a+1][b-1] instanceof symbols) { // SAG UST YOK SOL ALT VAR
			if( (a+2) < list.length && 0 <= (b-2) && list[a+2][b-2] instanceof symbols) { // SOL ALT VAR SOL ALTIN SOL ALTI DA VAR ( 3TE ISE)
				list[a][b] = new jewel_space();
				list[a+1][b-1] = new jewel_space();
				list[a+2][b-2] = new jewel_space();
				ScoreOfPlayer.scoreOfPlayer += 60;
				file_1.write("Score: 60 points" + "\n");

				}
			}			
	}

	
	
	@Override
	public String toString() {
		return this.name;
		
	}
	
	
	
}
