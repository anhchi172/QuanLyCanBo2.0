import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CanBo {
    private static Scanner scan = new Scanner(System.in);
    private String ten;
    private String email;
    private String sdt;
    private String donVi;
    private int heSoLuong;
    private long luongToiThieu;

    public CanBo(String t, String e, String s, String d, int h, long l){
        ten = t;
        email = e;
        sdt = s;
        donVi = d;
        heSoLuong = h;
        luongToiThieu = l;
    }




    public long tinhLuong(){
        long luongChinh = luongToiThieu * heSoLuong;
        return luongChinh;

    }



    static String checkEmail(){
        String email;
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        boolean valid= false;
        do {
            System.out.print("Nhap email: ");
            email = scan.nextLine();
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()){
                valid = true;
            }
            else{
                System.out.println("Email ko phu hop. Vui long nhap lai.");
            }
        } while (valid != true);
        return email;

    }

    static String checkPhoneNum() {
        boolean valid = false;
        String regex = "^\\+(?:[0-9] ?){6,14}[0-9]$";
        Pattern pattern = Pattern.compile(regex);
        String sdt;
        do {
            sdt = scan.nextLine();
            Matcher matcher = pattern.matcher(sdt);
            if (matcher.matches())
                valid = true;
            else
                System.out.print("Sdt ko phu hop. Vui long nhap lai: ");
        } while (valid != true);
        return sdt;
    }

    public String getTen() {
        return ten;
    }

    public String getEmail() {
        return email;
    }

    public String getDonVi() {
        return donVi;
    }

    public String getSdt() {
        return sdt;
    }

    public int getHeSoLuong() {
        return heSoLuong;
    }

    public long getLuongToiThieu() {
        return luongToiThieu;
    }

    @Override
    public String toString() {
        return ("Ten can bo: " + ten + " Email: " + email + " Sdt: "+ sdt + " Don vi: "+ donVi + " He so luong: "+ heSoLuong + " Luong chinh: "+ tinhLuong());
    }
}
