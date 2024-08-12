package Payment.SimplePaymentAPI.infrastructure.repository;

import Payment.SimplePaymentAPI.domain.entity.payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface paymentrepository extends JpaRepository<payment,Long> {

}
