package tests;

public class Date implements Comparable<Date> {
	private final int month, day, year;

	public Date(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}
	@Override
	public int compareTo(Date that) {
		if (this.year < that.year) return -1;
		if (this.year > that.year) return 1;
		if (this.month < that.month) return -1;
		if (this.month > that.month) return 1;
		if (this.day < that.day) return -1;
		if (this.day > that.day) return 1;
		return 0;
	}

	public static boolean less (Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}

    public static void exch(Comparable[] array, int i, int j) {
    	Comparable temp = array[i];
    	array[i] = array[j];
    	array[j] = temp;
    }

    public boolean equals(Object that) {
    	if (that == null) return false;    	
    	if (that == this) return true;
        if(that.getClass() != this.getClass()) return false;

    	Date y = (Date) that;
        if (this.year != y.year) return false;
    	if (this.month != y.month) return false;
    	if (this.day != y.day) return false;    	
    	return true;
    }

	public static void main(String[] args) {
		Date d1 = new Date(4,10,1982);
		Date d2 = new Date(12,3,1982);
		
		if (d1.compareTo(d2) < 0) {
			System.out.println("d1 is earlier than d2");
		}
	}
}
