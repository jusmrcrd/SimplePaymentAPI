package Payment.SimplePaymentAPI.application.service;

import Payment.SimplePaymentAPI.infrastructure.repository.paymentrepository;
import Payment.SimplePaymentAPI.domain.entity.payment;
import Payment.SimplePaymentAPI.domain.dto.paymentDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

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



}
