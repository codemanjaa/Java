package ch.hevs.exception;

public class RegistryException extends RuntimeException {

	public RegistryException() {
		super();
	}

	public RegistryException(String arg0) {
		super(arg0);
	}

	public RegistryException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public RegistryException(Throwable arg0) {
		super(arg0);
	}

}
