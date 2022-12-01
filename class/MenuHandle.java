import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MenuHandle {
    static Scanner scanner = new Scanner(System.in);

    static int n = -1;
    static int m = -1;
    static Account[] listAccount = new Account[0];
    static Department[] listDepartments = new Department[100];

    static ContractManager listContract = new ContractManager();
    static SalaryManager listSalary = new SalaryManager();
    static DepartmentManager listDepartment = new DepartmentManager();
    static AccountList listAccounts = new AccountList();

    private MenuHandle() {
    }

    // lấy id từ department
    public String getId(String idDep) {
        return idDep;
    }

    public static boolean checkIdEmployee(String id) {
        for (int i = 0; i < MenuHandle.n; i++) {
            if (listAccount[i].getEmployee().getIdEmp().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public static int getInputNumber() {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(getInput());
                return choice;
            } catch (Exception e) {
                MenuContent.choiceWrong();
            }
        }
    }

    private static String getInput() {
        return scanner.nextLine();
    }

    public static String getUsername() {
        String username;
        while (true) {
            System.out.print("==> Enter username: ");
            username = scanner.nextLine();
            Pattern pattern = Pattern.compile("^[a-z]+[0-9]*{8,50}$");
            if (pattern.matcher(username).find())
                break;
            else
                System.err.print("<<<<< Invalid username, input again: ");
        }
        return username;
    }

    public static String hidePassword() {
        Console console = System.console();
        String password = "";
        for (char element : console.readPassword()) {
            password += element;
        }
        return password;
    }

    public static String getPassword() {
        String password;
        while (true) {
            System.out.print("==> Password: ");
            password = scanner.nextLine();
            Pattern pCheck1 = Pattern.compile("^[a-zA-Z]+[0-9]+{4,25}$");
            Pattern pCheck2 = Pattern.compile("^'//d'+[a-zA-Z]+$");
            if (pCheck1.matcher(password).find() || pCheck2.matcher(password).find())
                break;
            else
                System.err.print("<<<<< Invalid password, input again: ");
        }
        return password;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void menu() {
        int option;
        // try {
        // Thread.sleep(1000);
        // } catch (Exception e) {
        // System.out.println("Fail to sleep!");
        // }
        MenuContent.menu();
        do {
            System.out.print("==> Input option : ");
            option = getInputNumber();
            switch (option) {
                case 1 -> option("Account Employee");
                case 2 -> option("Contract");
                case 3 -> option("Salary");
                case 4 -> option("Department");
                case 5 -> {
                    clearScreen();
                    login();
                }
                case 6 -> {
                    MenuContent.noteBye();
                    break;
                }
                default -> {
                    MenuContent.choiceWrong();
                    break;
                }
            }
        } while (option < 1 || option > 6);
    }

    public static void option(String title) {
        int option;
        MenuContent.option(title);
        do {
            System.out.print("     ==> Input option: ");
            option = getInputNumber();
            switch (option) {
                case 1 -> {
                    if (title.equals("Account Employee"))
                        listAccounts.inputList();
                    else if (title.equals("Contract"))
                        listContract.inputList();
                    else if (title.equals("Salary"))
                        listSalary.inputList();
                    else
                        listDepartment.inputList();
                    option(title);
                }
                case 2 -> {
                    if (title.equals("Account Employee"))
                        listAccounts.outputList();
                    else if (title.equals("Contract"))
                        listContract.outputList();
                    else if (title.equals("Salary"))
                        listSalary.outputList();
                    else
                        listDepartment.outputList();
                    option(title);
                }
                case 3 -> {
                    if (title.equals("Account Employee"))
                        listAccounts.add();
                    else if (title.equals("Contract"))
                        listContract.add();
                    else if (title.equals("Salary"))
                        listSalary.add();
                    else
                        listDepartment.add();
                    option(title);
                }
                case 4 -> {
                    if (title.equals("Account Employee"))
                        listAccounts.edit(null);
                    else if (title.equals("Contract"))
                        listContract.edit(null);
                    else if (title.equals("Salary"))
                        listSalary.edit(null);
                    else
                        listDepartment.edit(null);
                    option(title);
                }
                case 5 -> {
                    if (title.equals("Account Employee"))
                        listAccounts.remove(null);
                    else if (title.equals("Contract"))
                        listContract.remove(null);
                    else if (title.equals("Salary"))
                        listSalary.remove(null);
                    else
                        listDepartment.remove(null);
                    option(title);
                }
                case 6 -> {
                    if (title.equals("Account Employee"))
                        listAccounts.find(null);
                    else if (title.equals("Contract"))
                        listContract.find(null);
                    else if (title.equals("Salary"))
                        listSalary.find(null);
                    else
                        listDepartment.find(null);
                    option(title);
                }
                case 7 -> {
                    // Thống kê
                }
                case 8 -> {
                    menu();
                    break;
                }
                case 9 -> {
                    clearScreen();
                    login();
                    break;
                }
                case 10 -> {
                    MenuContent.noteBye();
                    break;
                }
                default -> {
                    MenuContent.choiceWrong();
                    break;
                }
            }
        } while (option < 1 || option > 9);
    }

    // Login
    public static void login() {
        Boolean check = false;
        String username;
        String password;
        System.out.println("--------------------------------------------------------------------");
        System.out.println("|                                Login                             |");
        System.out.println("--------------------------------------------------------------------");
        username = getUsername();
        System.out.print("==> Enter password: ");
        password = hidePassword();
        for (int i = 0; i < n; i++) {
            if (username.equals(listAccount[i].getUsername()) && password.equals(listAccount[i].getPassword())) {
                check = true;
                if (listAccount[i].getEmployee().getPosition().equals("admin")) {
                    iForManager();
                    break;
                } else {
                    if (listAccount[i].getEmployee().getPosition().equals("Chief Of Department")) {
                        iForChiefDepartment(listAccount[i].getEmployee().getIdEmp());
                        break;
                    } else
                        iForEmployee(listAccount[i].getEmployee().getIdEmp());
                    break;
                }
            }
        }
        if (!check) {
            MenuContent.choiceWrong();
            login();
        }
    }

    public static void iForEmployee(String idEmp) {
        int choice;
        MenuContent.menuIForEmployee();
        do {
            choice = getInputNumber();
            switch (choice) {
                case 1 -> {
                    listAccounts.find(idEmp);
                    listSalary.find(idEmp);
                    listContract.find(idEmp);
                    iForEmployee(idEmp);
                }
                case 2 -> {
                    listAccounts.edit(idEmp);
                    iForEmployee(idEmp);
                }
                case 3 -> MenuContent.noteBye();
                default -> {
                    MenuContent.choiceWrong();
                    break;
                }
            }
        } while (choice < 1 || choice > 3);
    }

    public static void iForChiefDepartment(String idEmp) {
        int choice;
        MenuContent.menuIForChief();
        do {
            choice = getInputNumber();
            switch (choice) {
                case 1 -> {
                    listAccounts.find(idEmp);
                    listSalary.find(idEmp);
                    listContract.find(idEmp);
                    iForChiefDepartment(idEmp);
                }
                case 2 -> {
                    listAccounts.edit(idEmp);
                    iForChiefDepartment(idEmp);
                }
                case 3 -> {
                    if (MenuHandle.m < 0) {
                        for (int i = 0; i < MenuHandle.m; i++) {
                            for (int j = 0; j < MenuHandle.listDepartments[i].getMembers(); j++) {
                                if (MenuHandle.listDepartments[i].getIdEmployee()[j].equalsIgnoreCase(idEmp)) {
                                    listDepartment.edit(MenuHandle.listDepartments[i].getDepartmentId());
                                }
                            }
                        }
                    } else {
                        MenuContent.printNoData();
                        iForChiefDepartment(idEmp);
                    }
                }
                case 4 -> {
                    MenuContent.noteBye();
                    break;
                }
                case 5 -> {
                    MenuContent.noteBye();
                    break;
                }
                default -> {
                    MenuContent.choiceWrong();
                }
            }
        } while (choice < 1 || choice > 5);
    }

    public static void iForManager() {
        clearScreen();
        System.out.println("--------------------------------------------------------");
        System.out.println("|                 Welcome back,Manager                 |");
        System.out.println("--------------------------------------------------------");
        menu();
    }

    public static void noteNoHaveId(String id) {
        System.out.printf("%s-20s %-10s", " <<<<< Don't have id for ", id);
    }

    public static String inputId(String id) {
        String inputId;
        System.out.print("     - Enter id : ");
        inputId = scanner.nextLine();
        while (inputId.isEmpty()) {
            System.out.print("\n    Id of employee must not be left blank! Enter again:  ");
            inputId = scanner.nextLine();
            inputId = inputId.toUpperCase();
        }
        while (!inputId.startsWith(id)) {
            System.out.printf("%-25 %-5s", "\n     Employee code starting from ", id);
            System.out.println("\nEnter again: ");
            inputId = scanner.nextLine();
            inputId = inputId.toUpperCase();
        }
        return inputId;
    }

    public static Date getInputDate() {
        Date date = null;
        String strDate = "";
        SimpleDateFormat dateInput = new SimpleDateFormat("dd-MM-yyyy");
        while (date == null) {
            strDate = scanner.nextLine();
            try {
                date = dateInput.parse(strDate);
                // if (!strDate.equals(new SimpleDateFormat("dd-MM-yyyy").format(date))) {
                // date = null;
                // System.out.println("Input Wrong!!!");
                // }
                // System.out.println(date);
            } catch (Exception e) {
                System.out.println("Input Wrong!!!");
            }
        }
        return date;
    }
}

// Đăng nhập với tư cách nhân viên xem thông tin cá nhân,xem ds nhân viên,xem ds
// dự án,xem ds phòng ban