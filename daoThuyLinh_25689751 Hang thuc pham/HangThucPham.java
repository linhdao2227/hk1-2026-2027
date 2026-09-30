package daoThuyLinh_25689751;

import java.time.LocalDate;
public class HangThucPham implements Comparable<HangThucPham> {
	
	    private int id;
	    private final String maHang;       o
	    private String tenHang;
	    private LocalDate ngaySanXuat;
	    private LocalDate ngayHetHan;
	    private float gia;

	    private static int demSoLuong = 0;

	   
	    public HangThucPham() {
	        this.id = ++demSoLuong;
	        this.maHang = "MAC_DINH";
	        this.tenHang = "Hàng mặc định";
	        this.ngaySanXuat = LocalDate.now();
	        this.ngayHetHan = LocalDate.now().plusDays(7);
	        this.gia = 1.0f;
	    }

	   
	    public HangThucPham(String maHang, String tenHang, LocalDate ngaySanXuat, LocalDate ngayHetHan, float gia) {
	        this.id = ++demSoLuong;

	        if (maHang == null || maHang.trim().isEmpty())
	            throw new IllegalArgumentException("Mã hàng không được để trống!");
	        if (tenHang == null || tenHang.trim().isEmpty())
	            throw new IllegalArgumentException("Tên hàng không được để trống!");
	        if (gia <= 0)
	            throw new IllegalArgumentException("Giá phải lớn hơn 0!");
	        if (!kiemTraNgaySanXuat(ngaySanXuat))
	            throw new IllegalArgumentException("Ngày SX không được là tương lai!");
	        if (!kiemTraNgayHetHan(ngaySanXuat, ngayHetHan))
	            throw new IllegalArgumentException("Ngày HH phải sau ngày SX!");

	        this.maHang = maHang;
	        this.tenHang = tenHang;
	        this.ngaySanXuat = ngaySanXuat;
	        this.ngayHetHan = ngayHetHan;
	        this.gia = gia;
	    }

	  
	    private boolean kiemTraNgaySanXuat(LocalDate ngaySX) {
	        return ngaySX != null && !ngaySX.isAfter(LocalDate.now());
	    }

	    private boolean kiemTraNgayHetHan(LocalDate ngaySX, LocalDate ngayHH) {
	        return ngaySX != null && ngayHH != null && ngayHH.isAfter(ngaySX);
	    }

	   
	    public int getId() { return id; }
	    public String getMaHang() { return maHang; }
	    public String getTenHang() { return tenHang; }
	    public LocalDate getNgaySanXuat() { return ngaySanXuat; }
	    public LocalDate getNgayHetHan() { return ngayHetHan; }
	    public float getGia() { return gia; }

	   
	    public void setTenHang(String tenHang) {
	        if (tenHang == null || tenHang.trim().isEmpty())
	            throw new IllegalArgumentException("Tên hàng không được để rỗng!");
	        this.tenHang = tenHang;
	    }

	    public void setNgaySanXuat(LocalDate ngaySanXuat) {
	        if (!kiemTraNgaySanXuat(ngaySanXuat))
	            throw new IllegalArgumentException("Ngày SX không được tương lai!");
	        if (this.ngayHetHan != null && !kiemTraNgayHetHan(ngaySanXuat, this.ngayHetHan))
	            throw new IllegalArgumentException("Ngày SX phải trước ngày HH!");
	        this.ngaySanXuat = ngaySanXuat;
	    }

	    public void setNgayHetHan(LocalDate ngayHetHan) {
	        if (this.ngaySanXuat == null)
	            throw new IllegalArgumentException("Chưa có ngày SX!");
	        if (!kiemTraNgayHetHan(this.ngaySanXuat, ngayHetHan))
	            throw new IllegalArgumentException("Ngày HH phải sau ngày SX!");
	        this.ngayHetHan = ngayHetHan;
	    }

	    public void setGia(float gia) {
	        if (gia <= 0)
	            throw new IllegalArgumentException("Giá phải lớn hơn 0!");
	        this.gia = gia;
	    }

	    
	    public boolean kiemTraHetHan() {
	        return LocalDate.now().isAfter(this.ngayHetHan);
	    }

	    public String trangThaiChiTiet() {
	        LocalDate homNay = LocalDate.now();
	        if (homNay.isBefore(ngaySanXuat)) return "Chưa sản xuất";
	        if (homNay.isAfter(ngayHetHan)) return "Hết hạn";
	        if (homNay.isEqual(ngayHetHan)) return "Hết hạn hôm nay";
	        long con = ngayHetHan.toEpochDay() - homNay.toEpochDay();
	        return "Còn " + con + " ngày";
	    }

	    
	    @Override
	    protected Object clone() throws CloneNotSupportedException {
	        throw new CloneNotSupportedException("Không thể sao chép HangThucPham!");
	    }

	    @Override
	    public int compareTo(HangThucPham o) {
	        return Integer.compare(this.id, o.id);
	    }

	    @Override
	    public String toString() {
	        return String.format(
	            "| %-4d | %-10s | %-18s | %-12s | %-12s | %-10.0f |",
	            id, maHang, tenHang, ngaySanXuat, ngayHetHan, gia);
	    }
	}


