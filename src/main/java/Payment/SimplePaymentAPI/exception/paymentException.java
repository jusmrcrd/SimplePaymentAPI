package Payment.SimplePaymentAPI.exception;

import java.util.HashMap;
import java.util.Map;

public class paymentException {

    public static Map<String, String> generateFieldError(String fieldName, String errorMessage) {
        Map<String, String> errorDetails = new HashMap<>();
        errorDetails.put("Status", "400");
        errorDetails.put("field", fieldName);
        errorDetails.put("message", errorMessage);
        return errorDetails;
    }



}
