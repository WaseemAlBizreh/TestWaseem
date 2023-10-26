public class LongServingEmployee extends FullTimeEmplyee {
    int extra_leave = 0;
    private int years_in_service = 15;

    public LongServingEmployee(int salary) {
        super(salary, 15);
    }

    public LongServingEmployee() {
        super();
    }

    private int leave = 0;

    @Override
    public int getLeave() {

        return calcLeave();
    }

    @Override
    public int calcLeave() {
        leave = (25 + ((getYears_in_service() - 15) / 2)) + getExtra_leave();
        return leave;
    }

    @Override
    public void setExtra_leave(int extra_leave) {
        if (!isActive()) {

            System.out.println("this empolyee is'nt active please reactive him to access the data");

        } else {
            this.extra_leave += extra_leave;
        }
    }

    @Override
    public int getExtra_leave() {
        return extra_leave;
    }

    @Override
    public void setYears_in_service(int years_in_service) {
        if (!isActive()) {
            System.out.println("this empolyee is'nt active please reactive him to access the data");
        } else {
            while (years_in_service < 15) {
                System.out.println("You have Entered employee below 15 years please re-enter the corect years in service");
                years_in_service = in.nextInt();
            }
            this.years_in_service = years_in_service;
        }
    }
}
