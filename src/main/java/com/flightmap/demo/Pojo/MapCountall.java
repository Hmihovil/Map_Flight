package com.flightmap.demo.Pojo;

import java.util.Date;

public class MapCountall {
    private Long flightDataId;

    private String icao;

    private String cid;

    private String n;

    private Double lo;

    private Double la;

    private Integer ang;

    private Integer alt;

    private Integer gs;

    private String tc;

    private Integer t;

    private String modNumber;

    private String dep;

    private String arr;

    private Date createTime;

    private Date updateTime;

    public MapCountall(Long flightDataId, String icao, String cid, String n, Double lo, Double la, Integer ang, Integer alt, Integer gs, String tc, Integer t, String modNumber, String dep, String arr, Date createTime, Date updateTime) {
        this.flightDataId = flightDataId;
        this.icao = icao;
        this.cid = cid;
        this.n = n;
        this.lo = lo;
        this.la = la;
        this.ang = ang;
        this.alt = alt;
        this.gs = gs;
        this.tc = tc;
        this.t = t;
        this.modNumber = modNumber;
        this.dep = dep;
        this.arr = arr;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public MapCountall( String icao, String cid, String n, Double lo, Double la, Integer ang, Integer alt, Integer gs, String tc, Integer t, String modNumber, String dep, String arr) {

        this.icao = icao;
        this.cid = cid;
        this.n = n;
        this.lo = lo;
        this.la = la;
        this.ang = ang;
        this.alt = alt;
        this.gs = gs;
        this.tc = tc;
        this.t = t;
        this.modNumber = modNumber;
        this.dep = dep;
        this.arr = arr;

    }

    public MapCountall() {
        super();
    }

    public Long getFlightDataId() {
        return flightDataId;
    }

    public void setFlightDataId(Long flightDataId) {
        this.flightDataId = flightDataId;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao == null ? null : icao.trim();
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n == null ? null : n.trim();
    }

    public Double getLo() {
        return lo;
    }

    public void setLo(Double lo) {
        this.lo = lo;
    }

    public Double getLa() {
        return la;
    }

    public void setLa(Double la) {
        this.la = la;
    }

    public Integer getAng() {
        return ang;
    }

    public void setAng(Integer ang) {
        this.ang = ang;
    }

    public Integer getAlt() {
        return alt;
    }

    public void setAlt(Integer alt) {
        this.alt = alt;
    }

    public Integer getGs() {
        return gs;
    }

    public void setGs(Integer gs) {
        this.gs = gs;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc == null ? null : tc.trim();
    }

    public Integer getT() {
        return t;
    }

    public void setT(Integer t) {
        this.t = t;
    }

    public String getModNumber() {
        return modNumber;
    }

    public void setModNumber(String mod) {
        this.modNumber = mod == null ? null : mod.trim();
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep == null ? null : dep.trim();
    }

    public String getArr() {
        return arr;
    }

    public void setArr(String arr) {
        this.arr = arr == null ? null : arr.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}