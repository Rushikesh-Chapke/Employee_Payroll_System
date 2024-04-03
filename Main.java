import java.util.ArrayList;

abstract class Employee {
    private String name;
    private int id;
    public Employee(String name, int id){
        this.id = id;
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public abstract double CalculateSalary();
    @Override
    public String toString(){
        return "Employee [Name= "+name+", id= "+id+", Salary= "+CalculateSalary()+"]";
    }
}
class FullTimeEmployee extends Employee{
    private double monthlySalary;
    public FullTimeEmployee(String name, int id, double monthlySalary){
        super(name, id);
        this.monthlySalary = monthlySalary;
    }
    @Override
    public double CalculateSalary(){
        return monthlySalary;
    }
}
class partTimeEmployee extends  Employee{
    private int hoursWorked;
    private double hourlyRate;
    public partTimeEmployee(String name, int id, int hoursWorked, double hourlyRate){
        super(name, id);
        this.hoursWorked= hoursWorked;
        this.hourlyRate= hourlyRate;
    }
    @Override
    public double CalculateSalary(){
        return hoursWorked * hourlyRate;
    }
}
class PayrollSystem{
    private ArrayList<Employee> employeeList;
    public PayrollSystem(){
        employeeList = new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for(Employee employee : employeeList){
            if(employee.getId()==id){
                employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove != null){
            employeeList.remove(employeeToRemove);
        }
    }
    public void displayEmployees(){
        for(Employee employee : employeeList){
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("Rushikesh",101,100000000.00);
        partTimeEmployee emp2 = new partTimeEmployee("Ranjeet",103,30,140);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        System.out.println("Initial employee details");
        payrollSystem.displayEmployees();
        System.out.println("After removing an employee");
        payrollSystem.removeEmployee(103);
        System.out.println("Remaining employees details...");
        payrollSystem.displayEmployees();
    }
}