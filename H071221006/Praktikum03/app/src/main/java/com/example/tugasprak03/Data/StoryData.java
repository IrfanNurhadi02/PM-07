package com.example.tugasprak03.Data;

import android.os.Parcel;
import android.os.Parcelable;

public class StoryData implements Parcelable {
    private Integer id;
    private Integer userId;
    private Integer storyPic;

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

    public Integer getStoryPic() {
        return storyPic;
    }

    public void setStoryPic(Integer storyPic) {
        this.storyPic = storyPic;
    }

    public StoryData(Integer id, Integer storyPic, Integer userId){
        this.id = id;
        this.storyPic = storyPic;
        this.userId = userId;
    }

    protected StoryData(Parcel in) {
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
            storyPic = null;
        } else {
            storyPic = in.readInt();
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
        if (userId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(userId);
        }
        if (storyPic == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(storyPic);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<StoryData> CREATOR = new Creator<StoryData>() {
        @Override
        public StoryData createFromParcel(Parcel in) {
            return new StoryData(in);
        }

        @Override
        public StoryData[] newArray(int size) {
            return new StoryData[size];
        }
    };

}
