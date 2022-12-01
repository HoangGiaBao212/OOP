import java.text.SimpleDateFormat;
import java.util.*;

public class ContractManager implements RoleOfManager {
    // new list ContractManager
    Scanner scanner = new Scanner(System.in);

    public ContractManager() {
    }

    @Override
    public void inputList() {
        System.out.println("-------------------------------------------------");
        System.out.println("|              ADD LIST OF CONTRACT             |");
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < MenuHandle.n; i++) {
            System.out.println(MenuHandle.n);
            System.out.println("Enter information contract of employee with id: "
                    + MenuHandle.listAccount[i].getEmployee().getIdEmp());
            Contract contract = new Contract();
            contract.input();
            MenuHandle.listAccount[i].getEmployee().setContract(contract);
        }

        System.out.println("---------------------------------------");
        System.out.println("|          Add list successful!       |");
        System.out.println("---------------------------------------");
    }

    @Override
    public void outputList() {
        MenuHandle.clearScreen();
        System.out.println("Output the List of Contract\n");
        // System.out.println(Handle.n);
        if (MenuHandle.n == 0) {
            MenuContent.printNoData();
        } else {
            System.out.println(
                    "------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("|    %-15s|   %-20s|   %-10s|   %-5s|   %-15s|    %-25s|   %-15s|    %-15s|",
                    "Contract ID", "Name", "Gender", "Age", "Phone number", "Email", "Time start", "Time end");
            System.out.println();
            System.out.println(
                    "------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < MenuHandle.n; i++) {
                System.out.printf("|    %-15s|   %-20s|   %-10s|   %-5s|   %-15s|    %-25s|   %-15s|    %-15s|\n",
                        MenuHandle.listAccount[i].getEmployee().getContract().getContractID(),
                        MenuHandle.listAccount[i].getEmployee().getName(),
                        MenuHandle.listAccount[i].getEmployee().getGender(),
                        MenuHandle.listAccount[i].getEmployee().getAge(),
                        MenuHandle.listAccount[i].getEmployee().getPhone(),
                        MenuHandle.listAccount[i].getEmployee().getEmail(),
                        new SimpleDateFormat("dd/MM/yyyy")
                                .format(MenuHandle.listAccount[i].getEmployee().getContract().getTimeStart()),
                        new SimpleDateFormat("dd/MM/yyyy")
                                .format(MenuHandle.listAccount[i].getEmployee().getContract().getTimeEnd()));
                System.out.println(
                        "------------------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        }
    }

    @Override
    public void add() {
        System.out.println("---------------------------------------");
        System.out.println("|             ADD CONTRACT            |");
        System.out.println("---------------------------------------\n");
        System.out.print("Enter Employee ID to add: ");
        String idEmpAdd;
        idEmpAdd = scanner.nextLine();
        if (MenuHandle.checkIdEmployee(idEmpAdd)) {
            for (int i = 0; i < MenuHandle.n; i++) {
                if (MenuHandle.listAccount[i].getEmployee().getIdEmp().equals(idEmpAdd)) {
                    if (MenuHandle.listAccount[i].getEmployee().getContract() == null) {
                        Contract contract = new Contract();
                        contract.input();
                        MenuHandle.listAccount[i].getEmployee().setContract(contract);
                    }
                }
            }
        } else {
            System.out.println("Employee is exits or don't have employee with id: " + idEmpAdd);
        }

        System.out.println("---------------------------------------------------------");
        System.out.println("|               Add Contract Successful!                |");
        System.out.println("---------------------------------------------------------");
    }

    @Override
    public void edit(String idEdit) {
        if (idEdit == null) {
            System.out.println("----------------------------------------------------");
            System.out.println("|            EDIT INFORMATION IN CONTRACT          |");
            System.out.println("----------------------------------------------------");
            System.out.print("Enter an contract ID to edit: ");
            idEdit = scanner.nextLine();
        }
        int key, option;
        int count = 0;
        for (int i = 0; i < MenuHandle.n; i++) {
            if (MenuHandle.listAccount[i].getEmployee().getContract().getContractID().equalsIgnoreCase(idEdit)) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Contract don't exist!");
        } else {
            MenuContent.optionEdit();
            option = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < MenuHandle.n; i++) {
                switch (option) {
                    case 1:
                        if (MenuHandle.listAccount[i].getEmployee().getContract().getContractID()
                                .equalsIgnoreCase(idEdit)) {
                            System.out.println("\n ----------------------------------------------");
                            System.out.println(" | 1.Change time start                        |");
                            System.out.println(" | 2.Change time end                          |");
                            System.out.println(" ----------------------------------------------");
                            System.out.print("==> Input option:");
                            key = Integer.parseInt(scanner.nextLine());
                            System.out.println();
                            switch (key) {
                                case 1:
                                    MenuHandle.listAccount[i].getEmployee().getContract().setTimeStart(null);
                                    break;
                                case 2:
                                    MenuHandle.listAccount[i].getEmployee().getContract().setTimeEnd(null);
                                    break;
                                default:
                                    MenuContent.noteBye();
                                    break;
                            }
                        }
                        break;
                    case 2:
                        if (MenuHandle.listAccount[i].getEmployee().getContract().getContractID()
                                .equalsIgnoreCase(idEdit)) {
                            MenuHandle.listAccount[i].getEmployee().getContract().input();
                        }
                        break;
                    default:
                        MenuContent.choiceWrong();
                        break;
                }
                // MenuContent.noteChangeSuccess();
            }
        }
    }

    @Override
    public void remove(String idRemove) {
        System.out.println("-----------------------------------------------");
        System.out.println("|               REMOVE CONTRACT               |");
        System.out.println("-----------------------------------------------");
        if (idRemove == null) {
            System.out.print("Enter id of contract to remove(Ex:C001): ");
            idRemove = scanner.nextLine();
        }
        boolean check = false;
        for (int i = 0; i < MenuHandle.n; i++) {
            if (MenuHandle.listAccount[i].getEmployee().getContract().getContractID().equalsIgnoreCase(idRemove)) {
                for (int j = i; j < MenuHandle.n - 1; j++) {
                    MenuHandle.listAccount[j] = MenuHandle.listAccount[j + 1];

                }
                MenuHandle.listAccount[MenuHandle.n - 1] = null;
                MenuHandle.n--;
                check = true;
                break;
            }
        }
        if (!check) {
            MenuContent.noteFailure("Remove");
        }
        MenuContent.noteSuccess("Remove");
    }

    @Override
    public void find(String idSearch) {
        Boolean check = false;
        if (idSearch == null) {
            System.out.print("Enter id of employee to search(Ex:E001): ");
            idSearch = scanner.nextLine();
        }

        for (int i = 0; i < MenuHandle.n; i++) {
            if (MenuHandle.listAccount[i].getEmployee().getContract() == null) {
                continue;
            }
            if (idSearch.equals(MenuHandle.listAccount[i].getEmployee().getIdEmp())) {
                System.out.println(
                        "     -------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf(
                        "    %-15s|   %-15s|   %-15s|   %-15s|   %-15s|    %-15s|   %-15s|    %-15s|",
                        "ID Contract", "Name", "Gender", "Age", "Phone number", "Email",
                        "Time start",
                        "Time end");
                System.out.println();
                System.out.println(
                        "     -------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("    %-15s|   %-15s|   %-15s|   %-15s|   %-15s|    %-15s|   %-15s|    %-15s|",
                        MenuHandle.listAccount[i].getEmployee().getContract().getContractID(),
                        MenuHandle.listAccount[i].getEmployee().getName(),
                        MenuHandle.listAccount[i].getEmployee().getGender(),
                        MenuHandle.listAccount[i].getEmployee().getAge(),
                        MenuHandle.listAccount[i].getEmployee().getPhone(),
                        MenuHandle.listAccount[i].getEmployee().getEmail(),
                        new SimpleDateFormat("dd/MM/yyyy")
                                .format(MenuHandle.listAccount[i].getEmployee().getContract().getTimeStart()),
                        new SimpleDateFormat("dd/MM/yyyy")
                                .format(MenuHandle.listAccount[i].getEmployee().getContract().getTimeEnd()));
                System.out.println(
                        "---------------------------------------------------------------------------------------------------------------------------------");
                check = true;
                break;
            }
        }
        if (!check)
            System.out.println("------------ Don't have data for contract ---------------");
    }

    @Override
    public void statistics() {
        MenuContent.quantityCount("Contract", MenuHandle.n);
    }

    public static void statistical() {
    }
}
