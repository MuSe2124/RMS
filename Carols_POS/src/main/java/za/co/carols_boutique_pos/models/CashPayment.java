package za.co.carols_boutique_pos.models;

import java.io.Serializable;

public class CashPayment implements Payment, Serializable {

	private Float payment;

	public CashPayment(Float payment) {
		this.payment = payment;
	}

    public Float getPayment() {
        return payment;
    }

    public void setPayment(Float payment) {
        this.payment = payment;
    }

	@Override
	public boolean verifyCash(Float price) {
		if (payment < price) {
			return false;
		} else {
			return true;
		}
	}

    @Override
    public boolean verifyCard(String cardNumber) {
        if (cardNumber.length() < 12 || cardNumber.length() > 12) {
            return false;
        }else{
            return true;
        }
    }
}
