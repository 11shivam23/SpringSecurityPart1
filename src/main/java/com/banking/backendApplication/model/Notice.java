package com.banking.backendApplication.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noticeId;
    private String noticeSummary;
    private String noticeDetails;
    private Date noticeBegDt;
    private Date noticeEndDt;
    private Date createDt;
    private Date updateDt;

    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeSummary() {
        return noticeSummary;
    }

    public void setNoticeSummary(String noticeSummary) {
        this.noticeSummary = noticeSummary;
    }

    public String getNoticeDetails() {
        return noticeDetails;
    }

    public void setNoticeDetails(String noticeDetails) {
        this.noticeDetails = noticeDetails;
    }

    public Date getNoticeBegDt() {
        return noticeBegDt;
    }

    public void setNoticeBegDt(Date noticeBegDt) {
        this.noticeBegDt = noticeBegDt;
    }

    public Date getNoticeEndDt() {
        return noticeEndDt;
    }

    public void setNoticeEndDt(Date noticeEndDt) {
        this.noticeEndDt = noticeEndDt;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public Date getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }
}
