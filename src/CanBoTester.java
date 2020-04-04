import java.util.Scanner;

public class CanBoTester {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        LopCanBo l = new LopCanBo();
        int soNamGiangDay;
        long phuCap;
        int act;
        long mucPhuCap;
        CanBo b = null;
        do{
            System.out.println("\nChon thao tac: \n1. Them moi can bo\n2. Tinh Luong \n3. Hien thi thong tin \n4. Thoat");
            act = (int) checkInput(1, 4);
            if (act == 1) {
                System.out.println("Chon \n1.Can bo\n2.Giang vien\n3.Can bo quan ly");
                int choice = (int) checkInput(1, 3);
                if(choice == 1){
                    b = new CanBo(nhapTen(), nhapEmail(), nhapSdt(), nhapDonVi(), nhapHeSoLuong(), nhapLuongChinh());
                }
                else if(choice == 2){
                    System.out.print("Nhap so nam giang day: ");
                    soNamGiangDay = (int) checkInput(1, 100);
                    System.out.print("Nhap phu cap: ");
                    phuCap = checkInput(1, Long.MAX_VALUE);

                    b = new GiangVien(nhapTen(), nhapEmail(), nhapLuongChinh(), nhapDonVi(), nhapHeSoLuong(), nhapSdt(), soNamGiangDay, phuCap);
                }
                else if (choice == 3){
                    System.out.print("Nhap muc phu cap: ");
                    mucPhuCap = checkInput(1, Long.MAX_VALUE);
                    b = new CanBoQuanLy(nhapTen(), nhapEmail(), nhapSdt(), nhapDonVi(), nhapHeSoLuong(), nhapLuongChinh(), (int) mucPhuCap);
                }
                l.add(b);
            }
            else if (act == 2){
                System.out.print("Nhap ten can bo: ");
                scan.nextLine();
                String ten = scan.nextLine();
                CanBo t = l.timTheoTen(ten);
                System.out.println("Luong can bo " + ten + ": " + t.tinhLuong());

                /*for (CanBo x: l){
                    if (x.getTen().equalsIgnoreCase(ten)){

                    }
                }*/

            }
            else if (act == 3){
                l.show();
            }

        } while (act != 4);
        return;
    }
    private static String nhapTen() {
        System.out.print("Nhap ten: ");
        scan.nextLine();
        String ten = scan.nextLine();
        return ten;
    }

    private static String nhapEmail() {
        String email = CanBo.checkEmail();
        return email;
    }

    private static String nhapSdt() {
        System.out.print("Nhap sdt (Vd: +84 904 357 899): ");
        String sdt = CanBo.checkPhoneNum();
        return sdt;
    }

    private static String nhapDonVi() {
        System.out.print("Nhap don vi: ");
        scan.nextLine();
        String donVi = scan.nextLine();
        return donVi;
    }

    private static int nhapHeSoLuong() {
        System.out.print("Nhap he so luong: ");
        int heSoLuong = (int) checkInput(1, Integer.MAX_VALUE);
        return heSoLuong;
    }

    private static long nhapLuongChinh(){
        System.out.print("Nhap luong chinh: ");
        long luongChinh = checkInput(1, Integer.MAX_VALUE);
        return luongChinh;

    }

    public static long checkInput(long a, long b){
        try{
            int choice = scan.nextInt();
            while (choice<a || choice>b) {
                System.out.print("Du lieu nhap khong phu hop. Vui long nhap lai: ");
                choice = scan.nextInt();
            }
            return choice;
        } catch (Exception e){
            System.out.print("Du lieu nhap khong phu hop. Vui long nhap lai");
            return checkInput(a, b);

        }

    }

    //CanBo canBo = new CanBo(ten, email, sdt, donVi, heSoLuong, luongChinh);
    //return canBo;
}
