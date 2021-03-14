package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "creditoffer")
public class CreditOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private float loanAmount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idClient")
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCredit")
    private Credit credit;

    public CreditOffer(Client client, Credit credit, float loanAmount) {
        this.client=client;
        this.credit=credit;
        this.loanAmount = loanAmount;
    }

    public CreditOffer() {

    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(float loanAmount) {
        this.loanAmount = loanAmount;
    }
}
