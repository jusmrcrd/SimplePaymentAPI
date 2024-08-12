package Payment.SimplePaymentAPI.domain.dto;

import Payment.SimplePaymentAPI.domain.entity.payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class paymentDTO {
    private long  idPayment;
    private String method;
    private String flag;
    private Double amount;


    public static payment dtoToPayment(paymentDTO paymentDTO){
        payment pay  = new payment();

        pay.setIdPayment(paymentDTO.getIdPayment());
        pay.setFlag(paymentDTO.getFlag());
        pay.setMethod(paymentDTO.getMethod());
        pay.setAmount(paymentDTO.getAmount());

        return pay;
    }
}
