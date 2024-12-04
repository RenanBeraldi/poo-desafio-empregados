package entities;

import java.util.ArrayList;

public class Department {
    private String name;
    private Integer payDay;

    private Address address;

    private ArrayList<Employee> employees =  new ArrayList<>();

    public Department() {
    }

    public Department(String name, Integer payDay, Address address) {
        this.name = name;
        this.payDay = payDay;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPayDay() {
        return payDay;
    }

    public void setPayDay(Integer payDay) {
        this.payDay = payDay;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        this.employees.remove(employee);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Departamento ");
        sb.append(name + "\n");
        sb.append(" = R$ ");
        sb.append(payroll() + "\n");
        sb.append("Pagemento realizado no dia ");
        sb.append(payDay + "\n");
        sb.append("Funcionarios:");
        for (Employee employee : employees) {
            sb.append(employee.getName() + "\n");
        }
        sb.append("Para mais duvidas entrar em contato: ");
        sb.append(address.getEmail());

        return sb.toString();
    }

    /**
     * This method calculates the department's payroll.
     * @return The sum of all employees salaries
     */
    public Double payroll() {
        Double totalPayroll = 0.0;

        for (Employee employee : employees) {
             totalPayroll += employee.getSalary();
        }

        return totalPayroll;
    }
}
