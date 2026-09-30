package daoThuyLinh_25689751;

import java.time.LocalDate;

public class QuanLyThucPham {
    // ---------- Thuộc tính ----------
    private HangThucPham[] danhSach;    // Mảng nguyên thủy
    private int soLuong;                 // Số phần tử hiện có
    private int khaNang;                 // Sức chứa hiện tại

    private static final int KICH_THUOC_BAN_DAU = 5;

    // ---------- Constructor ----------
    public QuanLyThucPham() {
        this.khaNang = KICH_THUOC_BAN_DAU;
        this.danhSach = new HangThucPham[khaNang];
        this.soLuong = 0;
    }

    // ========== MỞ RỘNG MẢNG ==========
    private void moRongMang() {
        int kichThuocMoi = khaNang * 2;
        HangThucPham[] mangMoi = new HangThucPham[kichThuocMoi];
        for (int i = 0; i < soLuong; i++) {
            mangMoi[i] = danhSach[i];
        }
        danhSach = mangMoi;
        khaNang = kichThuocMoi;
        System.out.println("Đã mở rộng mảng lên " + khaNang + " phần tử.");
    }

    // ========== TÌM VỊ TRÍ THEO MÃ ==========
    public int timViTriTheoMa(String maHang) {
        for (int i = 0; i < soLuong; i++)
            if (danhSach[i].getMaHang().equalsIgnoreCase(maHang))
                return i;
        return -1;
    }

    // ========== TÌM VỊ TRÍ THEO ID ==========
    public int timViTriTheoId(int id) {
        for (int i = 0; i < soLuong; i++)
            if (danhSach[i].getId() == id) return i;
        return -1;
    }

    // ========== THÊM (chống trùng + tự mở rộng) ==========
    public boolean them(HangThucPham h) {
        if (timViTriTheoMa(h.getMaHang()) != -1) {
            System.out.println("Lỗi: Mã hàng '" + h.getMaHang() + "' đã tồn tại!");
            return false;
        }
        if (soLuong == khaNang) moRongMang();
        danhSach[soLuong] = h;
        soLuong++;
        return true;
    }

    // ========== XÓA THEO ID ==========
    public boolean xoa(int id) {
        int viTri = timViTriTheoId(id);
        if (viTri == -1) {
            System.out.println("Không tìm thấy hàng có id " + id);
            return false;
        }
        for (int i = viTri; i < soLuong - 1; i++) {
            danhSach[i] = danhSach[i + 1];
        }
        danhSach[soLuong - 1] = null;
        soLuong--;
        return true;
    }

    // ========== SỬA THEO ID ==========
    public boolean sua(int id, String tenMoi, LocalDate ngaySXMoi,
                        LocalDate ngayHHMoi, float giaMoi) {
        int viTri = timViTriTheoId(id);
        if (viTri == -1) {
            System.out.println("Không tìm thấy hàng có id " + id);
            return false;
        }
        HangThucPham h = danhSach[viTri];
        h.setTenHang(tenMoi);
        h.setNgaySanXuat(ngaySXMoi);
        h.setNgayHetHan(ngayHHMoi);
        h.setGia(giaMoi);
        return true;
    }

    // ========== TÌM THEO ID ==========
    public HangThucPham timTheoId(int id) {	
    	int viTri = timViTriTheoId(id);
        return (viTri == -1) ? null : danhSach[viTri];
    }

