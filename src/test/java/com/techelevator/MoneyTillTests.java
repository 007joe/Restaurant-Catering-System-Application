package com.techelevator;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.Matchers.hasEntry;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class MoneyTillTests {

    MoneyTill moneytill = new MoneyTill(0);

    @Test
    public void money_till_allowed_deposit_test() {
        moneytill.deposit(20);
        assertEquals(20, moneytill.getBalance(), 0);

    }

    @Test
    public void money_till_not_allowed_deposit_test() {

        moneytill.deposit(2);
        assertEquals(0, moneytill.getBalance(), 0);
    }


    @Test
    public void make_purchase_and_return_balance_test() {
        moneytill.deposit(100);
        moneytill.makePurchase("A1");
        assertEquals(96.50, moneytill.getBalance(), 0);
    }

    @Test
    public void make_invalid_purchase_test() {
        moneytill.makePurchase("B2");
        assertEquals(0, moneytill.getBalance(), 0);
    }

    @Test
    public void give_back_change_whole_dollar_amount_test() {
        HashMap<String, Integer> changeMap = new HashMap<>();
        changeMap.put("Hundreds", 2);
        changeMap.put("Fifties", 1);
        changeMap.put("Twenties", 1);
        changeMap.put("Tens", 1);
        changeMap.put("Fives", 1);
        changeMap.put("Ones", 1);
        moneytill.setBalance(286.00);
        assertThat("changeMap", moneytill.giveChange().size(), equalTo(6));
        moneytill.setBalance(286.00);
//        assertThat("changeMap", moneytill.giveChange(), hasEntry("Hundreds", 2));
//        moneytill.setBalance(286.00);
//        assertThat("changeMap", moneytill.giveChange(), hasEntry("Fifties", 1));
//        moneytill.setBalance(286.00);
//        assertThat("changeMap", moneytill.giveChange(), hasEntry("Twenties", 1));
//        moneytill.setBalance(286.00);
//        assertThat("changeMap", moneytill.giveChange(), hasEntry("Tens", 1));
//        moneytill.setBalance(286.00);
//        assertThat("changeMap", moneytill.giveChange(), hasEntry("Fives", 1));
//        moneytill.setBalance(286.00);
//        assertThat("changeMap", moneytill.giveChange(), hasEntry("Ones", 1));
        moneytill.setBalance(286.00);
        assertEquals(changeMap, moneytill.giveChange());
    }

    @Test
    public void give_back_change_cents_test() {
        HashMap<String, Integer> changeMap = new HashMap<>();
        moneytill.setBalance(0.40);
        changeMap.put("Quarters", 1);
        changeMap.put("Dimes", 1);
        changeMap.put("Nickels", 1);
        assertThat("changeMap", moneytill.giveChange().size(), equalTo(3));
        moneytill.setBalance(0.40);
//        assertThat("changeMap", moneytill.giveChange(), hasEntry("Quarters", 1));
//        moneytill.setBalance(0.40);
//        assertThat("changeMap", moneytill.giveChange(), hasEntry("Dimes", 1));
//        moneytill.setBalance(0.40);
//        assertThat("changeMap", moneytill.giveChange(), hasEntry("Nickels", 1));
        moneytill.setBalance(0.40);
        assertEquals(changeMap, moneytill.giveChange());
    }

}
