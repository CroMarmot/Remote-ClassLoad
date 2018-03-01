import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

public class TestClass {

    public static void main(String[] args) {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        System.out.println(memoryMXBean.getHeapMemoryUsage());
    }
}
