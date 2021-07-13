package com.example.login;

public class Truyen {
    private String Tentruyen;
    private String Theloai;
    private int Hinh;
    private String Tacgia;
    private String Sochuong;
    private String NoiDung;
    private int Hinh1;
    private int Hinh2;
    private int Hinh3;
    private int Hinh4;

    public Truyen(String tentruyen, String theloai, int hinh, String tacgia, String sochuong, String noiDung,int hinh1,int hinh2,int hinh3,int hinh4) {
        Tentruyen = tentruyen;
        Theloai = theloai;
        Hinh = hinh;
        Tacgia = tacgia;
        Sochuong = sochuong;
        NoiDung = noiDung;
        Hinh1 = hinh1;
        Hinh2 = hinh2;
        Hinh3 = hinh3;
        Hinh4 = hinh4;
    }

    public String getTentruyen() {
        return Tentruyen;
    }

    public void setTentruyen(String tentruyen) {
        Tentruyen = tentruyen;
    }

    public String getTheloai() {
        return Theloai;
    }

    public void setTheloai(String theloai) {
        Theloai = theloai;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }

    public int getHinh1() {
        return Hinh1;
    }

    public void setHinh1(int hinh1) {
        Hinh1 = hinh1;
    }

    public int getHinh2() {
        return Hinh2;
    }

    public void setHinh2(int hinh2) {
        Hinh2 = hinh2;
    }

    public int getHinh3() {
        return Hinh3;
    }

    public void setHinh3(int hinh3) {
        Hinh3 = hinh3;
    }

    public int getHinh4() {
        return Hinh4;
    }

    public void setHinh4(int hinh4) {
        Hinh4 = hinh4;
    }

    public String getTacgia() {
        return Tacgia;
    }

    public void setTacgia(String tacgia) {
        Tacgia = tacgia;
    }

    public String getSochuong() {
        return Sochuong;
    }

    public void setSochuong(String sochuong) {
        Sochuong = sochuong;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
    }
}
