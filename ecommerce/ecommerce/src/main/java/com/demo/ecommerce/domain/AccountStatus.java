package com.demo.ecommerce.domain;

public enum AccountStatus {

    PENDING_VERIFICATION,//Account is created but yet verified 
    ACTIVE,              //Account is active and in good standing
    SUSPENDED,           // Account is temporaily suspended,possible due to violations
    DEACTIVATD,          //Account is deactivated,user may have chosen to deactivates it
    BANNED,             //account is permently banned due to server violation
    CLOSED               //Account is permently closed, possibly at user request

}
