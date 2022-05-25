import java.util.*;

public class calendar {
    public static void main(String[] args) {
        List<Appointment> cal = createAppointment.getAppointments();
        Collections.sort(cal);
        // skriv ut listan
        for (Appointment s: cal){
            System.out.println(s.returnAsString());
        }

    }
    public static class createAppointment {
        public static List<Appointment> getAppointments() {
            Scanner scanner = new Scanner(System.in);
            int n = Integer.parseInt(scanner.nextLine());
            List<Appointment> allAppointments = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String[] a = scanner.nextLine().split("\\s+");
                StringBuilder descr = new StringBuilder();
                for (int j = 3; j < a.length; j++) {
                    descr.append(a[j]);
                    descr.append(" ");
                }
                // Skapa appointment object
                allAppointments.add( new Appointment(a[0], a[1], a[2], descr.toString()));
            }
            return allAppointments;
        }

    }
    public static class Appointment implements Comparable<Appointment> {
        private String time;
        private String month;
        private String day;
        private String clock;
        private String description;

        public Appointment(String month, String day, String clock, String description) {
            // set values on attributes
            this.setMonth(month);
            this.setDay(day);
            this.setClock(clock);
            this.setTime();
            this.setDescription(description);
        }

        // get & set
        public String getTime() {
            return time;
        }
        public String getDescription() {
            return description;
        }
        public void setTime() {
            StringBuilder date = new StringBuilder();
            switch (this.month) {
                case "jan": date.append("01"); break;
                case "feb" : date.append("02"); break;
                case "mar" : date.append("03"); break;
                case "apr" : date.append("04"); break;
                case "maj" : date.append("05"); break;
                case "jun" : date.append("06"); break;
                case "jul" : date.append("07"); break;
                case "aug" : date.append("08"); break;
                case "sep" : date.append("09"); break;
                case "okt" : date.append("10"); break;
                case "nov" : date.append("11"); break;
                case "dec" : date.append("12"); break;
            }
            date.append("-");
            if (Integer.parseInt(this.day) <= 9){
                date.append("0").append(this.day);
            }else{
                date.append(this.day);
            }
            date.append("-").append(this.clock);
            this.time = date.toString();
        }
        public void setMonth(String newMonth) {
            this.month = newMonth;
        }
        public void setDay(String newDay) {
            this.day = newDay;
        }
        public void setClock(String newClock) {
            this.clock = newClock;
        }
        public void setDescription(String newDescription) {
            this.description = newDescription;
        }

        public int compareTo(Appointment a) {
            return this.time.compareTo(a.getTime());
        }

        public String returnAsString(){
            return this.month + " " + this.day + " " + this.clock + " " + this.description;
        }
    }
}
