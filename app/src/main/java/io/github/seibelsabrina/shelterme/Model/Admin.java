package io.github.seibelsabrina.shelterme.Model;

import android.os.Parcel;
import android.os.Parcelable;

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


    private Admin(Parcel in) {
        _firstName = in.readString();
        _lastName = in.readString();
        _userName = in.readString();
        _passWord = in.readString();
    }


    public int describeContents() {
        return 0;
    }



    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(_firstName);
        dest.writeString(_lastName);
        dest.writeString(_userName);
        dest.writeString(_passWord);


    }

    /**
     * Should not have to edit this method if the constructor and write method are
     * working correctly.
     */
    public static final Parcelable.Creator<Admin> CREATOR
            = new Parcelable.Creator<Admin>() {
        public Admin createFromParcel(Parcel in) {
            return new Admin(in);
        }

        public Admin[] newArray(int size) {
            return new Admin[size];
        }
    };
}

