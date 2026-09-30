package daoThuyLinh_25689751;
import java.time.LocalDate;
	import java.time.format.DateTimeFormatter;
	import java.util.Scanner;

public class Main {
	
	    static Scanner sc = new Scanner(System.in);
	    static QuanLyThucPham ql = new QuanLyThucPham();
	    static DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	    public static void main(String[] args) {
	        duLieuMau();
	        int chon = -1;
	        do {
	            menu();
	            try { chon = Integer.parseInt(sc.nextLine()); }
	            catch (NumberFormatException e) { System.out.println("Vui lòng nhập số!"); continue; }

	            switch (chon) {
	                case 1: themThucPham(); break;
	                case 2: xoaThucPham(); break;
	                case 3: suaThucPham(); break;
	                case 4: ql.hienThiDanhSach(); break;
	                case 5: sapXepMenu(); break;
	                case 6: timKiemMenu(); break;
	                case 7: trichLocTheoNgay(); break;
	                case 8: thongKe(); break;
	                case 0: System.out.println("Tạm biệt!"); break;
	                default: System.out.println("Lựa chọn không hợp lệ!");
	            }
	        } while (chon != 0);
	        sc.close();
	    }

	    static void menu() {
	        System.out.println("\n╔══════════════ QUẢN LÝ THỰC PHẨM ══════════════╗");
	        System.out.println("║ 1. Thêm thực phẩm                             ║");
	        System.out.println("║ 2. Xóa theo id                                ║");
	        System.out.println("║ 3. Sửa theo id                                ║");
	        System.out.println("║ 4. Hiển thị danh sách                         ║");
	        System.out.println("║ 5. Sắp xếp                                    ║");
	        System.out.println("║ 6. Tìm kiếm theo tên                          ║");
	        System.out.println("║ 7. Trích lọc theo khoảng ngày                 ║");
	        System.out.println("║ 8. Thống kê                                   ║");
	        System.out.println("║ 0. Thoát                                      ║");
	        System.out.println("╚════════════════════════════════════════════════╝");
	        System.out.print("➤ Chọn: ");
	    }

	    static void duLieuMau() {
	        ql.them(new HangThucPham("TP001", "Sữa tươi Vinamilk",
	            LocalDate.of(2026, 1, 15),
	            LocalDate.of(2026, 2, 15), 25000));
	        ql.them(new HangThucPham("TP002", "Bánh quy Oreo",
	            LocalDate.of(2026, 3, 5),
	            LocalDate.of(2026, 6, 5), 15000));
	        ql.them(new HangThucPham("TP003", "Nước ngọt Coca",
	            LocalDate.of(2026, 1, 20),
	            LocalDate.of(2026, 9, 20), 12000));
	        ql.them(new HangThucPham("TP004", "Sữa chua TH True",
	        		LocalDate.of(2026, 5, 10),
	                LocalDate.of(2026, 5, 25), 8000));
	            ql.them(new HangThucPham("TP005", "Bánh mì Kinh Đô",
	                LocalDate.of(2026, 8, 1),
	                LocalDate.of(2026, 8, 15), 20000));
	            System.out.println("Đã nạp 5 sản phẩm mẫu.");
	        }

	        static void themThucPham() {
	            try {
	                System.out.print("Mã hàng: "); String ma = sc.nextLine();
	                System.out.print("Tên hàng: "); String ten = sc.nextLine();
	                System.out.print("Ngày SX (dd/MM/yyyy): ");
	                LocalDate sx = LocalDate.parse(sc.nextLine(), df);
	                System.out.print("Ngày HH (dd/MM/yyyy): ");
	                LocalDate hh = LocalDate.parse(sc.nextLine(), df);
	                System.out.print("Giá: "); float gia = Float.parseFloat(sc.nextLine());

	                HangThucPham h = new HangThucPham(ma, ten, sx, hh, gia);
	                if (ql.them(h)) System.out.println("Thêm thành công!");
	            } catch (Exception e) { System.out.println("Lỗi: " + e.getMessage()); }
	        }

	        static void xoaThucPham() {
	            try {
	                System.out.print("Nhập id cần xóa: ");
	                int id = Integer.parseInt(sc.nextLine());
	                if (ql.xoa(id)) System.out.println("Đã xóa id " + id);
	            } catch (NumberFormatException e) { System.out.println("id phải là số!"); }
	        }

