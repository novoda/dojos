package com.novoda.dojos.bankaccount.logging;

public interface Logger<L, O, G> {

	void log(L arg1, O arg2, G arg3);

}