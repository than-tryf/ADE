package org.eclipse.camf.infosystem.mockup.info;


public class JCatascopiaProbeRepoException extends Exception {

    private static final long serialVersionUID = 1L;

    private String message = null;
     
    public JCatascopiaProbeRepoException() {
        super();
    }
     
    public JCatascopiaProbeRepoException (String message) {
        super(message);
        this.message = "JCatascopia: " + message;
    }
     
    public JCatascopiaProbeRepoException(Throwable cause) {
        super(cause);
    }
    
     
    @Override
    public String toString() {
        return message;
    }
     
    @Override
    public String getMessage() {
        return message;
    }
}