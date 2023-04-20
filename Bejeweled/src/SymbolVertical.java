import java.io.PrintWriter;

public class SymbolVertical extends symbols{
	
	String name = "|";
	
	int count = 0;
	public boolean up = false;
	public boolean up2 = false;

	
	@Override
	public void check(int a, int b, jewels[][] list, PrintWriter file) {
		PrintWriter file_1 = new PrintWriter(file);

		if((a-1) >= 0 && list[a-1][b] instanceof symbols) { //USTTE VARSA
			if(0 <= (a-2) && list[a-2][b] instanceof symbols) { //USTUN USTU VARSA (8DE ISE)
				count += 1;
				list[a][b] = new jewel_space();
				list[a-1][b] = new jewel_space();
				list[a-2][b] = new jewel_space();
				ScoreOfPlayer.scoreOfPlayer += 60;
				file_1.write("Score: 60 points" + "\n");
				if(count == 1) {
					up = true;

				}
				if(count == 2) {
					up2 = true;

				}

			}
			
		}
		if(up == false || (up == true && up2 == false)) {
			if((a+1) < list.length && list[a+1][b] instanceof symbols) { //USTTE YOK ALTTA VAR
				if((a+2) < list.length && list[a+2][b] instanceof symbols) { // ALTTA VE ALTIN ALTINDNA VAR ( 2DE ISE)
					list[a][b] = new jewel_space();
					list[a+1][b] = new jewel_space();
					list[a+2][b] = new jewel_space();
					ScoreOfPlayer.scoreOfPlayer += 60;
					file_1.write("Score: 60 points" + "\n");

				}
			}
		}
	}
	
	
	@Override
	public String toString() {
		return this.name;
		
	}
	
	
}
