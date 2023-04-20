
public class leaderboard implements Comparable<leaderboard> {
	
	String name;
	Integer point;
	
	public leaderboard(String name, Integer point) {
		this.name = name;
		this.point = point;
	}
	
	

	@Override
	public int compareTo(leaderboard o) {
		return this.point.compareTo(o.point);
	}
	

}
