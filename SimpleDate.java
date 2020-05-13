package project1;

/**
 *
 * Stores and analyzes calendar dates.  THIS IS A HELPER CLASS, PLEASE
 * CREATE A SEPARATE CLASS NAMED: SimpleDate.java AND COPY THIS STARTING
 * CODE TO THIS NEW CLASS.
 *
 * 	 NOTE: MUCH MORE CODING IS NEEDED IN THESE METHODS, HOWEVER
 * 	 HERE IS SOME STARTING CODE.
 *
 * @IsabelAlbaitis
 */

public class SimpleDate {

	/** Month represents the current month */
	private int month;

	/** Day represents the current day */
	private int day;

	/** Year represents the current year */
	private int year;

    // Days in each month (assuming months are numbered beginning with 1)
    private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31,
            31, 30, 31, 30, 31};

    private static final String[] MONTHS = {"", "Januaray", "Feburary", "March", "April", "May",
			"June", "July", "August", "September", "October", "November", "December"};

    // Remember to use the Java style guide on all instance variables.
	// Also, remember no TEXT WRAP!!!

    private static final int NUM_MONTHS = 12;
    private static final int DAYS_YEAR = 365;

    public static final int MIN_YEAR = 1753;

	private static int counter = 0;

	/******************************************************************
	 * A default constructor that sets the SimpleDate to the lowest
	 * possible date
	 */
	private SimpleDate(){
		this.month = 1;
		this.day = 1;
		this.year = MIN_YEAR;
		counter ++;
	}

	/******************************************************************
	 * A constructor that accepts a string that represents
	 * a date
	 *  MUCH MORE CODING IS NEEDED IN THIS METHOD, HOWEVER
	 *  HERE IS SOME STARTING CODE.
     *
	 * @param startDate A string that represents a date
	 * @throws IllegalArgumentException if parameter doesn't
	 * represent a valid date.
	 ****************************************************************/
	public SimpleDate (String startDate) {
		String[] parts = startDate.split("/");
		month = Integer.parseInt(parts[0]);
		day = Integer.parseInt(parts[1]);
		year = Integer.parseInt(parts[2]);
		counter ++;
		}

	/******************************************************************
	 * Constructor taking month, day, and year as integers.
	 *
	 * @param month the month for the given simple date
	 * @param day   the day  for the given simple date
	 * @param year  the year  for the given simple date
	 *              	 *  MUCH MORE CODING IS NEEDED IN THIS METHOD, HOWEVER
	 * 	MUCH MORE CODING IS NEEDED IN THIS METHOD, HOWEVER
	 *  HERE IS SOME STARTING CODE.
	 *
	 * @throws IllegalArgumentException if input
	 * doesn't represent a valid date.
	 ******************************************************************/
	public SimpleDate (int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
		counter ++;
	}

	// THE REST OF THE METHODS NEED JAVA STYLE GUIDING.
	public SimpleDate (SimpleDate other) {
		this.day = other.day;
		this.year = other.year;
		this.month = other.month;
		counter ++;
	}

	private  int daysInMonth(int month, int year) {
		if (month == 2 && isLeapYear(year)) {
			return 29;
		}
		return DAYS_IN_MONTH[month];
	}

	public static boolean isLeapYear(int year) {
		return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
	}

	public boolean isLeapYear() {
		return isLeapYear(year);
	}

	public String toString() {
		String d = String.format("%02d", day);
		String y = String.format("%4d", year);
		return (MONTHS[month] + " " + d + ", " + y);
	}


	public boolean equals(Object other) {
        if (this.day == (((SimpleDate) other).getDay()) &&
				this.month == (((SimpleDate) other).getMonth()) &&
				this.year == (((SimpleDate) other).year)){
        	return true;
		}
		return false;
	}

	public static boolean equals (SimpleDate s1, SimpleDate s2){
		if (s1.getDay() == s2.getDay() &&
				s1.getMonth() == s2.getMonth() &&
				s1.getYear() == s2.getYear()){
			return true;
		}
		return false;
	}

	public int compareTo(SimpleDate other) {

		// compares years
		if (this.year > other.year)
			return 1;
		else if (this.year < other.year)
			return -1;

		// compares months only if years are the same
        if (this.year == other.year){
        	if (this.month > other.month) {
				return 1;
        	}
        	else if (this.month < other.month){
        		return -1;
			}
		}

        // compares days only if years and months are the same
		if ((this.year == other.year) && (this.month == other.month)){
			if (this.day > other.day){
				return 1;
			}
			else if (this.day < other.day){
				return -1;
			}
		}

		return 0;
	}

	public int getDay(){
		return day;
	}

	public int getMonth(){
		return month;
	}

	public int getYear(){
		return year;
	}

	public int ordinalDate(){
		int daysTotal = 0;
		for (int i = 0; i < this.month; i++){
			daysTotal += DAYS_IN_MONTH[i];
		}

		daysTotal += this.day;

		if ((isLeapYear() == true) && (this.month > 2)){
			daysTotal += 1;
		}

		return daysTotal;
	}

	public void increment(){
		if ((this.month == 2) && (isLeapYear() == true) && (this.day == 29)){
			this.month = 3;
			this.day = 1;
		}
		else if ((this.day == 31) && (this.month == 12)){
			this.day = 1;
			this.month = 1;
			this.year++;
		}
		else if (this.day == DAYS_IN_MONTH[this.month]){
			this.day = 1;
			this.month++;
		}
		else{
			this.day++;
		}
	}

	public boolean isLastDay(){
		if (this.day == DAYS_IN_MONTH[this.month]){
			return true;
		}
		else{
			return false;
		}
	}

	public void save (String fileName) {
		// your code goes here
	}

	public void load (String fileName) {
	// your code goes here
	}

	// main method used for tesing
	public static void main (String[] args){
		SimpleDate sd = new SimpleDate(2, 17, 2020);
		SimpleDate sd1 = new SimpleDate();
		SimpleDate sd2 = new SimpleDate();
		System.out.println(sd.month + " " + sd.day + " " + sd.year);
		sd.increment();
		System.out.println(sd.month + " " + sd.day + " " + sd.year);
		System.out.println(sd.month);
		System.out.println(sd.day);
		System.out.println(sd.year);
		System.out.println(sd.toString());
		System.out.println(counter);
	}

} // end SimpleDate

