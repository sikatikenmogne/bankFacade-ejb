package com.bank.paymentmgmt.integration;

import com.bank.paymentmgmt.model.Payment;
import com.bank.paymentmgmt.model.PaymentStatus;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@ApplicationScoped
public class MapPaymentDAO implements PaymentDAO{

    //compteur initialisé à 1
    private AtomicLong count = new AtomicLong(1);
    private Map<Long,Payment> payments = new ConcurrentHashMap<>();
    @Override
    public Payment add(Payment payment){
        payment.setId(count.getAndIncrement());//on génère l'id
        payment.setStatus(PaymentStatus.VALIDATED);
        //on stocke l'ordre de paiement dans la Map - la clé est l'id.
        payments.put(payment.getId(), payment);
        return payment;
    }

    @Override
    public Payment delete (Long id){
        Payment deletedPayment = payments.remove(id); //on supprime de l'entrée
//correspondant à l'id passé
        if(deletedPayment == null){
            return null;
        }
        deletedPayment.setStatus(PaymentStatus.CANCELLED);
        return deletedPayment;
    }
    @Override
    public Payment find(Long id) {
        return payments.get(id);//récupération dans la Map de l'objet Payment
//associé à la clé
    }

    @Override
    public List<Payment> getAllStoredPayments(){
        List<Payment> paymentList = new ArrayList<>(payments.values());

        //Boucle pour tracer la liste - pourra être supprimée par la suite
        for(Payment p : paymentList){
            System.out.println(p);
        }
        return paymentList;
    }
}
