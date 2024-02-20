import ipUtilities.IPValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IPValidatorTest {



    @Test
    public void testValidIpAddress() {
        String ipAddress = "1.1.1.1";

        Assertions.assertTrue(IPValidator.isValid(ipAddress));
    }
    @Test
    public void testValidIpAddress2() {
        String ipAddress = "10.0.0.1";

        Assertions.assertTrue(IPValidator.isValid(ipAddress));
    }


    @Test
    public void testInvalidLessThan4Bytes() {
        String ipAddress = "10.0.1";
        Assertions.assertFalse(IPValidator.isValid(ipAddress));
    }

    @Test
    public void testInvalidMoreThan4Bytes() {
        String ipAddress = "192.168.1.1.1";
        Assertions.assertFalse(IPValidator.isValid(ipAddress));
    }

    @Test
    @DisplayName("Invalid IPV4 irrepresentative by one Byte")
    public void testInvalid() {
        String ipAddress = "192.168.256.1";
        Assertions.assertFalse(IPValidator.isValid(ipAddress));
    }

    @Test
    @DisplayName("Invalid IPV4 contains negative number")
    public void testInvalidNegative() {
        String ipAddress = "192.168.1.-1";
        Assertions.assertFalse(IPValidator.isValid(ipAddress));
    }

    @Test
    @DisplayName("Invalid IPV4 ends with 0")
    public void testInvalidZero() {
        String ipAddress = "0.0.0.0";
        Assertions.assertFalse(IPValidator.isValid(ipAddress));
    }
    @Test
    @DisplayName("Invalid IPV4 ends with 0")
    public void testInvalidZeroV1() {
        String ipAddress = "1.2.0.0";
        Assertions.assertFalse(IPValidator.isValid(ipAddress));
    }

    @Test()
    @DisplayName("Invalid IPV4 ends with 255")
    public void testInvalid255() {
        String ipAddress = "255.255.255.255";
        Assertions.assertFalse(IPValidator.isValid(ipAddress));
    }
    @Test()
    @DisplayName("Invalid IPV4 ends with 255")
    public void testInvalid255_v2() {
        String ipAddress = "10.16.25.255";
        Assertions.assertFalse(IPValidator.isValid(ipAddress));
    }

    @Test()
    @DisplayName("Invalid IPV4")
    public void testInvalidString() {
        String ipAddress = "invalid.ip.address.test";
        Assertions.assertFalse(IPValidator.isValid(ipAddress));
    }



}
