package ipUtilities;

public class IPValidator {

    public static boolean isValid(String ipAddress){
        //gets a string as a parameter and checks if it is a valid IPV4 address
        String [] byteParts = ipAddress.split("\\.");
        if (byteParts.length!=4){
            return false;
            // not a valid IpAddress because it is not composed 4 byte code
        }
        for (String part : byteParts) {
            try {
                int value = Integer.parseInt(part);
                if (value < 0 || value > 255) {
                    return false;
                }
            } catch (NumberFormatException nfe) {
                return false; // Not a valid integer because Integer.ParserInt couldn't parse it value into an integer
            }
        }
        return Integer.parseInt(byteParts[3]) != 0 && Integer.parseInt(byteParts[3]) != 255;// Not a valid ip address because it end with 0 or 255
//valid IPAddress
    }
}
