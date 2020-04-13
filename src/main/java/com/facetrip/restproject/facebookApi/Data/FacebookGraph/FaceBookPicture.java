package com.facetrip.restproject.facebookApi.Data.FacebookGraph;

public class FaceBookPicture {
    private PictureData data;

    public PictureData getData() {
        return data;
    }

    public void setData(PictureData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "FaceBookPicture{" +
                "data=" + data.toString() +
                '}';
    }
    class PictureData{
        private String width;
        private String height;
        private String url;

        public String getWidth() {
            return width;
        }

        public void setWidth(String width) {
            this.width = width;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "PictureData{" +
                    "width='" + width + '\'' +
                    ", height='" + height + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }
}
