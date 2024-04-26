package com.bank.paymentmgmt.integration;

import com.bank.paymentmgmt.model.Payment;

import java.util.List;

public interface PaymentDAO {
    //stockage d'un ordre de paiement dans une Map
    Payment add(Payment payment);
    //suppression d'un ordre de paiement
    Payment delete(Long id);
    //recherche d'un paiement en fonction de son id
    Payment find(Long id);
    //obtention d'une liste contenant les paiements créés non supprimés
    List<Payment> getAllStoredPayments();
}
