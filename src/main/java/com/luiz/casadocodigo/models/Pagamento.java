package com.luiz.casadocodigo.models;

import java.math.BigDecimal;

public class Pagamento {
	
	private BigDecimal value;

	public Pagamento(BigDecimal total) {
		this.value = total;
	}

	public BigDecimal getValue() {
		return this.value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

}
