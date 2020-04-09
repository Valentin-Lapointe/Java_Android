package com.uldev.javangers.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/*public class UserModel implements Parcelable {

    // Parametres
    public int id;
    public Date creationDate;
    public String login;
    public String password;
    public Integer administrationRight = null;
    public Date lastModificationDate = null;
    public Integer id_Civil = null;

    //Constructeur
    public UserModel(){

    }

    public UserModel(ResultSet result) throws SQLException {
        this.id = result.getInt("Id");
        this.creationDate = result.getDate("CreationDate");
        this.login = result.getString("Login");
        this.password = result.getString("Password");
        this.administrationRight = result.getInt("AdministrationRight");
        this.lastModificationDate = result.getDate("LastModificationDate");
        this.id_Civil = result.getInt("FK_Civil");

    }

    @Override
    public int describeContents() {
        return 0;
    }

    protected UserModel(Parcel in) {
        id = in.readInt();
        creationDate = (Date) in.readSerializable();
        login = in.readString();
        password = in.readString();
        administrationRight = in.readInt();
        lastModificationDate = (Date) in.readSerializable();
        id_Civil = in.readInt();
    }

        @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(id);
        parcel.writeSerializable(creationDate);
        parcel.writeString(login);
        parcel.writeString(password);
        parcel.writeInt(administrationRight);
        parcel.writeSerializable(lastModificationDate);
        parcel.writeInt(id_Civil);
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };
}*/

public class UserModel implements Parcelable {

    // Parametres
    public int id;
    public Date creationDate;
    public String login;
    public String password;
    public Integer administrationRight = null;
    public Date lastModificationDate = null;
    public Integer id_Civil = null;

    public UserModel(ResultSet result) throws SQLException {
        this.id = result.getInt("Id");
        this.creationDate = result.getDate("CreationDate");
        this.login = result.getString("Login");
        this.password = result.getString("Password");
        this.administrationRight = result.getInt("AdministrationRight");
        this.lastModificationDate = result.getDate("LastModificationDate");
        this.id_Civil = result.getInt("FK_Civil");

    }

    protected UserModel(Parcel in) {
        id = in.readInt();
        long tmpCreationDate = in.readLong();
        creationDate = tmpCreationDate != -1 ? new Date(tmpCreationDate) : null;
        login = in.readString();
        password = in.readString();
        administrationRight = in.readByte() == 0x00 ? null : in.readInt();
        long tmpLastModificationDate = in.readLong();
        lastModificationDate = tmpLastModificationDate != -1 ? new Date(tmpLastModificationDate) : null;
        id_Civil = in.readByte() == 0x00 ? null : in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeLong(creationDate != null ? creationDate.getTime() : -1L);
        dest.writeString(login);
        dest.writeString(password);
        if (administrationRight == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(administrationRight);
        }
        dest.writeLong(lastModificationDate != null ? lastModificationDate.getTime() : -1L);
        if (id_Civil == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(id_Civil);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<UserModel> CREATOR = new Parcelable.Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };
}
