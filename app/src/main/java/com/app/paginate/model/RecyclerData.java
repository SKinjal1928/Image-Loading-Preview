package com.app.paginate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RecyclerData {

    ArrayList<RecyclerDatum> list = new ArrayList();

    public ArrayList<RecyclerDatum> getList() {
        return list;
    }

    public void setList(ArrayList<RecyclerDatum> list) {
        this.list = list;
    }

    public class BackupDetails {

        @SerializedName("pdfLink")
        @Expose
        private String pdfLink;
        @SerializedName("screenshotURL")
        @Expose
        private String screenshotURL;

        public String getPdfLink() {
            return pdfLink;
        }

        public void setPdfLink(String pdfLink) {
            this.pdfLink = pdfLink;
        }

        public String getScreenshotURL() {
            return screenshotURL;
        }

        public void setScreenshotURL(String screenshotURL) {
            this.screenshotURL = screenshotURL;
        }

    }

    public class RecyclerDatum {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("language")
        @Expose
        private String language;
        @SerializedName("thumbnail")
        @Expose
        public Thumbnail thumbnail;
        @SerializedName("mediaType")
        @Expose
        private Integer mediaType;
        @SerializedName("coverageURL")
        @Expose
        private String coverageURL;
        @SerializedName("publishedAt")
        @Expose
        private String publishedAt;
        @SerializedName("publishedBy")
        @Expose
        private String publishedBy;
        @SerializedName("backupDetails")
        @Expose
        private BackupDetails backupDetails;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public Thumbnail getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(Thumbnail thumbnail) {
            this.thumbnail = thumbnail;
        }

        public Integer getMediaType() {
            return mediaType;
        }

        public void setMediaType(Integer mediaType) {
            this.mediaType = mediaType;
        }

        public String getCoverageURL() {
            return coverageURL;
        }

        public void setCoverageURL(String coverageURL) {
            this.coverageURL = coverageURL;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getPublishedBy() {
            return publishedBy;
        }

        public void setPublishedBy(String publishedBy) {
            this.publishedBy = publishedBy;
        }

        public BackupDetails getBackupDetails() {
            return backupDetails;
        }

        public void setBackupDetails(BackupDetails backupDetails) {
            this.backupDetails = backupDetails;
        }

    }
    public class Thumbnail {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("version")
        @Expose
        private Integer version;
        @SerializedName("domain")
        @Expose
        private String domain;
        @SerializedName("basePath")
        @Expose
        private String basePath;
        @SerializedName("key")
        @Expose
        private String key;
        @SerializedName("qualities")
        @Expose
        private ArrayList<Integer> qualities;
        @SerializedName("aspectRatio")
        @Expose
        private Integer aspectRatio;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Integer getVersion() {
            return version;
        }

        public void setVersion(Integer version) {
            this.version = version;
        }

        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }

        public String getBasePath() {
            return basePath;
        }

        public void setBasePath(String basePath) {
            this.basePath = basePath;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public ArrayList<Integer> getQualities() {
            return qualities;
        }

        public void setQualities(ArrayList<Integer> qualities) {
            this.qualities = qualities;
        }

        public Integer getAspectRatio() {
            return aspectRatio;
        }

        public void setAspectRatio(Integer aspectRatio) {
            this.aspectRatio = aspectRatio;
        }

    }
}
