package Tuan3.Bai5HTPham;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HangThucPham {
	
	
	private final String maHang; 
	private String tenHang;
	private double donGia;
	private LocalDate ngaySanXuat;
	private LocalDate ngayHetHan;

	
	public HangThucPham(String maHang) throws Exception {
		if (maHang == null || maHang.trim().equals("")) {
			throw new Exception("Lỗi: Mã hàng không được để rỗng!");
		}
		this.maHang = maHang;
		this.tenHang = "xxx";
		this.donGia = 0;
		this.ngaySanXuat = LocalDate.now();
		this.ngayHetHan = LocalDate.now();
	}

	public HangThucPham(String maHang, String tenHang, double donGia, LocalDate ngaySanXuat, LocalDate ngayHetHan) throws Exception {
		if (maHang == null || maHang.trim().equals("")) {
			throw new Exception("Lỗi: Mã hàng không được để rỗng!");
		}
		this.maHang = maHang;
		setTenHang(tenHang);
		setDonGia(donGia);
		setNgaySanXuat(ngaySanXuat);
		setNgayHetHan(ngayHetHan);
	}

	/**
	 * @return the maHang
	 */
	public String getMaHang() {
		return maHang;
	}

	/**
	 * @return the tenHang
	 */
	public String getTenHang() {
		return tenHang;
	}

	/**
	 * @param tenHang the tenHang to set
	 */
	public void setTenHang(String tenHang) {
		if (tenHang == null || tenHang.trim().equals("")) {
			this.tenHang = "xxx";
		} else {
			this.tenHang = tenHang;
		}
	}

	/**
	 * @return the donGia
	 */
	public double getDonGia() {
		return donGia;
	}

	/**
	 * @param donGia the donGia to set
	 */
	public void setDonGia(double donGia) {
		if (donGia >= 0) {
			this.donGia = donGia;
		} else {
			this.donGia = 0;
		}
	}

	/**
	 * @return the ngaySanXuat
	 */
	public LocalDate getNgaySanXuat() {
		return ngaySanXuat;
	}

	/**
	 * @param ngaySanXuat the ngaySanXuat to set
	 */
	public void setNgaySanXuat(LocalDate ngaySanXuat) {
		if (ngaySanXuat != null && ngaySanXuat.isBefore(LocalDate.now())) {
			this.ngaySanXuat = ngaySanXuat;
		} else {
			this.ngaySanXuat = LocalDate.now();
		}
	}

	/**
	 * @return the ngayHetHan
	 */
	public LocalDate getNgayHetHan() {
		return ngayHetHan;
	}

	/**
	 * @param ngayHetHan the ngayHetHan to set
	 */
	public void setNgayHetHan(LocalDate ngayHetHan) {
		if (ngayHetHan != null && ngayHetHan.isAfter(this.ngaySanXuat)) {
			this.ngayHetHan = ngayHetHan;
		} else {
			this.ngayHetHan = this.ngaySanXuat;
		}
	}

	
	public boolean hetHan() {
		return ngayHetHan.isBefore(LocalDate.now());
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00VND");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String ghiChu = hetHan() ? "Hàng hết hạn" : "";

		return String.format("%-10s %-15s %-18s %-15s %-15s %-15s", 
				maHang, tenHang, df.format(donGia), dtf.format(ngaySanXuat), dtf.format(ngayHetHan), ghiChu);
	}

	public static void main(String[] args) {
		System.out.format("%-10s %-15s %-18s %-15s %-15s %-15s\n", 
				"Mã_Hàng", "Tên_Hàng", "Đơn_Giá", "Ngày_Sản_Xuất", "Ngày_Hết_Hạn", "Ghi_Chú");
		System.out.println("-------------------------------------------------------------------------------------------------");

		try {
		
			HangThucPham h1 = new HangThucPham("001", "Gạo", 100000, LocalDate.of(2018, 7, 10), LocalDate.of(2018, 7, 10));
			HangThucPham h2 = new HangThucPham("002", "Mì", 5000, LocalDate.of(2018, 3, 1), LocalDate.of(2018, 9, 1));
			HangThucPham h3 = new HangThucPham("003", "Nước", 10000, LocalDate.of(2017, 3, 1), LocalDate.of(2018, 3, 1));

			System.out.println(h1);
			System.out.println(h2);
			System.out.println(h3);

			System.out.println("\n--- Thử nghiệm kiểm tra ràng buộc lỗi ---");
			HangThucPham hLoi = new HangThucPham(""); 
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
