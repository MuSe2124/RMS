package za.co.carols_boutique_pos.models;

public interface Payment {

	boolean verifyCash(Float price);
        boolean verifyCard(String cardNumber);

}
