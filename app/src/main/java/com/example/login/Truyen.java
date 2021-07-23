package com.example.login;

public class Truyen {
    private int Id;
    private String Tentruyen;
    private String Theloai;
    private byte[] Hinh;
    private String Tacgia;
    private String Sochuong;
    private String NoiDung;
    private byte[] Hinh1;
    private byte[] Hinh2;
    private byte[] Hinh3;
    private byte[] Hinh4;
    public Truyen(int id, String tentruyen, String theloai ,byte[]hinh, String tacgia, String sochuong, String noiDung,byte[]hinh1,byte[]hinh2,byte[]hinh3,byte[]hinh4) {
        Id = id;
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

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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
    public String getTacgia() {
        return Tacgia;
    }

    public byte[] getHinh() {
        return Hinh;
    }

    public void setHinh(byte[] hinh) {
        Hinh = hinh;
    }

    public byte[] getHinh1() {
        return Hinh1;
    }

    public void setHinh1(byte[] hinh1) {
        Hinh1 = hinh1;
    }

    public byte[] getHinh2() {
        return Hinh2;
    }

    public void setHinh2(byte[] hinh2) {
        Hinh2 = hinh2;
    }

    public byte[] getHinh3() {
        return Hinh3;
    }

    public void setHinh3(byte[] hinh3) {
        Hinh3 = hinh3;
    }

    public byte[] getHinh4() {
        return Hinh4;
    }

    public void setHinh4(byte[] hinh4) {
        Hinh4 = hinh4;
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
