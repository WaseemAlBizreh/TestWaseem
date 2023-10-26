import java.util.Date;

public class PartTimeEmployee extends Employee{
    private int hour;
    private static int paid=0;

    public PartTimeEmployee(String name, String address, Date date, int hour) {
        super(name, address, date);
        this.hour = hour;
    }

    public PartTimeEmployee() {
        super();
        System.out.println("Enter the number of hours please:");
        setHour(in.nextInt());

    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        if(!isActive())
        {

            System.out.println("this empolyee is'nt active please reactive him to access the data");

        }
        else {
            while(hour<0)
            {
                System.out.println("You have entered invalid Hours pleas enter again:");
                hour=in.nextInt();
            }
            this.hour = hour;
        }
    }

    public static boolean setPaid(int paid) {
            if(paid<0) {
                System.out.println("you have entered a negative number");
                return true;
            }
            else {
                PartTimeEmployee.paid = paid;
                return false;
            }
    }

    public static int getPaid() {
        return paid;
    }

    public int calcpay()
    {
        return(PartTimeEmployee.paid*hour);
    }

    @Override
    public void report() {
        if(isActive())
            System.out.println("The Employee is active");
        else
            System.out.println("The Employee is'nt active");
        System.out.println("The name of Employee is "+getName());
        System.out.println(getName()+" ID is "+ getNumber());
        System.out.println(getName()+" Address is "+getAddress());
        System.out.println(getName()+" birth date is "+getDate());
        System.out.println(getName() +" total hours is  "+hour);
        System.out.println((getName()+" wages is "+calcpay()));
    }

    @Override
    public void setExtra_leave(int extraLeave) {
        System.out.println("this is a part-time employee");
    }

    @Override
    public int calcLeave() {
        return 0;
    }

    @Override
    public int getLeave() {
        System.out.println("this is a part-time employee");
        return 0;
    }
}
