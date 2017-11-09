[![gv-logo](img/logo.png)](http://www.greenvulcanotechnologies.com)

[<img src="img/index.png" width="32">](index.md)

----
### Delete Payment
Delete an authorized transaction. Parameters in **bold** are mandatory.

- **Payload**:
<pre>

        {
           <b> "shopLogin":< shopLogin >,
            "shopTransactionId":< shopTransactionId >,
            "bankTransactionId":< bankTransactionId >,</b>
            "cancelReason":< cancelReason >
        }

</pre>

Note: shopTransactionID might also suffice if unique

- **Response**:

```
    {
        "ErrorDescription": "<ErrorDescription>",
        "TransactionType": "<TransactionType>",
        "TransactionResult": "<TransactionResult>",
        "ShopTransactionID": "<ShopTransactionID>",
        "ErrorCode": <ErrorCode>,
        "BankTransactionID": <BankTransactionID>
    }
```
