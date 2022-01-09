package bean;

public class User {

	private String user_account;
    private String password;
    private String identity;

    public String getUserAccount() {
        return user_account;
    }

    public void setUserAcount(String user_account) {
        this.user_account =user_account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserIdentity() {
        return identity;
    }

    public void setUserIdentity(String identity) {
        this.identity =identity;
    }
}
