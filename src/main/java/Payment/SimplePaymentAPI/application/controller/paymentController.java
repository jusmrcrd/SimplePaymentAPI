package Payment.SimplePaymentAPI.application.controller;

import Payment.SimplePaymentAPI.domain.dto.paymentDTO;
import Payment.SimplePaymentAPI.application.service.paymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class paymentController {

    @Autowired
    private paymentService payService;

    @PostMapping("payment")
    private ResponseEntity<?> Payment(@RequestBody paymentDTO payDTO){
        //esse pagamento esta valido?
        //esse pagamento passa pela api do banco?
        //esse pagamento caso não passar retorna qual erro

        payService.save(payDTO);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }


}
