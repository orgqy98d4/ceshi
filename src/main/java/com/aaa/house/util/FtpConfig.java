package com.aaa.house.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Local com.example.demo4.util
 * @Author ZongKeLi
 * @Date 2019/07/27  16:26
 * @Version 1.0
 */
@Component
//读取配置文件
@PropertySource("classpath:config.properties")
//加载前缀以ftp开头的配置文件
@ConfigurationProperties(prefix = "ftp")
public class FtpConfig {
    private String remoteIp;
    private int uploadPort;
    private String ftpUserName;
    private String ftpPassWord;
    private String remotePath;
    private String localPath;
    private String downLoadPath;

    public String getRemoteIp() {
        return remoteIp;
    }

    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp;
    }

    public int getUploadPort() {
        return uploadPort;
    }

    public void setUploadPort(int uploadPort) {
        this.uploadPort = uploadPort;
    }

    public String getFtpUserName() {
        return ftpUserName;
    }

    public void setFtpUserName(String ftpUserName) {
        this.ftpUserName = ftpUserName;
    }

    public String getFtpPassWord() {
        return ftpPassWord;
    }

    public void setFtpPassWord(String ftpPassWord) {
        this.ftpPassWord = ftpPassWord;
    }

    public String getRemotePath() {
        return remotePath;
    }

    public void setRemotePath(String remotePath) {
        this.remotePath = remotePath;
    }

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }

    public String getDownLoadPath() {
        return downLoadPath;
    }

    public void setDownLoadPath(String downLoadPath) {
        this.downLoadPath = downLoadPath;
    }

    @Override
    public String toString() {
        return "FtpConfig{" +
                "remoteIp='" + remoteIp + '\'' +
                ", uploadPort=" + uploadPort +
                ", ftpUserName='" + ftpUserName + '\'' +
                ", ftpPassWord='" + ftpPassWord + '\'' +
                ", remotePath='" + remotePath + '\'' +
                ", localPath='" + localPath + '\'' +
                ", downLoadPath='" + downLoadPath + '\'' +
                '}';
    }
}
