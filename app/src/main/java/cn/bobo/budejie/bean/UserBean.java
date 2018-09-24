package cn.bobo.budejie.bean;

/**
 * Created by Leon on 2018/9/24.
 * Functions: 用户登陆model
 */
public class UserBean {

    /**
     * code : 300
     * message : 密码由6-16位数字、字母组成
     */

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


//    private String username;
//    private String password;
//    private String sex;
//    private String content;
//
//    public UserBean(String username, String password, String sex, String content) {
//        super();
//        this.username = username;
//        this.password = password;
//        this.sex = sex;
//        this.content = content;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getSex() {
//        return sex;
//    }
//
//    public void setSex(String sex) {
//        this.sex = sex;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }

}
