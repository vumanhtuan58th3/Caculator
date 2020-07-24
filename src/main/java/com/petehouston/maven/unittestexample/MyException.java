package IdeaProjects.UnitTestExample.src.main.java.com.petehouston.maven.unittestexample;

public class MyException extends Exception {
    private String error;

    public MyException(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
