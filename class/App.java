
import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);

    public static void init() {
        FileUtil.getData();
    }

    public static void start() {
        MenuHandle.clearScreen();
        MenuHandle.login();
    }

    public static void end() {
        FileUtil.setData();
    }

    public static void main(String[] args) {
        init();
        start();
        // MenuHandle.clearScreen();
        // SalaryManager salaryManager = new SalaryManager();
        // salaryManager.inputList();
        // salaryManager.outputList();
        // salaryManager.edit(null);
        // salaryManager.outputList();
        // DepartmentManager departmentManager = new DepartmentManager();
        // departmentManager.inputList();
        // AccountList accountList = new AccountList();
        // accountList.inputList();
        end();
    }
}
