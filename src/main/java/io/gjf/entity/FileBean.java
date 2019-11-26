package io.gjf.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Creat by GuoJF on 19-11
 */
@Document(collection = "filebean")
public class FileBean {

    private String uuid;
    private String name;
    private String originalName;
    private String basePath;
    private String path;
    private String timestamps;

    public FileBean(String uuid, String name, String originalName, String basePath, String path, String timestamps) {
        this.uuid = uuid;
        this.name = name;
        this.originalName = originalName;
        this.basePath = basePath;
        this.path = path;
        this.timestamps = timestamps;
    }

    public FileBean() {
    }

    public FileBean(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(String timestamps) {
        this.timestamps = timestamps;
    }

    @Override
    public String toString() {
        return "FileBean{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", originalName='" + originalName + '\'' +
                ", basePath='" + basePath + '\'' +
                ", path='" + path + '\'' +
                ", timestamps='" + timestamps + '\'' +
                '}';
    }
}
