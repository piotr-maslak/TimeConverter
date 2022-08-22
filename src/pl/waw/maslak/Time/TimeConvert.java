package pl.waw.maslak.Time;

/**
 *
 * @author maslak
 */
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

class TimeConvert extends GregorianCalendar {
    
    public long Convert(String s) {

        int year;
        int month;
        int day;
        int hour;
        int minute;
        int second;

        String d = s.substring(0, s.indexOf(' '));
        int Dash1 = d.indexOf('-');
        int Dash2 = d.indexOf('-', Dash1 + 1);
        year = Integer.parseInt(d.substring(0, Dash1));
        month = Integer.parseInt(d.substring(Dash1 + 1, Dash2)) - 1;
        day = Integer.parseInt(d.substring(Dash2 + 1));

        String t = s.substring(s.indexOf(' ') + 1);
        int Colon1 = t.indexOf(':');
        int Colon2 = t.indexOf(':', Colon1 + 1);
        hour = Integer.parseInt(t.substring(0, Colon1));
        minute = Integer.parseInt(t.substring(Colon1 + 1, Colon2));
        second = Integer.parseInt(t.substring(Colon2 + 1));

        this.set(year, month, day, hour, minute, second);
        return this.getTimeInMillis() / 1000;
    }

    public String Convert(long t) {

        String sMonth;
        String sDay;
        String sHour;
        String sMinute;
        String sSecond;

        this.setTime(new Date(t * 1000));

        if (this.get(Calendar.MONTH) + 1 < 10) {
            sMonth = "0" + String.valueOf(this.get(Calendar.MONTH) + 1);
        } else {
            sMonth = String.valueOf(this.get(Calendar.MONTH) + 1);
        }
        if (this.get(Calendar.DATE) < 10) {
            sDay = "0" + String.valueOf(this.get(Calendar.DATE));
        } else {
            sDay = String.valueOf(this.get(Calendar.DATE));
        }
        if (this.get(Calendar.HOUR_OF_DAY) < 10) {
            sHour = "0" + String.valueOf(this.get(Calendar.HOUR_OF_DAY));
        } else {
            sHour = String.valueOf(this.get(Calendar.HOUR_OF_DAY));
        }
        if (this.get(Calendar.MINUTE) < 10) {
            sMinute = "0" + String.valueOf(this.get(Calendar.MINUTE));
        } else {
            sMinute = String.valueOf(this.get(Calendar.MINUTE));
        }
        if (this.get(Calendar.SECOND) < 10) {
            sSecond = "0" + String.valueOf(this.get(Calendar.SECOND));
        } else {
            sSecond = String.valueOf(this.get(Calendar.SECOND));
        }

        return String.valueOf(this.get(Calendar.YEAR)) + "-" + sMonth + "-" + sDay + " " + sHour + ":" + sMinute + ":" + sSecond;
    }

    public static void main(String[] args) {
        TimeConvert test = new TimeConvert();
        System.out.println(test.Convert("2015-03-14 12:08:00"));
        System.out.println(test.Convert(1426331285));
    }
}
