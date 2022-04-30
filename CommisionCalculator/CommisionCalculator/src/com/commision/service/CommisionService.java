package com.commision.service;

import java.time.LocalDateTime;

import com.commision.constants.CommisionConstants;
import com.commision.model.Trade;

public class CommisionService {

	public static double calculateCommision(Trade trade) {

		System.out.println("Commision Calculator");

		LocalDateTime dateTime = trade.getDateTime();
		String securityType = trade.getSecurityType();
		String transactionType = trade.getTransactionType();
		long qty = trade.getQty();
		float price = trade.getPrice();

		double commision = 0;

		// calculate commision

		double txnamt = qty * price;

		System.out.println("txn amount : $ " + txnamt);

		switch (securityType.toUpperCase()) {
		case "STOCKS":
			commision = transactionType.equalsIgnoreCase("BUY") ? (txnamt * CommisionConstants.STOCKS_BUY)
					: (txnamt * CommisionConstants.STOCKS_SELL);

			if (txnamt > 100000)
				commision = commision + 500;
			break;

		case "BONDS":
			commision = transactionType.equalsIgnoreCase("BUY") ? (txnamt * CommisionConstants.BOND_BUY)
					: (txnamt * CommisionConstants.BOND_SELL);
			break;

		case "FOREX":

			commision = transactionType.equalsIgnoreCase("BUY") ? (txnamt * CommisionConstants.FOREX_BUY)
					: (txnamt * CommisionConstants.FOREX_SELL);
			if (txnamt > 100000)
				commision = commision + CommisionConstants.FOREX_SELL_GT_1LAKH;
			else if (txnamt > 10000)
				commision = commision + CommisionConstants.FOREX_SELL_GT_TENTHOUSAND;
			break;

		}

		System.out.println("Commision: $ " + commision);
		return commision;
	}

}
