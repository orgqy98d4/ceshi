package com.aaa.house.entity;

public class Employee {
    private Integer id;//员工主键

    private Integer enumber;//员工编号

    private String ename;//员工姓名

    private String ephone;//员工手机号

    private Integer stateid;//员工在职状态

    private Integer roleid;//角色id

    private String eusername;//员工后台登陆账号

    private String epassword;//员工后台登陆原始密码

    private String credentials;//加密后的密码

    private String email;//员工邮箱

    private String eqq;//员工qq号码

    private String eaddress;//员工家庭住址

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEnumber() {
        return enumber;
    }

    public void setEnumber(Integer enumber) {
        this.enumber = enumber;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    public String getEphone() {
        return ephone;
    }

    public void setEphone(String ephone) {
        this.ephone = ephone == null ? null : ephone.trim();
    }

    public Integer getStateid() {
        return stateid;
    }

    public void setStateid(Integer stateid) {
        this.stateid = stateid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getEusername() {
        return eusername;
    }

    public void setEusername(String eusername) {
        this.eusername = eusername == null ? null : eusername.trim();
    }

    public String getEpassword() {
        return epassword;
    }

    public void setEpassword(String epassword) {
        this.epassword = epassword == null ? null : epassword.trim();
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials == null ? null : credentials.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getEqq() {
        return eqq;
    }

    public void setEqq(String eqq) {
        this.eqq = eqq == null ? null : eqq.trim();
    }

    public String getEaddress() {
        return eaddress;
    }

    public void setEaddress(String eaddress) {
        this.eaddress = eaddress == null ? null : eaddress.trim();
    }
}