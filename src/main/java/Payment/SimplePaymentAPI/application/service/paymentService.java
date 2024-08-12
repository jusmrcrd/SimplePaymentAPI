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
    public payment save(paymentDTO dto){
        payment pay = paymentDTO.dtoToPayment(dto);
        return  respPay.save(pay);
    }

    @Transactional
    public void delete(paymentDTO dto){
        respPay.delete(respPay.findById(dto.getIdPayment()).get());
    }

    @Transactional
    public List<payment> findAll(){
        return respPay.findAll();
    }

    @Transactional
    public Optional<payment> findByid(paymentDTO dto){
        return respPay.findById(dto.getIdPayment());
    }

    public ResponseEntity validation(paymentDTO dto){
        if(dto.getAmount() <= 0){
            return ResponseEntity.ok(paymentException
                    .generateFieldError("Amount","Amount value cannot be 0 or less"));
        }

        if(!dto.getMethod().contains("debit") && !dto.getMethod().contains("credit")){
            return ResponseEntity.ok(paymentException
                    .generateFieldError("Method","Method not permited"));
        }

        if(!dto.getFlag().contains("visa") && !dto.getFlag().contains("mastercard")){
            return ResponseEntity.ok(paymentException
                    .generateFieldError("Flag","flag not permited"));
        }

        save(dto);
        return ResponseEntity.ok("status:200");
    }

}
