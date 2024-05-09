package com.example.tugasprak03.Data;

import android.os.Parcel;
import android.os.Parcelable;

public class DataClass implements Parcelable {
    private Integer id;
    private Integer userId;
    private Integer postPic;
    private String postDesc;

    public Integer getPostPic() {
        return postPic;
    }

    public void setPostPic(Integer postPic) {
        this.postPic = postPic;
    }

    public String getPostDesc() {
        return postDesc;
    }

    public void setPostDesc(String postDesc) {
        this.postDesc = postDesc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public DataClass(Integer id, Integer postPic, String postDesc, Integer userId){
        this.id = id;
        this.postPic = postPic;
        this.postDesc = postDesc;
        this.userId = userId;
    }

    protected DataClass(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        if (in.readByte() == 0) {
            userId = null;
        } else {
            userId = in.readInt();
        }
        if (in.readByte() == 0) {
            postPic = null;
        } else {
            postPic = in.readInt();
        }
        postDesc = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        if (userId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(userId);
        }
        if (postPic == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(postPic);
        }
        dest.writeString(postDesc);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DataClass> CREATOR = new Creator<DataClass>() {
        @Override
        public DataClass createFromParcel(Parcel in) {
            return new DataClass(in);
        }

        @Override
        public DataClass[] newArray(int size) {
            return new DataClass[size];
        }
    };

}