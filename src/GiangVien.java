public class GiangVien extends CanBo {
    private int soNamGiangDay;
    private long phuCap;

    public GiangVien(String t, String e, long s, String d, int h, String l, int so, long p){
        super(t, e, l, d, h, s);
        soNamGiangDay = so;
        phuCap = p;

    }

    @Override
    public long tinhLuong(){
        long luong = super.tinhLuong();
        luong += soNamGiangDay*phuCap;
        return luong;
    }
    @Override
    public String toString() {
        return ("Ten can bo: " + getTen() + " Email: " + getEmail() + " Sdt: "+ getSdt() + " Don vi: "+ getDonVi() + " He so luong: "+ getHeSoLuong() + " Luong moi: "+ tinhLuong() + "");

    }



}
