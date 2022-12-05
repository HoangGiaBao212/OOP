
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
        // start();
        // MenuHandle.clearScreen();
        SalaryManager salaryManager = new SalaryManager();
        // salaryManager.inputList();
<<<<<<< HEAD
        salaryManager.outputList();
        salaryManager.edit(null);
=======
>>>>>>> 4b71bb29c07916a64dc8e3f3b7d952f825f6b217
        salaryManager.outputList();
        // DepartmentManager departmentManager = new DepartmentManager();
        // departmentManager.inputList();
        // AccountList accountList = new AccountList();
        // accountList.inputList();
        end();
    }
}
