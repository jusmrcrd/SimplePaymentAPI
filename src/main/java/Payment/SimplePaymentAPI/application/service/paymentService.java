package Payment.SimplePaymentAPI.application.service;

import Payment.SimplePaymentAPI.infrastructure.repository.paymentrepository;
import Payment.SimplePaymentAPI.domain.entity.payment;
import Payment.SimplePaymentAPI.domain.dto.paymentDTO;
import Payment.SimplePaymentAPI.exception.paymentException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class paymentService {

    @Autowired
    private paymentrepository respPay;


    @Transactional
    public payment save(paymentDTO paymentDTO){
       payment pay = new payment(
               paymentDTO.getIdPayment(),
               paymentDTO.getMethod(),
               paymentDTO.getFlag(),
               paymentDTO.getAmount()
       );
        return  respPay.save(pay);
    }

    @Transactional
    public void delete(paymentDTO paymentDTO){
        respPay.delete(respPay.findById(paymentDTO.getIdPayment()).get());
    }

    @Transactional
    public List<payment> findAll(){
        return respPay.findAll();
    }

    @Transactional
    public Optional<payment> findByid(paymentDTO paymentDTO){
        return respPay.findById(paymentDTO.getIdPayment());
    }

    public ResponseEntity validation(paymentDTO paymentDTO){
        if(paymentDTO.getAmount() <= 0){
            return ResponseEntity.ok(paymentException
                    .generateFieldError("Amount","Amount value cannot be 0 or less"));
        }

        if(!paymentDTO.getMethod().contains("debit") && !paymentDTO.getMethod().contains("credit")){
            return ResponseEntity.ok(paymentException
                    .generateFieldError("Method","Method not permited"));
        }

        if(!paymentDTO.getFlag().contains("visa") && !paymentDTO.getFlag().contains("mastercard")){
            return ResponseEntity.ok(paymentException
                    .generateFieldError("Flag","flag not permited"));
        }

        return ResponseEntity.ok("status:200");
    }

}
