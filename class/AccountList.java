import java.util.Arrays;
import java.util.Scanner;

public class AccountList implements RoleOfManager {
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void inputList() {
        // Input new list account
        int option;
        for (int i = 0; i < Handle.m; i++) {
            Account account = new Account();
            System.out.println("Input info Chief");
            account.input();
            account.setEmployee(new ChiefDepartment(Handle.listDepartments[i].getIdChief(), "Chief Of Department"));
            Handle.listAccount = Arrays.copyOf(Handle.listAccount, Handle.n + 1);
            Handle.listAccount[Handle.n++] = account;
            for (int j = 0; j < Handle.listDepartments[i].getMembers(); j++) {
                MenuContent.menuOptionTypeEmployee();
                option = scanner.nextInt();
                Handle.listDepartments[i].getIdEmployee()[j] = new String();
                String idEmp = Handle.listDepartments[i].getIdEmployee()[j];
                do {
                    switch (option) {
                        case 1:
                            Account account1 = new Account();
                            account1.input();
                            account1.setEmployee(
                                    new OfficialEmployee(idEmp, "Official Employee"));
                            Handle.listAccount = Arrays.copyOf(Handle.listAccount, Handle.n + 1);
                            Handle.listAccount[Handle.n++] = account1;
                            break;
                        case 2:
                            Account account2 = new Account();
                            account2.input();
                            account2.setEmployee(
                                    new InternEmployee(idEmp, "Intern Employee"));
                            Handle.listAccount = Arrays.copyOf(Handle.listAccount, Handle.n + 1);
                            Handle.listAccount[Handle.n++] = account2;
                            break;
                        default:
                            System.out.println("choice does not exist!");
                            System.out.println("Option from 1 to 2, please re-enter: ");
                            break;
                    }
                } while (option < 1 || option > 2);
            }
        }
    }

    @Override
    public void outputList() {
        // Output new list account
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("|     %-15s|     %-15s|  %-10s|  %-20s|  %-20s|  %-10s|  %-10s|  %-30s|  %-20s|  %-20s|",
                "Username",
                "Password", "ID",
                "Position", "Name", "Age", "Gender", "Email", "Address", "Phone");
        System.out.println(
                "\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < Handle.n; i++) {
            Handle.listAccount[i].output();
        }

    }

    @Override
    public void add() {
        int option;
        String idDep;
        String idEmpAdd;
        System.out.print(" ==> Enter id of department to add employee > ");
        idDep = Handle.inputId("D");
        System.out.print("Enter id employee to add > ");
        idEmpAdd = Handle.inputId("E");
        while (Handle.checkIdEmployee(idEmpAdd)) {
            System.out.print(" <<<<< Id is exist!!!, input again > ");
            idEmpAdd = Handle.inputId(idEmpAdd);
        }
        for (int j = 0; j < Handle.m; j++) {
            int temp = Handle.listDepartments[j].getMembers();
            if (Handle.listDepartments[j].getDepartmentId().equalsIgnoreCase(idDep)) {
                MenuContent.menuOptionTypeEmployee();
                option = Handle.getInputNumber();
                if (temp > 10) {
                    System.out.println("<<<<Too much");
                    break;
                }
                do {
                    switch (option) {
                        case 1:
                            Account account1 = new Account();
                            account1.input();
                            account1.setEmployee(
                                    new OfficialEmployee(idEmpAdd, "Official Employee"));
                            Handle.listAccount = Arrays.copyOf(Handle.listAccount, Handle.n + 1);
                            Handle.listAccount[Handle.n++] = account1;
                            Handle.listDepartments[j].setMembers(temp++);
                            break;
                        case 2:
                            Account account2 = new Account();
                            account2.input();
                            account2.setEmployee(
                                    new InternEmployee(idEmpAdd, "Intern Employee"));
                            Handle.listAccount = Arrays.copyOf(Handle.listAccount, Handle.n + 1);
                            Handle.listAccount[Handle.n++] = account2;
                            Handle.listDepartments[j].setMembers(temp++);
                        default:
                            System.out.println("choice does not exist!");
                            System.out.println("Option from 1 to ,2 please re-enter: ");
                            break;
                    }
                } while (option < 1 || option > 2);
            }
        }
    }

