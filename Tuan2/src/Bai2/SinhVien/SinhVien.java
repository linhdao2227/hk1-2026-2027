package Bai2.SinhVien;
import java.util.Scanner;

public class SinhVien {
	private int maSV;
    private String hoTen;
    private double diemLT;
    private double diemTH;
    
    public SinhVien() {
        this.maSV = 1;
        this.hoTen = "Chua co ten";
        this.diemLT = 0.0;
        this.diemTH = 0.0;
    }
	/**
	 * @return the maSV
	 */
	public int getMaSV() {
		return maSV;
	}
	/**
	 * @param maSV the maSV to set
	 */
	public void setMaSV(int maSV) {
		if (maSV > 0) {
            this.maSV = maSV;
        } else {
            this.maSV = 1; 
        }
	}
	/**
	 * @return the hoTen
	 */
	public String getHoTen() {
		return hoTen;
	}
	/**
	 * @param hoTen the hoTen to set
	 */
	public void setHoTen(String hoTen) {
		if (hoTen != null && !hoTen.trim().isEmpty()) {
            this.hoTen = hoTen;
        } else {
            this.hoTen = "Chua co ten"; 
        }
	}
	/**
	 * @return the diemLT
	 */
	public double getDiemLT() {
		return diemLT;
	}
	/**
	 * @param diemLT the diemLT to set
	 */
	public void setDiemLT(double diemLT) {
		if (diemLT >= 0.0 && diemLT <= 10.0) {
            this.diemLT = diemLT;
        } else {
            this.diemLT = 0.0; 
        }
	}
	/**
	 * @return the diemTH
	 */
	public double getDiemTH() {
		return diemTH;
	}
	/**
	 * @param diemTH the diemTH to set
	 */
	public void setDiemTH(double diemTH) {
		if (diemTH >= 0.0 && diemTH <= 10.0) {
            this.diemTH = diemTH;
        } else {
            this.diemTH = 0.0;
        }
	}
	public double getTB() {
        return (diemLT + diemTH) / 2;
    }
	
	@Override
	public String toString() {
	    return String.format("%-10d %-25s %10.2f %10.2f %10.2f", 
	            maSV, hoTen, diemLT, diemTH, getTB());
	}
	
	public static void main(String[] args) {
	    SinhVien sv = nhap();

	    System.out.println(String.format("%-10s %-25s %10s %10s %10s", 
	            "masv", "hoten", "diemlt", "diemth", "diemtb"));
	            
	    
	    System.out.println(sv);
	}
	
	public static SinhVien nhap() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ma sinh vien: ");
        int maSV = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Nhap ho ten: ");
        String hoTen = sc.nextLine();

        System.out.print("Nhap diem ly thuyet (0-10): ");
        double diemLT = sc.nextDouble();

        System.out.print("Nhap diem thuc hanh (0-10): ");
        double diemTH = sc.nextDouble();

       
        SinhVien sv = new SinhVien();
        sv.setMaSV(maSV);
        sv.setHoTen(hoTen);
        sv.setDiemLT(diemLT);
        sv.setDiemTH(diemTH);
        return sv;
    }
	
   
}