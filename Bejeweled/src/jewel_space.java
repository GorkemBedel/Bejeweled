import java.io.PrintWriter;

public class jewel_space extends jewels {
 
	String name = " ";
	
	@Override
	public void check(int a, int b, jewels[][] list,PrintWriter file) {
		
	}
	
	@Override
	public String toString() {
		return this.name;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
