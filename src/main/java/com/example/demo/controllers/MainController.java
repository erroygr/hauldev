package com.example.demo.controllers;

import com.example.demo.calc.LoanPayment;
import com.example.demo.model.*;
import com.example.demo.repo.BankRepository;
import com.example.demo.repo.CreditOfferRepository;
import com.example.demo.repo.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repo.ClientRepository;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class MainController {

    @GetMapping("/")
    public String homeHaul(Model model) {
        model.addAttribute("title", "Главная страница");
        return "homeHaul";

    }

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CreditRepository creditRepository;
    @Autowired
    private BankRepository bankRepository;
    @Autowired
    private CreditOfferRepository creditOfferRepository;

    private LoanPay loanPay =new LoanPay();


    //GET POST CLIENT
    @GetMapping("/view-client")
    public String viewRequestMain(Model model) {
        Iterable<Client> clients = clientRepository.findAll();
        model.addAttribute("clients",clients);
        return "client/view-client";
    }

    @GetMapping("/view-client/add")
    public String addClientMain(Model model) {
        return "client/create-client";
    }
    @PostMapping("/view-client/add")
    public String addPostClientMain( @RequestParam String FIO,
                                     @RequestParam String phone,
                                     @RequestParam String email,
                                     @RequestParam String numberPassport,
                                     Model model) {

        Client client = new Client(FIO,
                                   phone,
                                   email,
                                   numberPassport);
        clientRepository.save(client);

        return "redirect:/view-client";
    }

    @GetMapping("/view-client/{id}")
    public String viewClientDetails(@PathVariable(value = "id") long id, Model model){
        if(!clientRepository.existsById(id)){
            return "redirect:/view-client";
        }
        Optional<Client> client = clientRepository.findById(id);
        ArrayList<Client> clients = new ArrayList<>();
        client.ifPresent(clients::add);
        model.addAttribute("client",clients);
        return "client/view-client-details";
    }

    @GetMapping("/view-client/{id}/edite")
    public String clientEdit(@PathVariable(value = "id") long id, Model model){
        if(!clientRepository.existsById(id)){
            return "redirect:/view-client";
        }
        Optional<Client> client = clientRepository.findById(id);
        ArrayList<Client> clients = new ArrayList<>();
        client.ifPresent(clients::add);
        model.addAttribute("client",clients);
        return "client/view-client-edite";
    }

    @PostMapping("/view-client/{id}/edite")
    public String updatePostClientMain(@PathVariable(value = "id") long id,
                                       @RequestParam String FIO,
                                       @RequestParam String phone,
                                       @RequestParam String email,
                                       @RequestParam String numberPassport,
                                       Model model) {

        Client client = clientRepository.findById(id).orElseThrow();
        client.setFIO(FIO);
        client.setPhone(phone);
        client.setEmail(email);
        client.setNumberPassport(numberPassport);
        clientRepository.save(client);

        return "redirect:/view-client";
    }

    @PostMapping("/view-client/{id}/remove")
    public String deletePostClientMain(@PathVariable(value = "id") long id,
                                        Model model) {

        Client client = clientRepository.findById(id).orElseThrow();
        clientRepository.delete(client);
        return "redirect:/view-client";
    }

    //GET POST CREDIT
    @GetMapping("/view-credit")
    public String viewRequestCreditMain(Model model) {
        Iterable<Credit> credits = creditRepository.findAll();
        model.addAttribute("credits",credits);
        return "credit/view-credit";
    }

    @GetMapping("/view-credit/add")
    public String addCreditsMain(Model model) {
        return "credit/create-credit";
    }

    @PostMapping("/view-credit/add")
    public String addPostCreditMain( @RequestParam String creditLimit,
                                     @RequestParam String interestRate,
                                     Model model) {

        Credit credit = new Credit(Float.parseFloat(creditLimit),
                Float.parseFloat(interestRate));
        creditRepository.save(credit);

        return "redirect:/view-credit";
    }

    @GetMapping("/view-credit/{id}")
    public String viewCreditDetails(@PathVariable(value = "id") long id, Model model){
        if(!creditRepository.existsById(id)){
            return "redirect:/view-credit";
        }
        Optional<Credit> credit = creditRepository.findById(id);
        ArrayList<Credit> credits = new ArrayList<>();
        credit.ifPresent(credits::add);
        model.addAttribute("credit",credits);
        return "credit/view-credit-details";
    }

    @GetMapping("/view-credit/{id}/edite")
    public String creditEdit(@PathVariable(value = "id") long id, Model model){
        if(!creditRepository.existsById(id)){
            return "redirect:/view-credit";
        }
        Optional<Credit> credit = creditRepository.findById(id);
        ArrayList<Credit> credits = new ArrayList<>();
        credit.ifPresent(credits::add);
        model.addAttribute("credit",credits);
        return "credit/view-credit-edite";
    }

    @PostMapping("/view-credit/{id}/edite")
    public String updatePostCreditMain(@PathVariable(value = "id") long id,
                                       @RequestParam String creditLimit,
                                       @RequestParam String interestRate,
                                       Model model) {

        Credit credit = creditRepository.findById(id).orElseThrow();
        credit.setCreditLimit(Float.parseFloat(creditLimit));
        credit.setInterestRate(Float.parseFloat(interestRate));
        creditRepository.save(credit);

        return "redirect:/view-credit";
    }

    @PostMapping("/view-credit/{id}/remove")
    public String deletePostCreditMain(@PathVariable(value = "id") long id,
                                       Model model) {

        Credit credit = creditRepository.findById(id).orElseThrow();
        creditRepository.delete(credit);
        return "redirect:/view-credit";
    }


    ////// BANK

    @GetMapping("/view-bank")
    public String viewRequestBankMain(Model model) {

        Iterable<Bank> banks = bankRepository.findAll();
        model.addAttribute("banks",banks);
        return "bank/view-bank";
    }

    @GetMapping("/view-bank/add")
    public String addBankMain(Model model) {
        Iterable<Client> clients = clientRepository.findAll();
        model.addAttribute("clients",clients);

        Iterable<Credit> credits = creditRepository.findAll();
        model.addAttribute("credits",credits);

        return "bank/create-bank";
    }
    @PostMapping("/view-bank/add")
    public String addPostBankMain( @RequestParam String client,
                                     @RequestParam String credit,
                                     Model model) {
        Client client1 = clientRepository.findByFIO(client);
        Credit credit1 = creditRepository.findByCreditLimit(Float.parseFloat(credit));

        Bank bank = new Bank(client1,
                credit1);
        bankRepository.save(bank);

        return "redirect:/view-bank";
    }

    @GetMapping("/view-bank/{id}")
    public String viewBankDetails(@PathVariable(value = "id") long id, Model model){
        if(!bankRepository.existsById(id)){
            return "redirect:/view-bank";
        }
        Optional<Bank> bank = bankRepository.findById(id);
        ArrayList<Bank> banks = new ArrayList<>();
        bank.ifPresent(banks::add);
        model.addAttribute("bank",banks);
        return "bank/view-bank-details";
    }

    @GetMapping("/view-bank/{id}/edite")
    public String bankEdit(@PathVariable(value = "id") long id, Model model){
        if(!bankRepository.existsById(id)){
            return "redirect:/view-bank";
        }
        Optional<Bank> bank = bankRepository.findById(id);
        ArrayList<Bank> banks = new ArrayList<>();
        bank.ifPresent(banks::add);
        model.addAttribute("bank",banks);

        Iterable<Client> clients = clientRepository.findAll();
        model.addAttribute("clients",clients);

        Iterable<Credit> credits = creditRepository.findAll();
        model.addAttribute("credits",credits);

        return "bank/view-bank-edite";
    }

    @PostMapping("/view-bank/{id}/edite")
    public String updatePostBankMain(@PathVariable(value = "id") long id,
                                     @RequestParam String client,
                                     @RequestParam String credit,
                                       Model model) {

        Bank bank =bankRepository.findById(id).orElseThrow();
        bank.setClient(clientRepository.findByFIO(client));
        bank.setCredit(creditRepository.findByCreditLimit(Float.parseFloat(credit)));
        bankRepository.save(bank);
        return "redirect:/view-bank";
    }

    @PostMapping("/view-bank/{id}/remove")
    public String deletePostBankMain(@PathVariable(value = "id") long id,
                                       Model model) {

        Bank bank = bankRepository.findById(id).orElseThrow();
        bankRepository.delete(bank);
        return "redirect:/view-bank";
    }

    ////// CREDITOFFER

    @GetMapping("/view-creditOffer")
    public String viewRequestCreditOfferMain(Model model) {

        Iterable<CreditOffer> creditOffers = creditOfferRepository.findAll();
        model.addAttribute("creditOffers",creditOffers);
        return "creditOffer/view-creditOffer";
    }

    @GetMapping("/view-creditOffer/add")
    public String addCreditOfferMain(Model model) {
        Iterable<Client> clients = clientRepository.findAll();
        model.addAttribute("clients",clients);

        Iterable<Credit> credits = creditRepository.findAll();
        model.addAttribute("credits",credits);

        return "creditOffer/create-creditOffer";
    }
    @PostMapping("/view-creditOffer/add")
    public String addPostCreditOfferMain( @RequestParam String client,
                                   @RequestParam String credit,
                                   @RequestParam String loanAmount,
                                   Model model) {
        Client client1 = clientRepository.findByFIO(client);
        Credit credit1 = creditRepository.findByCreditLimit(Float.parseFloat(credit));

        CreditOffer creditOffer = new CreditOffer(client1,
                credit1,
                Float.parseFloat(loanAmount));
        creditOfferRepository.save(creditOffer);

        return "redirect:/view-creditOffer";
    }

    @GetMapping("/view-creditOffer/{id}")
    public String viewCreditOfferDetails(@PathVariable(value = "id") long id, Model model){
        if(!creditOfferRepository.existsById(id)){
            return "redirect:/view-creditOffer";
        }
        Optional<CreditOffer> creditOffer = creditOfferRepository.findById(id);
        ArrayList<CreditOffer> creditOffers = new ArrayList<>();
        creditOffer.ifPresent(creditOffers::add);
        model.addAttribute("creditOffer",creditOffers);
        return "creditOffer/view-creditOffer-details";
    }

    @GetMapping("/view-creditOffer/{id}/edite")
    public String creditOfferEdit(@PathVariable(value = "id") long id, Model model){
        if(!creditOfferRepository.existsById(id)){
            return "redirect:/view-creditOffer";
        }
        Optional<CreditOffer> creditOffer = creditOfferRepository.findById(id);
        ArrayList<CreditOffer> creditOffers = new ArrayList<>();
        creditOffer.ifPresent(creditOffers::add);
        model.addAttribute("creditOffer",creditOffers);

        Iterable<Client> clients = clientRepository.findAll();
        model.addAttribute("clients",clients);

        Iterable<Credit> credits = creditRepository.findAll();
        model.addAttribute("credits",credits);

        return "creditOffer/view-creditOffer-edite";
    }

    @PostMapping("/view-creditOffer/{id}/edite")
    public String updatePostCreditOfferMain(@PathVariable(value = "id") long id,
                                     @RequestParam String client,
                                     @RequestParam String credit,
                                     @RequestParam String loanAmount,
                                     Model model) {

        CreditOffer creditOffer =creditOfferRepository.findById(id).orElseThrow();
        creditOffer.setClient(clientRepository.findByFIO(client));
        creditOffer.setCredit(creditRepository.findByCreditLimit(Float.parseFloat(credit)));
        creditOffer.setLoanAmount(Float.parseFloat(loanAmount));
        creditOfferRepository.save(creditOffer);
        return "redirect:/view-creditOffer";
    }

    @PostMapping("/view-creditOffer/{id}/remove")
    public String deletePostCreditOfferMain(@PathVariable(value = "id") long id,
                                     Model model) {

        CreditOffer creditOffer = creditOfferRepository.findById(id).orElseThrow();
        creditOfferRepository.delete(creditOffer);
        return "redirect:/view-creditOffer";
    }

    //////

    @GetMapping("/calcCreditOffers")
    public String calcGetCreditOffer(Model model){
        model.addAttribute("everyMonthProcents",loanPay.getEveryMonthProcents());
        model.addAttribute("annuitantPaymentSum",loanPay.getAnnuitantPaymentSum());
        model.addAttribute("percentPayments",loanPay.getPercentPayments());
        model.addAttribute("bodyPayments",loanPay.getBodyPayments());

        return "creditOffer/calcCreditOffer";
    }

    @PostMapping("/calcCreditOffer")
    public String calcPostCreditOffer(@RequestParam String loanAmount,
                                      @RequestParam String interestRate,
                                      @RequestParam String tern,
                                      Model model) {

        loanPay.setEveryMonthProcents(LoanPayment.getEveryMonthProcents(Float.parseFloat(interestRate)));


        loanPay.setAnnuitantPaymentSum(LoanPayment.getAnnuitantPaymentSum(Float.parseFloat(interestRate),
                Float.parseFloat(tern)));


        loanPay.setPercentPayments(LoanPayment.getPercentPayments(Float.parseFloat(loanAmount),
                Float.parseFloat(interestRate), Float.parseFloat(tern)));


        loanPay.setBodyPayments(LoanPayment.getBodyPayments(Float.parseFloat(loanAmount),
                Float.parseFloat(interestRate), Float.parseFloat(tern)));

        return "redirect:/calcCreditOffers";
    }

    //////
}