	        static void suaThucPham() {
	            try {
	                System.out.print("Nhập id cần sửa: ");
	                int id = Integer.parseInt(sc.nextLine());
	                System.out.print("Tên mới: "); String ten = sc.nextLine();
	                System.out.print("Ngày SX mới (dd/MM/yyyy): ");
	                LocalDate sx = LocalDate.parse(sc.nextLine(), df);
	                System.out.print("Ngày HH mới (dd/MM/yyyy): ");
	                LocalDate hh = LocalDate.parse(sc.nextLine(), df);
	                System.out.print("Giá mới: "); float gia = Float.parseFloat(sc.nextLine());

	                if (ql.sua(id, ten, sx, hh, gia)) System.out.println("Đã sửa id " + id);
	            } catch (Exception e) { System.out.println("✗ Lỗi: " + e.getMessage()); }
	        }

	        static void sapXepMenu() {
	            System.out.println("  a. Giá tăng   | b. Giá giảm");
	            System.out.println("  c. Ngày SX tăng | d. Ngày SX giảm");
	            System.out.println("  e. Ngày HH tăng | f. Ngày HH giảm");
	            System.out.print("  Chọn: ");
	            String c = sc.nextLine().toLowerCase();
	            switch (c) {
	                case "a": ql.sapXepTheoGia(true); break;
	                case "b": ql.sapXepTheoGia(false); break;
	                case "c": ql.sapXepTheoNgaySanXuat(true); break;
	                case "d": ql.sapXepTheoNgaySanXuat(false); break;
	                case "e": ql.sapXepTheoNgayHetHan(true); break;
	                case "f": ql.sapXepTheoNgayHetHan(false); break;
	                default: System.out.println("Không hợp lệ!"); return;
	            }
	            ql.hienThiDanhSach();
	        }
	        static void timKiemMenu() {
	            System.out.println("  a. Tiền tố (bắt đầu) | b. Hậu tố (kết thúc) | c. Gần giống (chứa)");
	            System.out.print("  Chọn: ");
	            String c = sc.nextLine().toLowerCase();
	            System.out.print("  Nhập từ khóa: ");
	            String tk = sc.nextLine();

	            QuanLyThucPham kq;
	            switch (c) {
	                case "a": kq = ql.timTheoTienTo(tk); break;
	                case "b": kq = ql.timTheoHauTo(tk); break;
	                case "c": kq = ql.timGanGiong(tk); break;
	                default: System.out.println("Không hợp lệ!"); return;
	            }
	            System.out.println("Tìm thấy " + kq.laySoLuong() + " kết quả:");
	            kq.hienThiDanhSach();
	        }

	        static void trichLocTheoNgay() {
	            try {
	                System.out.println("  a. Lọc theo ngày SX | b. Lọc theo ngày HH");
	                System.out.print("  Chọn: ");
	                String c = sc.nextLine().toLowerCase();
	                System.out.print("  Từ ngày (dd/MM/yyyy): ");
	                LocalDate tu = LocalDate.parse(sc.nextLine(), df);
	                System.out.print("  Đến ngày (dd/MM/yyyy): ");
	                LocalDate den = LocalDate.parse(sc.nextLine(), df);

	                QuanLyThucPham kq;
	                if (c.equals("a")) kq = ql.trichLocTheoNgaySanXuat(tu, den);
	                else if (c.equals("b")) kq = ql.trichLocTheoNgayHetHan(tu, den);
	                else { System.out.println("Không hợp lệ!"); return; }

	                System.out.println("Trích lọc được " + kq.laySoLuong() + " kết quả:");
	                kq.hienThiDanhSach();
	            } catch (Exception e) { System.out.println("Lỗi: " + e.getMessage()); }
	        }

	        static void thongKe() {
	            System.out.println("\n===== THỐNG KÊ =====");
	            System.out.println("Tổng số sản phẩm: " + ql.tinhTongSoLuong());
	            System.out.printf("Tổng giá trị: %,.0f VNĐ\n", ql.tinhTongGiaTri());
	            if (ql.tinhTongSoLuong() > 0)
	                System.out.printf("Giá trung bình: %,.0f VNĐ\n",
	                    ql.tinhTongGiaTri() / ql.tinhTongSoLuong());
	            ql.thongKeTheoThang();
	        }
	    

}
	    
