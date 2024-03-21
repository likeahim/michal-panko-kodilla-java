package com.kodilla.good.patterns.challenges.order.contact;

public enum Message {
    ASK_FOR_PAY(0, "Please make a payment to complete your order"),
    WELCOME_MESSAGE(1, "Welcome in out store. Your account is now active, you can start your shopping journey"),
    ORDER_SUCCESS(2, "Your order has been made. For more information now call 68 374 28 56"),
    ORDER_PAY_FAILURE(3, "Something went wrong, please check status of your payment"),
    PRODUCT_OUT_OF_STORE(4, "Someone bought the product from under your nose.");

    private int index;
    private String message;

    Message(int index, String message) {
        this.index = index;
        this.message = message;
    }

    public int getIndex() {
        return index;
    }

    public String getMessage() {
        return message;
    }
}
