package com.example.tugasprak03.Data;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private Integer id;
    private String username;
    private Integer profilePic;
    private Integer followers;
    private Integer following;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String usernamame) {
        this.username = usernamame;
    }

    public Integer getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(Integer profilePic) {
        this.profilePic = profilePic;
    }

    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    public Integer getFollowing() {
        return following;
    }

    public void setFollowing(Integer following) {
        this.following = following;
    }

    public User(Integer id, Integer profilePic, String usernamame, Integer followers, Integer following){
        this.id = id;
        this.profilePic = profilePic;
        this.username = usernamame;
        this.followers = followers;
        this.following = following;
    }

    protected User(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        username = in.readString();
        if (in.readByte() == 0) {
            profilePic = null;
        } else {
            profilePic = in.readInt();
        }
        if (in.readByte() == 0) {
            followers = null;
        } else {
            followers = in.readInt();
        }
        if (in.readByte() == 0) {
            following = null;
        } else {
            following = in.readInt();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(username);
        if (profilePic == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(profilePic);
        }
        if (followers == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(followers);
        }
        if (following == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(following);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

}
