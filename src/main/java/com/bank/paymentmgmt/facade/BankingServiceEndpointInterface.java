package com.bank.paymentmgmt.facade;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

@WebService(name = "BankingEndpoint")
public interface BankingServiceEndpointInterface {
    @WebMethod(operationName = "paymentOperation")
    @WebResult(name = "acceptedPayment")
    Boolean createPayment(@WebParam(name = "cardNumber") String ccNumber,@WebParam(name = "amountPaid") Double amount);
}