    @Override
    public void remove(String idRemove) {
        // remove account
        System.out.println("-------------------------------------------------");
        System.out.println("|              REMOVE ACCOUNT                   |");
        System.out.println("-------------------------------------------------");
        if (idRemove == null) {
            System.out.println("Enter id of employee to remove(Ex:E001): ");
            idRemove = Handle.inputId("E");
        }
        for (int i = 0; i < Handle.n; i++) {
            if (Handle.listAccount[i].getEmployee().getIdEmp().equalsIgnoreCase(idRemove)) {
                for (int j = i; j < Handle.n - 1; j++) {
                    Handle.listAccount[j] = Handle.listAccount[j + 1];
                }
                Handle.listAccount = Arrays.copyOf(Handle.listAccount, Handle.n - 1);
                Handle.n--;
                break;
            }
        }
        if (!Handle.checkIdEmployee(idRemove)) {
            MenuContent.noteFailure("Remove");
        } else
            MenuContent.noteSuccess("Remove");
    }

    @Override
    public void edit(String idEdit) {
        // edit username or password
        int key, temp;
        if (idEdit == null) {
            System.out.println("----------------------------------------------------");
            System.out.println("|           EDIT INFORMATION IN EMPLOYEE           |");
            System.out.println("----------------------------------------------------");
            System.out.print("Enter an employee ID to edit: ");
            idEdit = scanner.nextLine();
        }
        int count = 0;
        for (int i = 0; i < Handle.n; i++) {
            if (Handle.listAccount[i].getEmployee().getIdEmp().equalsIgnoreCase(idEdit)) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Employee don't exist!");
        } else {
            MenuContent.optionEdit();
            temp = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < Handle.n; i++) {
                switch (temp) {
                    case 1:
                        if (idEdit.equals(Handle.listAccount[i].getEmployee().getIdEmp())) {
                            System.out.println();
                            System.out.println("----------------------------------------------");
                            System.out.println("| 1.Change Position                          |");
                            System.out.println("| 2.Change Name                              |");
                            System.out.println("| 3.Change Age                               |");
                            System.out.println("| 4.Change Gender                            |");
                            System.out.println("| 5.Change Email                             |");
                            System.out.println("| 6.Change Address                           |");
                            System.out.println("| 7.Change Phone Number                      |");
                            System.out.println("| 8.Exit to menu                             |");
                            System.out.println("----------------------------------------------");
                            System.out.print("==> Input option:");
                            key = Integer.parseInt(scanner.nextLine());
                            System.out.println();
                            switch (key) {
                                case 1:
                                    MenuContent.menuOptionTypeEmployee();
                                    key = Integer.parseInt(scanner.nextLine());
                                    switch (key) {
                                        case 1:
                                            ((ChiefDepartment) Handle.listAccount[i].getEmployee())
                                                    .setPosition("Chief Department");
                                            break;
                                        case 2:
                                            ((OfficialEmployee) Handle.listAccount[i].getEmployee())
                                                    .setPosition("Official Employee");
                                            break;
                                        case 3:
                                            ((InternEmployee) Handle.listAccount[i].getEmployee())
                                                    .setPosition("Intern Employee");
                                            break;
                                        default:
                                            MenuContent.choiceWrong();
                                            break;
                                    }
                                    break;
                                case 2:
                                    Handle.listAccount[i].getEmployee().setName(null);
                                    break;
                                case 3:
                                    Handle.listAccount[i].getEmployee().setAge(0);
                                    break;
                                case 4:
                                    Handle.listAccount[i].getEmployee().setGender(null);
                                    break;
                                case 5:
                                    Handle.listAccount[i].getEmployee().setEmail(null);
                                    break;
                                case 6:
                                    Handle.listAccount[i].getEmployee().setAddress(null);
                                    break;
                                case 7:
                                    Handle.listAccount[i].getEmployee().setPhone(null);
                                    break;
                                case 8:
                                    MenuContent.option("Employee");
                                    break;
                                default:
                                    MenuContent.choiceWrong();
                                    break;
                            }
                        }
                        break;
                    case 2:
                        if (Handle.listAccount[i].getEmployee().getIdEmp().equalsIgnoreCase(idEdit))
                            Handle.listAccount[i].getEmployee().input();
                        break;
                    default:
                        MenuContent.choiceWrong();
                        break;
                }
            }
            MenuContent.noteChangeSuccess();
        }

    }

    @Override
    public void find(String idSearch) {
        // find information of the account
        if (idSearch == null) {
            System.out.println(" ==> Enter id of employee to search: ");
            idSearch = scanner.nextLine();
        }
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("|     %-15s|     %-15s|  %-10s|  %-20s|  %-20s|  %-10s|  %-10s|  %-30s|  %-20s|  %-20s|",
                "Username",
                "Password", "ID",
                "Position", "Name", "Age", "Gender", "Email", "Address", "Phone");
        System.out.println(
                "\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < Handle.n; i++) {
            if (idSearch.equalsIgnoreCase(Handle.listAccount[i].getEmployee().getIdEmp())) {
                Handle.listAccount[i].output();
            }
        }
    }

    @Override
    public void statistics() {
        MenuContent.quantityCount("Account", Handle.n);
    }
}
