package com.example.praktikum3;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class ProfileModel implements Parcelable {
    private String username;
    private Integer profile;
    private Integer fotoStory;
    private String followers;
    private String following;
    private String name;
    private String bio;
    private Integer fotoPostingan;
    private String caption;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getProfile() {
        return profile;
    }

    public void setProfile(Integer profile) {
        this.profile = profile;
    }

    public Integer getFotoStory() {
        return fotoStory;
    }

    public void setFotoStory(Integer fotoStory) {
        this.fotoStory = fotoStory;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Integer getFotoPostingan() {
        return fotoPostingan;
    }

    public void setFotoPostingan(Integer fotoPostingan) {
        this.fotoPostingan = fotoPostingan;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public ProfileModel(String username, Integer profile, Integer fotoStory, String followers, String following, String name, String bio, Integer fotoPostingan, String caption) {
        this.username = username;
        this.profile = profile;
        this.fotoStory = fotoStory;
        this.followers = followers;
        this.following = following;
        this.name = name;
        this.bio = bio;
        this.fotoPostingan = fotoPostingan;
        this.caption = caption;
    }


    protected ProfileModel(Parcel in) {
        username = in.readString();
        if (in.readByte() == 0) {
            profile = null;
        } else {
            profile = in.readInt();
        }
        if (in.readByte() == 0) {
            fotoStory = null;
        } else {
            fotoStory = in.readInt();
        }
        followers = in.readString();
        following = in.readString();
        name = in.readString();
        bio = in.readString();
        if (in.readByte() == 0) {
            fotoPostingan = null;
        } else {
            fotoPostingan = in.readInt();
        }
        caption = in.readString();
    }

    public static final Creator<ProfileModel> CREATOR = new Creator<ProfileModel>() {
        @Override
        public ProfileModel createFromParcel(Parcel in) {
            return new ProfileModel(in);
        }

        @Override
        public ProfileModel[] newArray(int size) {
            return new ProfileModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(username);
        if (profile == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(profile);
        }
        if (fotoStory == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(fotoStory);
        }
        dest.writeString(followers);
        dest.writeString(following);
        dest.writeString(name);
        dest.writeString(bio);
        if (fotoPostingan == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(fotoPostingan);
        }
        dest.writeString(caption);
    }
}
