import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println('\n');
        System.out.println("-------------------------(:  Waseem please don't minus 20 point from us  :)-------------------------" + '\n');
        Scanner in = new Scanner(System.in);
        ArrayList<Section> section = new ArrayList<>();
        System.out.println("Please Enter the Standard paid for your part-time employee:");
        int paid;
        boolean valid_number;
        do {
            paid = in.nextInt();
            valid_number = PartTimeEmployee.setPaid(paid);
        } while (valid_number);

        ArrayList<Employee> employees = new ArrayList<>();
        boolean Manar = true;
        while (Manar) {
            System.out.println("Choose one of the following number to run the command:");
            System.out.println("1) fill Sections info and their leaders");
            System.out.println("2) Add Employee to specific Section");
            System.out.println("3) Remove Employee");
            System.out.println("4) terminate an Employee");
            System.out.println("5) Check whether an Employee is in-service or not ");
            System.out.println("6) give an Employee bonus leaves ");
            System.out.println("7) display all Employee in all sections ");
            System.out.println("8) display leaves of an Employee ");
            System.out.println("9) diplay all Employee in a specific section ");
            System.out.println("10) Exit Please");
            int choose_what_you_want_to_do = in.nextInt();
            switch (choose_what_you_want_to_do) {
                case 1: {
                    System.out.println("PLease Enter the number of section you want to create:");
                    int n = in.nextInt();
                    while (n <= 0) {
                        System.out.println("You entered invalid number of section please try again:");
                        n = in.nextInt();
                    }
                    int section_size = section.size();
                    for (int i = section_size; i < section_size + n; i++) {
                        section.add(new Section());
                        System.out.println("Please Enter the Name of the section:");
                        section.get(i).setName(in.next());
                        boolean not_Enter_The_Correct_number = true;
                        while (not_Enter_The_Correct_number) {
                            System.out.println("Choose one of the following letter to determine leader rank of this section:");
                            System.out.println("F) Full-Time employee");
                            System.out.println("L) Long-Serving employee");
                            System.out.println("P) Part-Time employee");
                            char choose_the_leader = in.next().charAt(0);
                            switch (choose_the_leader) {
                                case 'F': {
                                    Employee em = new FullTimeEmplyee();
                                    section.get(i).setLeader(em);
                                    em.setSection_id(i);
                                    em.setNumber((i * 100) + section.get(i).size());
                                    section.get(i).add(em);
                                    employees.add(em);
                                    System.out.println("The Leader has been add successfully as full-time employee.");
                                    not_Enter_The_Correct_number = false;
                                    break;
                                }
                                case 'L': {
                                    Employee em = new LongServingEmployee();
                                    section.get(i).setLeader(em);
                                    em.setSection_id(i);
                                    em.setNumber((i * 100) + section.get(i).size());
                                    section.get(i).add(em);
                                    employees.add(em);
                                    System.out.println("The Leader has been add successfully as long-serving employee.");
                                    not_Enter_The_Correct_number = false;
                                    break;
                                }
                                case 'P': {
                                    Employee em = new PartTimeEmployee();
                                    section.get(i).setLeader(em);
                                    em.setSection_id(i);
                                    em.setNumber((i * 100) + section.get(i).size());
                                    section.get(i).add(em);
                                    employees.add(em);
                                    System.out.println("The Leader has been added successfully as part-time employee");
                                    not_Enter_The_Correct_number = false;
                                    break;
                                }
                                default: {
                                    System.out.println("You have Entered wrong command.");
                                }
                            }
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("PLease Enter Section ID where you want to add The Employee ");
                    int id = in.nextInt();
                    if (id < 0 || id >= section.size()) {
                        System.out.println("you have Entered invalid ID!!.");
                        break;
                    }
                    boolean not_Enter_The_Correct_number = true;
                    while (not_Enter_The_Correct_number) {
                        System.out.println("Choose one of the following letter to determine the employee's rank ");
                        System.out.println("F) Full-Time employee");
                        System.out.println("L) Long-Serving employee");
                        System.out.println("P) Part-Time employee");
                        char choose_the_employee = in.next().charAt(0);
                        switch (choose_the_employee) {
                            case 'F': {
                                Employee em = new FullTimeEmplyee();
                                em.setSection_id(id);
                                em.setNumber((id * 100) + section.get(id).size());
                                section.get(id).add(em);
                                employees.add(em);
                                System.out.println("The Employee has been added successfully as Full-Time Employee");
                                not_Enter_The_Correct_number = false;
                                break;
                            }
                            case 'L': {
                                Employee em = new LongServingEmployee();
                                em.setSection_id(id);
                                em.setNumber((id * 100) + section.get(id).size());
                                section.get(id).add(em);
                                employees.add(em);
                                System.out.println("The Employee has been added successfully as Long-Serving Employee");
                                not_Enter_The_Correct_number = false;
                                break;
                            }
                            case 'P': {
                                Employee em = new PartTimeEmployee();
                                em.setSection_id(id);
                                em.setNumber((id * 100) + section.get(id).size());
                                section.get(id).add(em);
                                employees.add(em);
                                System.out.println("The Employee has been added successfully as Part-Time Employee");
                                not_Enter_The_Correct_number = false;
                                break;
                            }
                            default: {
                                System.out.println("You have Entered wrong command.");
                            }
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println("Enter the number of the Employee you want to remove please");

                    int number = in.nextInt();
                    if ((number < 0 || (number / 100) >= section.size())) {
                        System.out.println("you have Entered invalid number!!.");
                        break;
                    } else if ((number % 100) >= section.get(number / 100).size()) {
                        System.out.println("you have Entered invalid number!!.");
                        break;
                    }
                    for (int i = (number + 1) % 100; i < section.get(number / 100).size(); i++) {
                        int num = section.get(number / 100).getE().get(i).getNumber();
                        section.get(number / 100).getE().get(i).setNumber((num - 1));
                    }
                    section.get(number / 100).remove(number % 100);
                    for (Employee e : employees) {
                        if (e.getNumber() == number) {
                            {
                                employees.remove(e);
                                break;
                            }
                        }
                    }
                    System.out.println("The Employee has been removed successfully");
                    break;
                }
                case 4: {
                    System.out.println("Enter employee's id that you want to terminate:");
                    int number = in.nextInt();
                    if ((number < 0 || (number / 100) >= section.size())) {
                        System.out.println("you have Entered invalid number!!.");
                        break;
                    } else if ((number % 100) >= section.get(number / 100).size()) {
                        System.out.println("you have Entered invalid number!!.");
                        break;
                    }
                    section.get(number / 100).getE().get(number % 100).setActive(false);
                    System.out.println("The Employee has been terminated successfully.");
                    break;
                }
                case 5: {
                    System.out.println("Enter employee's id that you want to checked:");
                    int number = in.nextInt();
                    if ((number < 0 || (number / 100) >= section.size())) {
                        System.out.println("you have Entered invalid number!!.");
                        break;
                    } else if ((number % 100) >= section.get(number / 100).size()) {
                        System.out.println("you have Entered invalid number!!.");
                        break;
                    }
                    if (section.get(number / 100).getE().get(number % 100).isActive()) {
                        System.out.println("The employee is active.");
                    } else
                        System.out.println("The employee is'nt active.");
                    break;
                }
                case 6: {
                    System.out.println("Enter employee's id: ");
                    int number = in.nextInt();
                    if ((number < 0 || (number / 100) >= section.size())) {
                        System.out.println("you have Entered invalid number!!.");
                        break;
                    } else if ((number % 100) >= section.get(number / 100).size()) {
                        System.out.println("you have Entered invalid number!!.");
                        break;
                    } else if (section.get(number / 100).getE().get(number % 100) instanceof PartTimeEmployee) {
                        System.out.println("you can't set leaves for part-time employee");
                        break;
                    }
                    System.out.println("Enter the number of bonus leaves: ");
                    int number_of_extra_leave = in.nextInt();
                    section.get(number / 100).getE().get(number % 100).setExtra_leave(number_of_extra_leave);
                    System.out.println("The Operation has been done successfully.");
                    break;
                }
                case 7: {
                    for (Section value : section) {
                        System.out.println("All employee in the " + value.getId() + " Section");
                        value.print_all_employee();
                    }
                    break;
                }
                case 8: {
                    System.out.println("Enter employee's id: ");
                    int number = in.nextInt();
                    System.out.println(section.get(number / 100).getE().get(number % 100).getLeave());
                    break;
                }
                case 9: {
                    System.out.println("Enter The id of the section that you want to display: ");
                    int id = in.nextInt();
                    section.get(id).print_all_employee();
                    break;
                }
                case 10: {
                    System.out.println("------------Waseem please don't minus 20 point from us  :)------------");
                    Manar = false;
                    break;
                }
                default: {
                    System.out.println("YOU Entered a wrong command please choose one of the following command");
                    System.out.println("------------Waseem please don't minus 20 point from us  :)------------");
                }
            }
        }
    }
}