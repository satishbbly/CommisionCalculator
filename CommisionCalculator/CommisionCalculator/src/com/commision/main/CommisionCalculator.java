package com.commision.main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.commision.model.Trade;
import com.commision.service.CommisionService;

public class CommisionCalculator {
	private static List<Trade> setupData() {
		List<Trade> tradeList = new ArrayList<>();
		Trade trade1 = new Trade("STOCKS", "BUY", 1000L, 12.0f, LocalDateTime.of(2019, 03, 28, 14, 33, 48, 640000));
		Trade trade2 = new Trade("forex", "SELL", 20000L, 15.0f, LocalDateTime.of(2020, 03, 29, 14, 33, 48, 650000));
		tradeList.add(trade1);
		tradeList.add(trade2);
		return tradeList;
	}

	public static void main(String[] args) {
		List<Trade> l = setupData();

		List<Double> commision = l.parallelStream().map(t -> CommisionService.calculateCommision(t))
				.collect(Collectors.toList());

		System.out.println(commision);
	}

}
