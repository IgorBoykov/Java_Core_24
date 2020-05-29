package Task;

public class Time {

	public int min;
	public int hour;

	public Time(int min, int hour) {
		if ((min >= 0 && min < 60) && (hour >= 0 && hour < 24)) {
			this.min = min;
			this.hour = hour;
		} else {
			System.err.println("Такого часу не існує");
		}
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hour;
		result = prime * result + min;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		if (hour != other.hour)
			return false;
		if (min != other.min)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Time [min=" + min + ", hour=" + hour + "]";
	}

	public static Time sumTime(Time time1, Time time2) {
		int hour = time1.getHour() + time2.getHour();
		int min = time1.getMin() + time2.getMin();
		if (min > 60) {
			hour += 1;
			min = min - 60;
		}
		if (hour >= 24) {
			hour = hour - 24;
		}
		return new Time(hour, min);
	}

}
