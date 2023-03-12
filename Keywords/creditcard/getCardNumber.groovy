package creditcard

import com.creditcards.GenerateCreditCards
import com.kms.katalon.core.annotation.Keyword

import net.andreinc.mockneat.types.enums.CreditCardType;

public class getCardNumber {

	@Keyword
	public String generateCardNumber(CreditCardType cType){

		GenerateCreditCards cCard = new GenerateCreditCards();

		String card = cCard.getCardNumber(cType);
		return card
	}
}
