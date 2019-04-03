package com.serieManager.serieManagerList.exception;

public class SerieNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SerieNotFoundException(Long id) {
		super("Introuvable : serie " + id);
	}
}