    // ========== SẮP XẾP THEO GIÁ ==========
    public void sapXepTheoGia(boolean tangDan) {
        for (int i = 0; i < soLuong - 1; i++) {
            for (int j = i + 1; j < soLuong; j++) {
                boolean canDoi = tangDan
                    ? danhSach[i].getGia() > danhSach[j].getGia()
                    : danhSach[i].getGia() < danhSach[j].getGia();
                if (canDoi) {
                    HangThucPham temp = danhSach[i];
                    danhSach[i] = danhSach[j];
                    danhSach[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp theo giá " + (tangDan ? "tăng dần" : "giảm dần"));
    }

    // ========== SẮP XẾP THEO NGÀY SẢN XUẤT ==========
    public void sapXepTheoNgaySanXuat(boolean tangDan) {
        for (int i = 0; i < soLuong - 1; i++) {
            for (int j = i + 1; j < soLuong; j++) {
                boolean canDoi = tangDan
                    ? danhSach[i].getNgaySanXuat().isAfter(danhSach[j].getNgaySanXuat())
                    : danhSach[i].getNgaySanXuat().isBefore(danhSach[j].getNgaySanXuat());
                if (canDoi) {
                    HangThucPham temp = danhSach[i];
                    danhSach[i] = danhSach[j];
                    danhSach[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp theo ngày SX " + (tangDan ? "tăng dần" : "giảm dần"));
    }

    // ========== SẮP XẾP THEO NGÀY HẾT HẠN ==========
    public void sapXepTheoNgayHetHan(boolean tangDan) {
        for (int i = 0; i < soLuong - 1; i++) {
            for (int j = i + 1; j < soLuong; j++) {
                boolean canDoi = tangDan
                    ? danhSach[i].getNgayHetHan().isAfter(danhSach[j].getNgayHetHan())
                    : danhSach[i].getNgayHetHan().isBefore(danhSach[j].getNgayHetHan());
                if (canDoi) {
                    HangThucPham temp = danhSach[i];
                    danhSach[i] = danhSach[j];
                    danhSach[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp theo ngày HH " + (tangDan ? "tăng dần" : "giảm dần"));
    }

    // ==============================================================
    // TÌM KIẾM / TRÍCH LỌC - TRẢ VỀ QuanLyThucPham MỚI (KHÔNG ARRAYLIST)
    // ==============================================================

    // ========== TÌM THEO TIỀN TỐ (bên trái) ==========
    public QuanLyThucPham timTheoTienTo(String tuKhoa) {
        QuanLyThucPham ketQua = new QuanLyThucPham();
        String tk = tuKhoa.toLowerCase();
        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].getTenHang().toLowerCase().startsWith(tk))
                ketQua.them(danhSach[i]);
        }
        return ketQua;
    }

//========== TÌM THEO HẬU TỐ (bên phải) ==========
public QuanLyThucPham timTheoHauTo(String tuKhoa) {
    QuanLyThucPham ketQua = new QuanLyThucPham();
    String tk = tuKhoa.toLowerCase();
    for (int i = 0; i < soLuong; i++) {
        if (danhSach[i].getTenHang().toLowerCase().endsWith(tk))
            ketQua.them(danhSach[i]);
    }
    return ketQua;
}

// ========== TÌM GẦN GIỐNG (chứa) ==========
public QuanLyThucPham timGanGiong(String tuKhoa) {
    QuanLyThucPham ketQua = new QuanLyThucPham();
    String tk = tuKhoa.toLowerCase();
    for (int i = 0; i < soLuong; i++) {
        if (danhSach[i].getTenHang().toLowerCase().contains(tk))
            ketQua.them(danhSach[i]);
    }
    return ketQua;
}

// ========== TRÍCH LỌC THEO NGÀY SẢN XUẤT ==========
public QuanLyThucPham trichLocTheoNgaySanXuat(LocalDate tuNgay, LocalDate denNgay) {
    QuanLyThucPham ketQua = new QuanLyThucPham();
    for (int i = 0; i < soLuong; i++) {
        LocalDate ngaySX = danhSach[i].getNgaySanXuat();
        if (!ngaySX.isBefore(tuNgay) && !ngaySX.isAfter(denNgay))
            ketQua.them(danhSach[i]);
    }
    return ketQua;
}

// ========== TRÍCH LỌC THEO NGÀY HẾT HẠN ==========
public QuanLyThucPham trichLocTheoNgayHetHan(LocalDate tuNgay, LocalDate denNgay) {
    QuanLyThucPham ketQua = new QuanLyThucPham();
    for (int i = 0; i < soLuong; i++) {
        LocalDate ngayHH = danhSach[i].getNgayHetHan();
        if (!ngayHH.isBefore(tuNgay) && !ngayHH.isAfter(denNgay))
            ketQua.them(danhSach[i]);
    }
    return ketQua;
}

// ========== THỐNG KÊ ==========
public int tinhTongSoLuong() { return soLuong; }

public double tinhTongGiaTri() {
    double tong = 0;
    for (int i = 0; i < soLuong; i++) tong += danhSach[i].getGia();
    return tong;
}

public void thongKeTheoThang() {
    if (soLuong == 0) { System.out.println("Danh sách trống."); return; }
    int[] demTheoThang = new int[13];
    for (int i = 0; i < soLuong; i++) {
        int thang = danhSach[i].getNgaySanXuat().getMonthValue();
        demTheoThang[thang]++;
    }
    System.out.println("THỐNG KÊ SẢN PHẨM THEO THÁNG SẢN XUẤT:");
    for (int t = 1; t <= 12; t++) {
        if (demTheoThang[t] > 0)
            System.out.println("   Tháng " + t + ": " + demTheoThang[t] + " sản phẩm");
    }
}

// ========== HIỂN THỊ ==========
public void hienThiDanhSach() {
    if (soLuong == 0) { System.out.println("Danh sách trống."); return; }
    System.out.println("\n+-----+------------+--------------------+--------------+--------------+------------+");
    System.out.println("| ID  | Mã hàng    | Tên hàng           | Ngày SX      | Ngày HH      | Giá        |");
    System.out.println("+-----+------------+--------------------+--------------+--------------+------------+");
    for (int i = 0; i < soLuong; i++) System.out.println(danhSach[i]);
    System.out.println("+-----+------------+--------------------+--------------+--------------+------------+");
    System.out.println("Tổng: " + soLuong + " sản phẩm.");
}

public int laySoLuong() { return soLuong; }
}