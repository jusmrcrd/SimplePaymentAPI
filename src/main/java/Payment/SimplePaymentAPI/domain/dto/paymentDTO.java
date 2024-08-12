package Payment.SimplePaymentAPI.domain.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class paymentDTO {
    private long  idPayment;
    private String method;
    private String flag;
    private Double amount;
}
