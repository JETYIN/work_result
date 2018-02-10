package com.funcell.platform.android.game.proxy.pay;

import java.math.BigDecimal;

public class FuncellMoney {
	private BigDecimal mMoney;

	private FuncellMoney(BigDecimal moneyAmount) {
		mMoney = moneyAmount;
	}

	public BigDecimal valueOfMoney() {
		return mMoney;
	}
	
	public static FuncellMoney createFromMoney(BigDecimal moneyAmount) {
		return new FuncellMoney(moneyAmount);
	}
}
