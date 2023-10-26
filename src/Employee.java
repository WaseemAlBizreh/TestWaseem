import java.util.Date;
import java.util.Scanner;

public abstract class Employee {
    Scanner in = new Scanner(System.in);
    private String name;
    private int number = 0;
    private String address;
    private Date date;
    private int section_id;
    private boolean active = true;


    public Employee(String name, String address, Date date) {
        this.name = name;
        this.address = address;
        this.date = date;
    }

    public Employee() {
        System.out.println("Enter the name of the Employee:");
        setName(in.next());
        System.out.println("Enter the Address of the Employee:");
        setAddress(in.next());
        System.out.println("Enter the employee's year of birth:");
        int year = in.nextInt();
        while (year > 2023 || year < 1900) {
            System.out.println("You have entered invalid year pleas enter again:");
            year = in.nextInt();
        }
        System.out.println("Enter the employee's month of birth:");
        int month = in.nextInt();
        while (month > 12 || month < 1) {
            System.out.println("You have entered invalid month pleas enter again:");
            month = in.nextInt();
        }
        System.out.println("Enter the employee's day of birth:");
        int day = in.nextInt();
        while (day > 31 || day < 1) {
            System.out.println("You have entered invalid day pleas enter again:");
            day = in.nextInt();
        }
        setDate(year, month, day);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setSection_id(int section_id) {
        if (!isActive()) {
            System.out.println("this empolyee is'nt active please reactive him to access the data");

        } else {
            this.section_id = section_id;
        }

    }

    public void setName(String name) {
        if (!isActive()) {
            System.out.println("this empolyee is'nt active please reactive him to access the data");

        } else {
            this.name = name;
        }
    }

    public void setAddress(String address) {
        if (!isActive()) {
            System.out.println("this empolyee is'nt active please reactive him to access the data");

        } else {
            this.address = address;
        }
    }

    public void setDate(int year, int month, int day) {

        if (!isActive()) {
            System.out.println("this empolyee is'nt active please reactive him to access the data");
        } else {
            date = new Date(year - 1900, month, day);
        }
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if (!isActive()) {
            System.out.println("this empolyee is'nt active please reactive him to access the data");
        } else {
            this.number = number;
        }
    }

    public String getAddress() {
        return address;
    }

    public Date getDate() {
        return date;
    }

    public abstract void report();

    public abstract void setExtra_leave(int extraLeave);

    public abstract int calcLeave();

    public abstract int getLeave();
}