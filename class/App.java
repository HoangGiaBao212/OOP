// import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Handler;

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
        // init();
        // start();
        MenuHandle.clearScreen();
        SalaryManager salaryManager = new SalaryManager();
        salaryManager.inputList();
        salaryManager.outputList();
        // end();
        Long a = (long) 10000;
        Long b = (long) 12455555;
        Long c = a * b;
        System.out.println(c);

    }
}
