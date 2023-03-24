package entity;

public class User {
    private int uid;
    private String username;
    private String email;
    private String pwd;
    private String tel;
    private String addr;
    private String gender;

    public User(){

    }

    public User(int uid, String username, String email, String pwd, String tel, String addr, String gender) {
        this.uid = uid;
        this.username = username;
        this.email = email;
        this.pwd = pwd;
        this.tel = tel;
        this.addr = addr;
        this.gender = gender;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPwd() {
        return pwd;
    }

    public String getTel() {
        return tel;
    }

    public String getAddr() {
        return addr;
    }

    public String getGender() {
        return gender;
    }
}
