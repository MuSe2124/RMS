package za.co.carols_boutique_pos.models;

import java.io.Serializable;

public class CardPayment implements Payment, Serializable {

	private String CardNum;
	private String CardType;

	public CardPayment(String CardNum, String CardType) {
		this.CardNum = CardNum;
		this.CardType = CardType;
	}

	public String getCardNum() {
		return CardNum;
	}

	public void setCardNum(String CardNum) {
		this.CardNum = CardNum;
	}

	public String getCardType() {
		return CardType;
	}

	public void setCardType(String CardType) {
		this.CardType = CardType;
	}

	@Override
	public boolean verifyCash(Float price) {
		if (price < 10000) {
			return true;
		} else {
			int ran = (int) (Math.random() * 10 + 1);
			if (ran > 7) {
				return false;
			}
		}
		return true;
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
