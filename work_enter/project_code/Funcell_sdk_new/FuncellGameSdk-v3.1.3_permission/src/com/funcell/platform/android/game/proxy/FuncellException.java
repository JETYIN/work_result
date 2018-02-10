package com.funcell.platform.android.game.proxy;

public class FuncellException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * Constructs a new FuncellException.
     */
    public FuncellException() {
        super();
    }

    /**
     * Constructs a new FuncellException.
     *
     * @param message the detail message of this exception
     */
    public FuncellException(String message) {
        super(message);
    }

    /**
     * Constructs a new FuncellException.
     *
     * @param format the format string (see {@link java.util.Formatter#format})
     * @param args   the list of arguments passed to the formatter.
     */
    public FuncellException(String format, Object... args) {
        this(String.format(format, args));
    }

    /**
     * Constructs a new FuncellException.
     *
     * @param message   the detail message of this exception
     * @param throwable the cause of this exception
     */
    public FuncellException(String message, Throwable throwable) {
        super(message, throwable);
    }

    /**
     * Constructs a new FuncellException.
     *
     * @param throwable the cause of this exception
     */
    public FuncellException(Throwable throwable) {
        super(throwable);
    }

    @Override
    public String toString() {
        // Throwable.toString() returns "FuncellException:{message}". Returning just "{message}"
        // should be fine here.
        return getMessage();
    }
	
}
