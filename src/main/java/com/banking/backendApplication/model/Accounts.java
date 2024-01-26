package com.banking.backendApplication.model;

import jakarta.persistence.*;

@Entity
public class Accounts {
    @Column(name="customer_id")
    private int customerId;

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="account_number")
    private long accoutNumber;

    @Column(name="account_type")
    private String accountType;

    @Column(name="branch_address")
    private String branchAddress;

    @Column(name="create_dt")
    private String createDt;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public long getAccoutNumber() {
        return accoutNumber;
    }

    public void setAccoutNumber(long accoutNumber) {
        this.accoutNumber = accoutNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public String getCreateDt() {
        return createDt;
    }

    public void setCreateDt(String createDt) {
        this.createDt = createDt;
    }
}
