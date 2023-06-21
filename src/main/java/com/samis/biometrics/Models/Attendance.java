package com.samis.biometrics.Models;

public class Attendance {
//    int id;
    String id,name,adm,form,gender,adm_year,check_in,check_out;
    public Attendance(int id, String name, String adm, String form, String gender, String adm_year, String check_in, String check_out) {
        this.id = String.valueOf(id);
        this.name = name;
        this.adm = adm;
        this.form = form;
        this.gender = gender;
        this.adm_year = adm_year;
        this.check_in = check_in;
        this.check_out = check_out;
    }
//    Setters
    public void setId(String id) {this.id = id;}
    public void setName(String name) {
        this.name = name;
    }
    public void setAdm(String adm) {this.adm = adm;}
    public void setForm(String form) {
        this.form = form;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setAdm_year(String adm_year) {
        this.adm_year = adm_year;
    }
    public void setCheck_in(String check_in) {this.check_in = check_in;}
    public void setCheck_out(String check_out) {this.check_out = check_out;}

//    Getters
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getAdm() {
        return adm;
    }

    public String getForm() {
        return form;
    }

    public String getGender() {
        return gender;
    }

    public String getAdm_year() {
        return adm_year;
    }
    public String getCheck_in() {return check_in;}
    public String getCheck_out() {return check_out;}
}
