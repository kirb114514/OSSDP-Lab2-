import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

/**
 * 测试类设计原则：
 * 1. 使用等价类划分原则：将输入字符串划分为有效类与无效类（不同长度、不同数字分布）
 * 2. 使用边界值分析法：测试最短、最长、特殊格式的字符串
 * 3. 每个测试方法对应一个特定测试目的
 * 4. 使用 JUnit 5 框架进行自动化测试
 */
public class SolutionTest {

    /**
     * 测试目的：
     * 验证一般情况下（典型有效输入）的 IP 复原功能是否正确。
     * 测试用例："25525511135"
     * 预期输出：["255.255.11.135", "255.255.111.35"]
     */
    @Test
    public void testTypicalValidInput() {
        Solution s = new Solution();
        List<String> result = s.restoreIpAddresses("25525511135");
        List<String> expected = Arrays.asList("255.255.11.135", "255.255.111.35");
        assertTrue(result.containsAll(expected) && expected.containsAll(result));
    }

    /**
     * 测试目的：
     * 验证全 0 输入的边界情况。
     * 测试用例："0000"
     * 预期输出：["0.0.0.0"]
     */
    @Test
    public void testAllZeros() {
        Solution s = new Solution();
        List<String> result = s.restoreIpAddresses("0000");
        List<String> expected = Collections.singletonList("0.0.0.0");
        assertEquals(expected, result);
    }

    /**
     * 测试目的：
     * 验证输入长度为 6 时的多种划分情况。
     * 测试用例："101023"
     * 预期输出包括：["1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3"]
     */
    @Test
    public void testMultipleValidPartitions() {
        Solution s = new Solution();
        List<String> result = s.restoreIpAddresses("101023");
        List<String> expected = Arrays.asList(
                "1.0.10.23", "1.0.102.3", "10.1.0.23",
                "10.10.2.3", "101.0.2.3"
        );
        assertTrue(result.containsAll(expected) && expected.containsAll(result));
    }

    /**
     * 测试目的：
     * 验证输入过短的无效情况。
     * 测试用例："12"
     * 预期输出：空列表 []
     */
    @Test
    public void testTooShortInput() {
        Solution s = new Solution();
        List<String> result = s.restoreIpAddresses("12");
        assertTrue(result.isEmpty());
    }

    /**
     * 测试目的：
     * 验证输入过长的无效情况。
     * 测试用例："1234567890123"（长度过大）
     * 预期输出：空列表 []
     */
    @Test
    public void testTooLongInput() {
        Solution s = new Solution();
        List<String> result = s.restoreIpAddresses("1234567890123");
        assertTrue(result.isEmpty());
    }
}
