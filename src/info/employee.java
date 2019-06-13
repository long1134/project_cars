package info;

import java.util.Date;

public class employee {
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
}
