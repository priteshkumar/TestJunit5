import java.util.Calendar;

public class DateValidator {
  static int[] monthdays;

  static{

    monthdays = new int[12+1]; // 1 indexed month
    Calendar calendar = Calendar.getInstance();
    int year = 2019;
    calendar.set(Calendar.YEAR,year);
    calendar.set(Calendar.DAY_OF_MONTH,1);
    for(int i=Calendar.JANUARY; i <= Calendar.DECEMBER;i++){
      calendar.set(Calendar.MONTH, i);
      monthdays[i+1] = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
  //    System.out.println(i+1 +  " :" + monthdays[i+1]);
    }
  }

  public boolean isValidDay(int day){
    if(day < 1 || day > 31)
      return false;
    return true;
  }

  public boolean isValidMonth(int month){
    if(month < 1 || month > 12)
      return false;
    return true;
  }

  public boolean isValidYear(int year){
    if(year < 1901 || year > 2022)
      return false;
    return true;
  }

  public boolean isLeapYear(int year){
    if(year % 400 == 0 || year % 4 == 0)
      return true;
    return false;
  }

  public boolean isValidDate(int day,int month,int year){
    if(!isValidDay(day) || !isValidMonth(month) || !isValidYear(year))
      return false;
    boolean isLeap = isLeapYear(year);
    int days = monthdays[month];
    if(isLeap == true && month == 2 ){
      if(day <= days + 1)
        return true;
      else
        return false;
    }
    return day <= days;
  }

  public static void main(String[] args){
    DateValidator dateValidator = new DateValidator();
    System.out.println(dateValidator.isValidDate(4,6,2020));
    System.out.println(dateValidator.isValidDate(29,2,2020));
    System.out.println(dateValidator.isValidDate(28,2,2019));
    System.out.println(dateValidator.isValidDate(29,2,2019));
    System.out.println(dateValidator.isValidDate(4,31,2020));
  }
}
