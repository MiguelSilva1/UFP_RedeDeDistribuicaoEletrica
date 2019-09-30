package projeto.imports;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date {

    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;

    /**
     * @return the second
     */
    public int getSecond() {
        return second;
    }

    /**
     * @param second the second to set
     */
    public void setSecond(int second) {
        this.second = second;
    }

    /**
     * @return the minute
     */
    public int getMinute() {
        return minute;
    }

    /**
     * @param minute the minute to set
     */
    public void setMinute(int minute) {
        this.minute = minute;
    }

    /**
     * @return the hour
     */
    public int getHour() {
        return hour;
    }

    /**
     * @param hour the hour to set
     */
    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date(int year, int month, int day, int hour, int minute, int second) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public Date() {
        Calendar gregCalendar = new GregorianCalendar();
        this.year = (short) gregCalendar.get(Calendar.YEAR);
        this.month = (short) gregCalendar.get(Calendar.MONTH);
        this.day = (short) gregCalendar.get(Calendar.DAY_OF_MONTH);
        this.hour = (short) gregCalendar.get(Calendar.HOUR_OF_DAY);
        this.minute = (short) gregCalendar.get(Calendar.MINUTE);
        this.second = (short) gregCalendar.get(Calendar.SECOND);
    }

    @Override
    public String toString() {
        return "Date{" + "year=" + year + ", month=" + month + ", day=" + day + ", hour=" + hour + ", minute=" + minute + ", second=" + second + '}';
    }

    public int compareTo(Date d) {
        if (this.year == d.getYear() && this.month == d.getMonth() && this.day == d.getDay()
                && this.hour == d.getHour() && this.minute == d.getMinute() && this.second == d.getSecond()) {
            return 0;
        }
        return (this.beforeDate(d) ? -1 : 1);
    }

    public boolean beforeDate(Date d) {
        if (this.year < d.year) {
            return true;
        } else if (this.year == d.year) {
            if (this.month < d.month) {
                return true;
            } else if (this.month == d.month) {
                if (this.day < d.day) {
                    return true;
                } else if (this.day == d.day) {
                    if (this.hour < d.hour) {
                        return true;
                    } else if (this.hour == d.hour) {
                        if (this.minute < d.minute) {
                            return true;
                        } else if (this.minute == minute) {
                            if (this.second < d.second) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean afterDate(Date d) {
        if (this.year == d.year && this.month == d.month && this.day == d.day) {
            return false;
        }
        return !this.beforeDate(d);
    }
}
