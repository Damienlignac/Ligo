package fr.ligo.ligo.services.exception;


public class RequestNoLinkException extends Exception{
	public RequestNoLinkException(String errorMessage) {
		super(errorMessage);
	}

}