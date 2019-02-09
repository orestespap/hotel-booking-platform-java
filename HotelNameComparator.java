import java.util.Comparator;

public class HotelNameComparator implements Comparator<Hotel>{

	@Override
	public int compare(Hotel o1, Hotel o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}

}
