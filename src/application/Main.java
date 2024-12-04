package application;

import entities.Address;
import entities.Department;
import entities.Employee;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        Department department = new Department();

        System.out.print("Nome do departamento: ");
        String nomeDepartamento = scanner.nextLine();
        System.out.print("Dia do pagamento: ");
        Integer diaPagamento = scanner.nextInt();
        System.out.print("Email: ");
        String email = scanner.next();
        System.out.print("Telefone: ");
        String telefone = scanner.next();

        Address address = new Address(email, telefone);

        department.setName(nomeDepartamento);
        department.setPayDay(diaPagamento);
        department.setAddress(address);

        System.out.print("Quantos funcionarios tem o departamento? ");
        Integer quantidadeFuncionarios = scanner.nextInt();

        for (int i = 0; i < quantidadeFuncionarios; i++) {
            System.out.println("Dados do funcionario " + (i + 1) + ": ");
            System.out.print("Nome: ");
            scanner.nextLine();
            String nomeFuncionario = scanner.nextLine();
            System.out.print("Salario: ");
            Double salarioFuncionario = scanner.nextDouble();
            System.out.println();

            Employee employee = new Employee(nomeFuncionario, salarioFuncionario);

            department.addEmployee(employee);
        }

        showReport(department);

        scanner.close();
    }

    private static void showReport (Department department) {
        System.out.println("\n");
        System.out.println("FOLHA DE PAGAMENTO:");
        System.out.print("Departamento: " + department.getName());
        System.out.printf(" = R$ %.2f%n", department.payroll());
        System.out.println("Pagamento realizado no dia " + department.getPayDay());
        System.out.println("Funcionarios: ");
        for (Employee employee : department.getEmployees()) {
            System.out.println(employee.getName());
        }
        System.out.print("Para duvidas favor entrar em contato: ");
        System.out.print(department.getAddress().getEmail());
    }
}
