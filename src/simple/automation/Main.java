package simple.automation;

public class Main {

    private static final String EXISTED_USER = "existed";
    private static final String NOT_EXISTED_USER = "wrong";

    private Integer test = 1;
    public static void main(String[] args) {
	// write your code here
    }

    private  boolean loginAs(String login, String password) {;

        if (login.equals(EXISTED_USER)){
            return true;
        }

        return false;
    }


}
