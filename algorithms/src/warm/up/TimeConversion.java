package warm.up;

public class TimeConversion {

    public static void main(String[] args) {
        System.out.println(timeConversion("07:05:45PM"));
    }

    static String timeConversion(String s) {
        String end = s.substring(s.length() - 2);
        String center = s.substring(2, s.length() - 2);
        String start = s.substring(0, 2);
        int hours = Integer.parseInt(start);

        if (end.equals("PM")) {
            if (hours == 12) {
                return s.substring(0, s.length() - 2);
            } else {
                return hours + 12 + center;
            }
        } else {
            if (hours == 12) {
                return "00" + center;
            } else {
                return s.substring(0, s.length() - 2);
            }
        }
    }
}
