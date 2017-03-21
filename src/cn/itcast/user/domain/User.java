package cn.itcast.user.domain;

/**
 * Created by winsion on 2017/3/17.
 */

/**
 *  µÃÂ¿‡
 */
public class User {
    private String userName;
    private String passWord;
    private String verifyCode;

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }



    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", verifyCode='" + verifyCode + '\'' +
                '}';
    }
}
