import java.io.Serializable;

public class AllInclusive extends Reservation implements Serializable{
	
	private int meals;
	private int costpermeal;
	
	public AllInclusive(int days, int meals, int cost, int costpermeal) {
		super(days,cost);
		this.meals=meals;
		this.costpermeal=costpermeal;
	}
	
	public double calculateCost() {
		return super.calculateCost()+meals*costpermeal;
	}
	
	public int getmeals() {
		return meals;
	}
	
	@Override
	public String toString() {
		return super.toString()+System.lineSeparator()+"Meals: "+meals;
	}
}
