public class FullTimeEmplyee extends Employee {
    private int salary;
    private int years_in_service = 0;
    private int extra_leave = 0;
    private int leave = 0;

    public FullTimeEmplyee(int salary, int years_in_service) {
        this.salary = salary;
        this.years_in_service = years_in_service;
    }

    public FullTimeEmplyee(int years_in_service) {
        super();
        this.years_in_service = years_in_service;

    }

    public FullTimeEmplyee() {
        super();
        System.out.println("Enter the Salary of the employees:");
        setSalary(in.nextInt());
        System.out.println("Enter how many Year in service");
        setYears_in_service(in.nextInt());
        this.calcLeave();
        this.leave = this.getLeave();
    }

    @Override
    public int getLeave() {

        return calcLeave();
    }

    public int getSalary() {
        return salary;
    }

    public int getYears_in_service() {
        return years_in_service;
    }

    public void setSalary(int salary) {
        if (!isActive()) {
            System.out.println("this empolyee is'nt active please reactive him to access the data");
        } else {
            while (salary < 0) {
                System.out.println("You have Entered Negative salary");
                salary = in.nextInt();
            }
            this.salary = salary;
        }
    }

    public void setYears_in_service(int years_in_service) {
        if (!isActive()) {
            System.out.println("this empolyee is'nt active please reactive him to access the data");
        } else {
            while (years_in_service >= 15) // because it is fulltime employee we want him to be unber 15
            {
                System.out.println("You have Entered employee above 14 years please re-enter the corect years in service");
                years_in_service = in.nextInt();
            }
            this.years_in_service = years_in_service;
        }
    }

    public int getExtra_leave() {
        return extra_leave;
    }

    @Override
    public void setExtra_leave(int extra_leave) {
        if (!isActive()) {
            System.out.println("this empolyee is'nt active please reactive him to access the data");

        } else {
            this.extra_leave = extra_leave;
        }
    }

    public boolean apdateYear() {
        if (!isActive()) {

            System.out.println("this empolyee is'nt active please reactive him to access the data");
            return false;

        } else {
            years_in_service++;
            if (years_in_service >= 15)
                return true;
            else
                return false;
        }
    }

    @Override
    public int calcLeave() {
        if (years_in_service <= 10) {
            this.leave = 15 + years_in_service + extra_leave;
            return this.leave;
        } else {
            this.leave = 25 + extra_leave;
            return this.leave;
        }
    }

    @Override
    public void report() {
        if (isActive())
            System.out.println("The Employee is active");
        else
            System.out.println("The Employee is'nt active");
        System.out.println("The name of Employee is " + getName());
        System.out.println(getName() + " ID is " + getNumber());
        System.out.println(getName() + " Address is " + getAddress());
        System.out.println(getName() + " birth date is " + getDate());
        System.out.println(getName() + " leaves is  " + calcLeave());
    }


}
