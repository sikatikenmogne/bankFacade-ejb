package com.bank.paymentmgmt.facade;

import com.bank.paymentmgmt.integration.PaymentDAO;
import com.bank.paymentmgmt.model.Payment;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.WebService;

@Stateless
@WebService(
        endpointInterface = "com.bank.paymentmgmt.facade.BankingServiceEndpointInterface",
        portName = "BankingPort",
        serviceName = "BankingService"
)
public class BankingServiceBean implements BankingServiceEndpointInterface {

    @Inject
    private PaymentDAO paymentDAO;

    public BankingServiceBean() {
    }

    public double convertAmount(double amount) {
        return amount * 11;
    }

    public double convertAmountInverse(double amount) {
        return amount / 11;
    }

    @Override
    public Boolean createPayment(String ccNumber, Double amount) {
        if(ccNumber.length()== 10 ){
            System.out.println("Montant payé : "+amount +" €");
            Payment p = new Payment();
            p.setCcNumber(ccNumber);
            p.setAmount(amount);
            // pour l'instant le retour n'est pas utilisé
            p = paymentDAO.add(p);
            // juste pour tester
            paymentDAO.getAllStoredPayments();
            return true;
        } else {
            return false;
        }
    }
}
