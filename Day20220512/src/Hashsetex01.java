import java.util.*;

//중복, 순서 없음


class Num{
	
	private int num;
	public Num(int num) {this.num = num;}
	
	@Override
	
	public String toString() {
		return "num : " + String.valueOf(num);
	}
}
public class Hashsetex01 {

	public static void main(String[] args) {

		Set<Num> set = new HashSet<Num>();
		
		set.add(new Num(5));
		set.add(new Num(5));
		set.add(new Num(1));
		set.add(new Num(3));
		set.add(new Num(2));
		
		System.out.println("cnt : " + set.size());
		
		for(Iterator<Num> itr = set.iterator(); itr.hasNext();) {
			System.out.print(itr.next()+"\t");
		}
		System.out.println();
		
		for(Num s : set)
			System.out.print(s+"\t");
	}

}
