package com.sac.inheritance;

public interface PaymentImplicitPoly {
	Long getPaymentAmount();

	void setPaymentAmount(final Long paymentAmount);

	String getPaymentCurrency();

	void setPaymentCurrency(final String currency);
}