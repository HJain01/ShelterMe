package io.github.seibelsabrina.shelterme.Model;

/**
 * Created by Tanya on 2/22/18.
 */

public class Admin {
    public String _firstName;
    public String _lastName;
    public String _userName;
    public String _passWord;

    public String getFirstName() {
        return _firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public String getuserName() {
        return _userName;
    }

    public String getpassWord() {
        return _passWord;
    }

    public void setfirstName(String firstName) {
        _firstName = firstName;
    }

    public void setlastName(String lastName) {
        _lastName = lastName;
    }

    public void setuserName(String userName) {
        _userName = userName;
    }

    public void setpassWord(String passWord) {
        _passWord = passWord;
    }

    public Admin(String firstName, String lastName, String userName, String passWord) {
        _firstName = firstName;
        _lastName = lastName;
        _userName = userName;
        _passWord = passWord;
    }

    public Admin() {
        this("", "", "", "");
    }
}
