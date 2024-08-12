package Payment.SimplePaymentAPI.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment")
public class payment {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id_payment")
   private long  idPayment;
   @Column(name="method")
   private String method;
   @Column(name="flag_type")
   private String flag;
   @Column(name="amount")
   private Double amount;

   @Column(name="Data")
   private LocalDate date = LocalDate.now();
}
