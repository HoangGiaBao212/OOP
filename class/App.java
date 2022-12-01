import java.util.Arrays;
import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);

    public static void init() {
        FileUtil.getData();
    }

    public static void start() {
        Handle.clearScreen();
        Handle.login();
    }

    public static void end() {
        FileUtil.setData();
    }

    public static void main(String[] args) {
        init();
        // start();
        // String[] chuoi = new String[100];
        // chuoi = Arrays.copyOf(chuoi, 0);
        // chuoi[0] = new String();
        // String str = scanner.nextLine();
        // chuoi[0] = str;
        // System.out.println(chuoi[0]);
        DepartmentManager departmentManager = new DepartmentManager();
        // departmentManager.inputList();
        departmentManager.outputList();
        end();
        // System.out.println(5);
    }
}
