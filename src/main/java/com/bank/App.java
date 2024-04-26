package com.bank;

import com.bank.paymentmgmt.facade.BankingServiceBean;
import jakarta.xml.ws.Endpoint;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String url= "http://localhost:8280/bankFacade-ejb/services";
        Endpoint.publish(url, new BankingServiceBean());
        System.out.println("Service BanqueService publie sur "+url);
    }
}
