package com.fastone.test.ApiTest;

import java.math.BigDecimal;

public class DateApi {
	// Mock Price
	private static final BigDecimal LADDER1PRICE = BigDecimal.valueOf(0.1);
	private static final BigDecimal LADDER2PRICE = BigDecimal.valueOf(0.08);
	private static final BigDecimal LADDER3PRICE = BigDecimal.valueOf(0.06);

	public static void main(String[] args) {

		BigDecimal coreHour = BigDecimal.valueOf(35000L);
		BigDecimal allSpend = BigDecimal.ZERO;
		// 比较核时 属于哪个阶段
		if (coreHour.compareTo(BigDecimal.ZERO) > 0 && coreHour.compareTo(BigDecimal.valueOf(10000)) < 0) {
			allSpend = calcuLadderSpend(coreHour, LadderPrice.LADDER1PRICE);
		} else if (coreHour.compareTo(BigDecimal.valueOf(10000)) > 0 && coreHour.compareTo(BigDecimal.valueOf(20000)) < 0) {
			allSpend = calcuLadderSpend(coreHour, LadderPrice.LADDER2PRICE);
		} else if (coreHour.compareTo(BigDecimal.valueOf(20000)) > 0) {
			allSpend = calcuLadderSpend(coreHour, LadderPrice.LADDER3PRICE);
		}
		System.out.println(allSpend);
	}

	private static BigDecimal calcuLadderSpend(BigDecimal coreHour, LadderPrice ladderPrice) {
		switch (ladderPrice) {
			case LADDER2PRICE:
				return Ladder2Spend(coreHour);
			case LADDER3PRICE:
				return Ladder3Spend(coreHour);
			default:
				return calculate(coreHour, LADDER1PRICE);
		}
	}

	private static BigDecimal Ladder2Spend(BigDecimal coreHour) {
		BigDecimal ladder2CoreHour = coreHour.subtract(BigDecimal.valueOf(10000));
		BigDecimal ladder1CoreHour = coreHour.subtract(ladder2CoreHour);
		// 算出第一阶段价格
		BigDecimal ladder1Spend = calcuLadderSpend(ladder1CoreHour, LadderPrice.LADDER1PRICE);
		// 算出第二阶段价格
		BigDecimal ladder2Spend = calculate(ladder2CoreHour, LADDER2PRICE);
		// 返回两个阶段的和
		return ladder2Spend.add(ladder1Spend);
	}

	private static BigDecimal Ladder3Spend(BigDecimal coreHour) {
		BigDecimal ladder3CoreHour = coreHour.subtract(BigDecimal.valueOf(20000));
		BigDecimal ladder2CoreHour = coreHour.subtract(ladder3CoreHour);
		// 算出第二阶段价格
		BigDecimal ladder2Spend = calcuLadderSpend(ladder2CoreHour, LadderPrice.LADDER2PRICE);
		// 算出第三阶段价格
		BigDecimal ladder3Spend = calculate(ladder3CoreHour, LADDER3PRICE);
		// 返回两个阶段的和
		return ladder2Spend.add(ladder3Spend);
	}

	private static BigDecimal calculate(BigDecimal coreHour, BigDecimal price) {
		return coreHour.multiply(price);
	}

	public enum LadderPrice {
		LADDER1PRICE,
		LADDER2PRICE,
		LADDER3PRICE
	}

}
