package info;

import java.util.Date;

public class employee {

//    ID number(8,0) not null constraint PK_NV primary key,
//    HO varchar2(30),
//    TEN varchar2(15),
//    USERID varchar2(15) unique,
//    PASS varchar2(15) unique,
//    NGVAOLAM date,
//    MAQL number(8,0),
//    CHUCVU varchar2(30),
//    MA_PHONG number(4),
//    LUONG number(10,2),
//    TIENHOAHONG number(4,2)
    public String ID;
    public String HO;
    public   String Ten;
    public   String userID;
    public  String Pass;
    public  String NgayVaoLam;
    public   String MaQL;
    public   String ChucVu;
    public   String MaPhong;
    public   String Luong;
    public   String TienHoaHong;
    public employee(){}
   public employee(String id,String ho,String ten,String userid,String pass,String ngay,String maql,String chucvu,String maphong,String luong,String tienhoahong){
            ID=id;
            HO=ho;
            Ten=ten;
            userID=userid;
           Pass=pass;
           NgayVaoLam=ngay;
            MaQL=maql;
            ChucVu=chucvu;
            MaPhong=maphong;
            Luong=luong;
            TienHoaHong=tienhoahong;
    }

    public  String getID(){
        return this.ID;
    }
    public  String getHo(){
        return this.HO;
    }
    public  String getTen(){
        return this.Ten;
    }

    public  String getUserID(){
        return this.userID;
    }

    public void xuat(){
        System.out.println(this.HO + " " + this.Ten +" " +this.userID + " "+this.MaQL + " " + this.MaPhong +" " +this.Luong + " "+this.NgayVaoLam );
    }






}
