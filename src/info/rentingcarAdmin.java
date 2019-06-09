package info;

public class rentingcarAdmin {
//    ID number(8) default thuexe_id_seq.nextVal constraint PK_TX primary key,
//    ID_KH number(8) not null,
//    ID_NV number(8) not null,
//    NGNHAP date,
//    TONGGIA number(12,2),
//    PT_THANHTOAN varchar2(10)
//    constraint PT_TT_TX_ck check(PT_THANHTOAN in ('tien mat','the'))

    public String id;
    public  String id_kh;
    public  String id_nv;
    public   String ngNhap;
    public  String TongGia;
    public  String PTThanhToan;

    public rentingcarAdmin(){}

    public rentingcarAdmin(String id,String id_kh,String id_nv,String ngNhap,String TongGia,String PTThanhToan){
       this.id=id;
       this.id_kh=id_kh;
       this.id_nv=id_nv;
       this.ngNhap=ngNhap;
       this.TongGia=TongGia;
       this.PTThanhToan=PTThanhToan;
    }


}
