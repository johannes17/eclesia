package br.vix.rws.eclesia.service.exception;

public class SenhaObrigatoriaUsuarioException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public SenhaObrigatoriaUsuarioException(String message) {
		super(message);
	}

}