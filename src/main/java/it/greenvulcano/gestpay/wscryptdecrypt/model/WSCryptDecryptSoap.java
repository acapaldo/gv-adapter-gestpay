
package it.greenvulcano.gestpay.wscryptdecrypt.model;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WSCryptDecryptSoap", targetNamespace = "https://ecomm.sella.it/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WSCryptDecryptSoap {


    /**
     * 
     * @param buyerEmail
     * @param redFraudPrevention
     * @param redBillingInfo
     * @param redShippingInfo
     * @param redCustomerInfo
     * @param expiryYear
     * @param customInfo
     * @param redCustomerData
     * @param payPalBillingAgreementDescription
     * @param shopTransactionId
     * @param shippingDetails
     * @param redItems
     * @param paymentTypes
     * @param shopLogin
     * @param amount
     * @param cvv
     * @param conselCustomerInfo
     * @param uicCode
     * @param expiryMonth
     * @param languageId
     * @param paymentTypeDetail
     * @param buyerName
     * @param conselMerchantPro
     * @param orderDetails
     * @param ppSellerProtection
     * @param requestToken
     * @param redCustomInfo
     * @param cardNumber
     * @return
     *     returns it.greenvulcano.gestpay.wscryptdecrypt.model.EncryptResponse.EncryptResult
     */
    @WebMethod(operationName = "Encrypt", action = "https://ecomm.sella.it/Encrypt")
    @WebResult(name = "EncryptResult", targetNamespace = "https://ecomm.sella.it/")
    @RequestWrapper(localName = "Encrypt", targetNamespace = "https://ecomm.sella.it/", className = "it.greenvulcano.gestpay.wscryptdecrypt.model.Encrypt")
    @ResponseWrapper(localName = "EncryptResponse", targetNamespace = "https://ecomm.sella.it/", className = "it.greenvulcano.gestpay.wscryptdecrypt.model.EncryptResponse")
    public it.greenvulcano.gestpay.wscryptdecrypt.model.EncryptResponse.EncryptResult encrypt(
        @WebParam(name = "shopLogin", targetNamespace = "https://ecomm.sella.it/")
        String shopLogin,
        @WebParam(name = "uicCode", targetNamespace = "https://ecomm.sella.it/")
        String uicCode,
        @WebParam(name = "amount", targetNamespace = "https://ecomm.sella.it/")
        String amount,
        @WebParam(name = "shopTransactionId", targetNamespace = "https://ecomm.sella.it/")
        String shopTransactionId,
        @WebParam(name = "cardNumber", targetNamespace = "https://ecomm.sella.it/")
        String cardNumber,
        @WebParam(name = "expiryMonth", targetNamespace = "https://ecomm.sella.it/")
        String expiryMonth,
        @WebParam(name = "expiryYear", targetNamespace = "https://ecomm.sella.it/")
        String expiryYear,
        @WebParam(name = "buyerName", targetNamespace = "https://ecomm.sella.it/")
        String buyerName,
        @WebParam(name = "buyerEmail", targetNamespace = "https://ecomm.sella.it/")
        String buyerEmail,
        @WebParam(name = "languageId", targetNamespace = "https://ecomm.sella.it/")
        String languageId,
        @WebParam(name = "cvv", targetNamespace = "https://ecomm.sella.it/")
        String cvv,
        @WebParam(name = "customInfo", targetNamespace = "https://ecomm.sella.it/")
        String customInfo,
        @WebParam(name = "requestToken", targetNamespace = "https://ecomm.sella.it/")
        String requestToken,
        @WebParam(name = "ppSellerProtection", targetNamespace = "https://ecomm.sella.it/")
        String ppSellerProtection,
        @WebParam(name = "shippingDetails", targetNamespace = "https://ecomm.sella.it/")
        ShippingDetails shippingDetails,
        @WebParam(name = "paymentTypes", targetNamespace = "https://ecomm.sella.it/")
        PaymentTypes paymentTypes,
        @WebParam(name = "paymentTypeDetail", targetNamespace = "https://ecomm.sella.it/")
        PaymentTypeDetail paymentTypeDetail,
        @WebParam(name = "redFraudPrevention", targetNamespace = "https://ecomm.sella.it/")
        String redFraudPrevention,
        @WebParam(name = "Red_CustomerInfo", targetNamespace = "https://ecomm.sella.it/")
        RedCustomerInfo redCustomerInfo,
        @WebParam(name = "Red_ShippingInfo", targetNamespace = "https://ecomm.sella.it/")
        RedShippingInfo redShippingInfo,
        @WebParam(name = "Red_BillingInfo", targetNamespace = "https://ecomm.sella.it/")
        RedBillingInfo redBillingInfo,
        @WebParam(name = "Red_CustomerData", targetNamespace = "https://ecomm.sella.it/")
        RedCustomerData redCustomerData,
        @WebParam(name = "Red_CustomInfo", targetNamespace = "https://ecomm.sella.it/")
        RedCustomInfo redCustomInfo,
        @WebParam(name = "Red_Items", targetNamespace = "https://ecomm.sella.it/")
        RedItems redItems,
        @WebParam(name = "Consel_MerchantPro", targetNamespace = "https://ecomm.sella.it/")
        String conselMerchantPro,
        @WebParam(name = "Consel_CustomerInfo", targetNamespace = "https://ecomm.sella.it/")
        ConselCustomerInfo conselCustomerInfo,
        @WebParam(name = "payPalBillingAgreementDescription", targetNamespace = "https://ecomm.sella.it/")
        String payPalBillingAgreementDescription,
        @WebParam(name = "OrderDetails", targetNamespace = "https://ecomm.sella.it/")
        EcommGestpayPaymentDetails orderDetails);

    /**
     * 
     * @param cryptedString
     * @param shopLogin
     * @return
     *     returns it.greenvulcano.gestpay.wscryptdecrypt.model.DecryptResponse.DecryptResult
     */
    @WebMethod(operationName = "Decrypt", action = "https://ecomm.sella.it/Decrypt")
    @WebResult(name = "DecryptResult", targetNamespace = "https://ecomm.sella.it/")
    @RequestWrapper(localName = "Decrypt", targetNamespace = "https://ecomm.sella.it/", className = "it.greenvulcano.gestpay.wscryptdecrypt.model.Decrypt")
    @ResponseWrapper(localName = "DecryptResponse", targetNamespace = "https://ecomm.sella.it/", className = "it.greenvulcano.gestpay.wscryptdecrypt.model.DecryptResponse")
    public it.greenvulcano.gestpay.wscryptdecrypt.model.DecryptResponse.DecryptResult decrypt(
        @WebParam(name = "shopLogin", targetNamespace = "https://ecomm.sella.it/")
        String shopLogin,
        @WebParam(name = "CryptedString", targetNamespace = "https://ecomm.sella.it/")
        String cryptedString);

}