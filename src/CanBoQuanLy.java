public class CanBoQuanLy extends CanBo {
    private int mucPhuCap;
    public CanBoQuanLy(String t, String e, String s, String d, int h, long l, int m){
        super(t, e, s, d, h, l);
        mucPhuCap = m;

    }

    @Override
    public long tinhLuong(){
        long luong = super.tinhLuong();
        luong += mucPhuCap;
        return luong;
    }

    @Override
    public String toString() {
        return ("Ten can bo: " + getTen() + " Email: " + getEmail() + " Sdt: "+ getSdt() + " Don vi: "+ getDonVi() + " He so luong: "+ getHeSoLuong() + " Luong moi: "+ tinhLuong() + "");

    }
}
