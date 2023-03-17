package classes;
public class Admin {
    private String gmail;
    private String password;
    public Admin(String gmail, String password) {
        this.gmail = gmail;
        this.password = password;
    }
    public String getGmail() {
        return gmail;
    }
    public void setGmail(String gmail) throws Exception {
        if (!gmail.equals("halikova656@gmail.com")){
            throw new Exception("Your email address is not valid");
        }
        this.gmail = gmail;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) throws Exception {
        if (!password.equals("Madina")){
            throw new Exception("Your password is incorrect!");
        }
        this.password = password;
    }
    @Override
    public String toString() {
        return "Admin{" +
                "gmail='" + gmail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
