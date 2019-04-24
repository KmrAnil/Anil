package com.ak.gesture;

public class data {
    public String count;
    public String msg;
    public String imgurl;

    public data() {
    }

    public data(String count, String msg, String imgurl) {
        this.count = count;
        this.msg = msg;
        this.imgurl=imgurl;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }



    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
