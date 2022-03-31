package com.luiz.casadocodigo.service;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.luiz.casadocodigo.daos.CompraDao;
import com.luiz.casadocodigo.infra.MailSender;
import com.luiz.casadocodigo.models.Compra;


@MessageDriven(activationConfig = {
		@ActivationConfigProperty(
				propertyName = "destinationLookup",
				propertyValue = "java:/jms/topics/CarrinhoComprasTopico"),
		@ActivationConfigProperty(
				propertyName = "destinationType",
				propertyValue = "javax.jms.Topic")
})
public class EnviaEmailCompra implements MessageListener {
	
	@Inject
	private CompraDao compraDao;
	@Inject
	private MailSender mailSender;
	
	@Override
	public void onMessage(Message message) {
		try {
			TextMessage textMessage = (TextMessage) message;
			Compra compra = compraDao.buscaPorUuid(textMessage.getText());
			String messageBody = "Sua compra foi realizada com sucesso, com o número de pedido: "+compra.getUuid();
			mailSender.send("compras@casadocodigo.com.br", compra.getUsuario().getEmail(),
					"Sua compra na casa do código", messageBody);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}