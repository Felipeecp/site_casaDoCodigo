package com.luiz.casadocodigo.security;

import java.security.MessageDigest;
import java.util.Base64;


public class PassGenerator {

	public static void main(String[] args) {
		System.out.println(new PassGenerator().generate("4321"));
	}
	
	public String generate(String senhaTexto) {
		try {
			byte[] digest = MessageDigest.getInstance("sha-256").digest(senhaTexto.getBytes());
			return Base64.getEncoder().encodeToString(digest);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
