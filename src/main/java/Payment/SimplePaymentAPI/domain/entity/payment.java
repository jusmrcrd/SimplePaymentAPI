package Payment.SimplePaymentAPI.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment")
public class payment {

   @Id
   @Column(name = "id_payment")
   private long  idPayment;
   @Column(name="method")
   private String method;
   @Column(name="flag_type")
   private String flag;
   @Column(name="amount")
   private Double amount;

}
