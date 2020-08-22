package jison.ApparelSpringApp;

class ApparelNotFoundException extends RuntimeException {

	ApparelNotFoundException(Long id) {
		super("Could not find apparel: " + id);
	}
}
