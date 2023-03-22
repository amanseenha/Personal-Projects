import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class App {

  public static void main(String[] args) {
    int year = 2023;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate startDate = LocalDate.of(year, Month.MARCH, 22);
    int counter = 0, wt = 0, coa = 0, os = 0, dbms = 0, afl = 0, pdc = 0;

    while (startDate.getYear() == year) {
      if (
        startDate.getDayOfWeek() != DayOfWeek.SATURDAY &&
        startDate.getDayOfWeek() != DayOfWeek.SUNDAY
      ) {
        if (startDate.equals(LocalDate.of(2023, Month.MAY, 8))) {
          break;
        }
        switch (startDate.getDayOfWeek()) {
          case MONDAY:
            coa++;
            afl++;
            pdc++;
            break;
          case TUESDAY:
          dbms++;
          pdc++;
          afl++;
          os++;
          break;
          case WEDNESDAY:
          afl++;
          dbms++;
          wt++;
          os++;
          coa++;
          pdc++;
          break;
          case THURSDAY:
          wt++;
          pdc++;
          dbms++;
          coa++;
          break;
          case FRIDAY:
          os++;
          coa++;
          afl++;
          break;
        }
        if (
          !startDate.equals(LocalDate.of(2023, Month.MARCH, 30)) &&
          !startDate.equals(LocalDate.of(2023, Month.APRIL, 7)) &&
          !startDate.equals(LocalDate.of(2023, Month.APRIL, 14))
        ) {
          counter++;
          System.out.println(counter + ". " + startDate.format(formatter));
        }
      }
      startDate = startDate.plusDays(1);
    }
    System.out.println("Total working days: " + counter);
    System.out.println("WT left: " +wt);
    System.out.println("COA left: "+coa);
    System.out.println("OS left: "+os);
    System.out.println("DBMS left: "+dbms);
    System.out.println("AFL left: "+afl);
    System.out.println("PDC left: "+pdc);
  }
}
