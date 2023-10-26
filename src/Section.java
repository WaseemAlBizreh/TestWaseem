import javax.xml.namespace.QName;
import java.io.*;
import java.util.*;
public class Section {
    private static int  x=0;
    private int id;
    private String name;
    private Employee leader;
    private ArrayList<Employee> e = new ArrayList<Employee>(100); //0-->99
    public Section( String name, Employee leader ) {
        this.name = name;
        this.leader = leader;
        id=x;
        x++;
    }

    public Section() {
        id=x;
        x++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getLeader() {
        return leader;
    }

    public void setLeader(Employee leader) {
        this.leader = leader;
    }

    public ArrayList<Employee> getE() {
        return e;
    }
    public void add(Employee em)
    {
        e.add(em);
    }
    public void remove(int number)
    {
        e.remove(number);
    }
    public int size()
    {
        return e.size();
    }
    public void print_all_employee()
    {
            System.out.println("Number of employee in this section is "+size());
            for (int j = 0; j < size(); j++) {
                getE().get(j).report();
            }
    }
}
