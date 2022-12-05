
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
        Contract contract = new Contract();
        contract.input();
        contract.output();
        // MenuHandle.clearScreen();
        // SalaryManager salaryManager = new SalaryManager();
        // salaryManager.inputList();
        // salaryManager.outputList();
        // salaryManager.edit(null);
        // salaryManager.outputList();
<<<<<<< HEAD

=======
>>>>>>> 99781064f4e36cbaf651bd1dee01c15b0a13fe3a
        end();
    }
}
