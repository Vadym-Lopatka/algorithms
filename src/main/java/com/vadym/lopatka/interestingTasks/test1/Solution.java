package com.vadym.lopatka.interestingTasks.test1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class DigitalWalletTransaction {
    //constant error codes
    private static final String INSUFFICIENT_BALANCE_CODE = "INSUFFICIENT_BALANCE";
    private static final String USER_NOT_AUTHORIZED_CODE = "USER_NOT_AUTHORIZED";
    private static final String INVALID_AMOUNT_CODE = "INVALID_AMOUNT";

    //constant error messages
    private static final String USER_NOT_AUTHORIZED_MSG = "User not authorized";
    private static final String INSUFFICIENT_BALANCE_MSG = "Insufficient balance";
    private static final String INVALID_AMOUNT_MSG = "Amount should be greater than zero";

    /**
     *
     * @param digitalWallet - the DigitalWallet that will be updated
     * @param amount - the amount of money that will be added. Should be greater than 0
     * @throws TransactionException - will thrown when parameters are not correct
     */
    void addMoney(DigitalWallet digitalWallet, int amount) throws TransactionException {
        checkParamsCorrectness(digitalWallet, amount);

        int oldWalletBalance = digitalWallet.getWalletBalance();
        digitalWallet.setWalletBalance(oldWalletBalance + amount);
    }

    /**
     *
     * @param digitalWallet - the DigitalWallet that will be updated
     * @param amount - the amount of money that will be added. Should be > 0 and shouldn't make walletBalance < 0
     * @throws TransactionException - will thrown when parameters are not correct
     */
    void payMoney(DigitalWallet digitalWallet, int amount) throws TransactionException {
        checkParamsCorrectness(digitalWallet, amount);

        if ((digitalWallet.getWalletBalance() - amount) < 0)
            throw new TransactionException(INSUFFICIENT_BALANCE_MSG, INSUFFICIENT_BALANCE_CODE);

        int oldWalletBalance = digitalWallet.getWalletBalance();
        digitalWallet.setWalletBalance(oldWalletBalance - amount);
    }


    private void checkParamsCorrectness(DigitalWallet digitalWallet, int amount) throws TransactionException {
        if (digitalWallet.getUserAccessToken() == null)
            throw new TransactionException(USER_NOT_AUTHORIZED_MSG, USER_NOT_AUTHORIZED_CODE);

        if (amount <= 0)
            throw new TransactionException(INVALID_AMOUNT_MSG, INVALID_AMOUNT_CODE);
    }
}

class DigitalWallet {
    private String walletId;
    private String username;
    private String userAccessToken;
    private int walletBalance;

    DigitalWallet(String walletId, String username) {
        this.walletId = walletId;
        this.username = username;
    }

    DigitalWallet(String walletId, String username, String userAccessToken) {
        this.walletId = walletId;
        this.username = username;
        this.userAccessToken = userAccessToken;
    }

    String getWalletId() {
        return walletId;
    }

    String getUsername() {
        return username;
    }

    String getUserAccessToken() {
        return userAccessToken;
    }

    int getWalletBalance() {
        return walletBalance;
    }

    void setWalletBalance(int walletBalance) {
        this.walletBalance = walletBalance;
    }
}

class TransactionException extends RuntimeException {
    private final long serialVersionUID = 1L;
    private String errorCode;

    TransactionException(String errorMessage, String errorCode) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

    String getErrorCode() {
        return errorCode;
    }
}

/*
 * Create TransactionException, DigitalWallet, and DigitalWalletTransaction classes here.
 */
public class Solution {
    private static final Scanner INPUT_READER = new Scanner(System.in);
    private static final DigitalWalletTransaction DIGITAL_WALLET_TRANSACTION = new DigitalWalletTransaction();

    private static final Map<String, DigitalWallet> DIGITAL_WALLETS = new HashMap<>();

    public static void main(String[] args) {
        int numberOfWallets = Integer.parseInt(INPUT_READER.nextLine());
        while (numberOfWallets-- > 0) {
            String[] wallet = INPUT_READER.nextLine().split(" ");
            DigitalWallet digitalWallet;

            if (wallet.length == 2) {
                digitalWallet = new DigitalWallet(wallet[0], wallet[1]);
            } else {
                digitalWallet = new DigitalWallet(wallet[0], wallet[1], wallet[2]);
            }

            DIGITAL_WALLETS.put(wallet[0], digitalWallet);
        }

        int numberOfTransactions = Integer.parseInt(INPUT_READER.nextLine());
        while (numberOfTransactions-- > 0) {
            String[] transaction = INPUT_READER.nextLine().split(" ");
            DigitalWallet digitalWallet = DIGITAL_WALLETS.get(transaction[0]);

            if (transaction[1].equals("add")) {
                try {
                    DIGITAL_WALLET_TRANSACTION.addMoney(digitalWallet, Integer.parseInt(transaction[2]));
                    System.out.println("Wallet successfully credited.");
                } catch (TransactionException ex) {
                    System.out.println(ex.getErrorCode() + ": " + ex.getMessage() + ".");
                }
            } else {
                try {
                    DIGITAL_WALLET_TRANSACTION.payMoney(digitalWallet, Integer.parseInt(transaction[2]));
                    System.out.println("Wallet successfully debited.");
                } catch (TransactionException ex) {
                    System.out.println(ex.getErrorCode() + ": " + ex.getMessage() + ".");
                }
            }
        }

        System.out.println();

        DIGITAL_WALLETS.keySet()
                .stream()
                .sorted()
                .map((digitalWalletId) -> DIGITAL_WALLETS.get(digitalWalletId))
                .forEachOrdered((digitalWallet) -> {
                    System.out.println(digitalWallet.getWalletId()
                            + " " + digitalWallet.getUsername()
                            + " " + digitalWallet.getWalletBalance());
                });
    }
}