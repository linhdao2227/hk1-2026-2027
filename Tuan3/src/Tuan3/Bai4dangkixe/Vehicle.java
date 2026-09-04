package Tuan3.Bai4dangkixe;

import java.text.DecimalFormat;

public class Vehicle {
	private String tenChuXe;
	private String loaiXe;
	private double triGia;      
	private int dungTichXylanh; 
	
	public Vehicle() {
		this.tenChuXe = "Chưa biết";
		this.loaiXe = "Chưa biết";
		this.triGia = 0;
		this.dungTichXylanh = 0;
	}

	public Vehicle(String tenChuXe, String loaiXe, double triGia, int dungTichXylanh) {
		this.tenChuXe = tenChuXe;
		this.loaiXe = loaiXe;
		setTriGia(triGia);                 
		setDungTichXylanh(dungTichXylanh); 
	}

	/**
	 * @return the tenChuXe
	 */
	public String getTenChuXe() {
		return tenChuXe;
	}

	/**
	 * @param tenChuXe the tenChuXe to set
	 */
	public void setTenChuXe(String tenChuXe) {
		this.tenChuXe = tenChuXe;
	}

	/**
	 * @return the loaiXe
	 */
	public String getLoaiXe() {
		return loaiXe;
	}

	/**
	 * @param loaiXe the loaiXe to set
	 */
	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}

	/**
	 * @return the triGia
	 */
	public double getTriGia() {
		return triGia;
	}

	/**
	 * @param triGia the triGia to set
	 */
	public void setTriGia(double triGia) {
	
		if (triGia >= 0) {
			this.triGia = triGia;
		} else {
			this.triGia = 0;
		}
	}

	/**
	 * @return the dungTichXylanh
	 */
	public int getDungTichXylanh() {
		return dungTichXylanh;
	}

	/**
	 * @param dungTichXylanh the dungTichXylanh to set
	 */
	public void setDungTichXylanh(int dungTichXylanh) {
		
		if (dungTichXylanh >= 0) {
			this.dungTichXylanh = dungTichXylanh;
		} else {
			this.dungTichXylanh = 0;
		}
	}

	public double tinhThuePhaiNop() {
		if (this.dungTichXylanh < 100) {
			return this.triGia * 0.01; 
		} else if (this.dungTichXylanh <= 200) {
			return this.triGia * 0.03; 
		} else {
			return this.triGia * 0.05; 
		}
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00");
		return String.format("%-25s %-20s %14d %20s %20s", 
				tenChuXe, loaiXe, dungTichXylanh, df.format(triGia), df.format(tinhThuePhaiNop()));
	}

	public static void main(String[] args) {
		
		Vehicle xe1 = new Vehicle("Nguyễn Thu Loan", "Future Neo", 35000000.00, 100);
		Vehicle xe2 = new Vehicle("Lê Minh Tính", "Ford Ranger", 250000000.00, 3000);
		Vehicle xe3 = new Vehicle("Nguyễn Minh Triết", "Landscape", 1000000000.00, 1500);

		System.out.format("%-25s %-20s %14s %20s %20s\n", 
				"Tên chủ xe", "Loại xe", "Dung tích", "Trị giá", "Thuế phải nộp");
		System.out.println("=========================================================================================================");
		
		System.out.println(xe1);
		System.out.println(xe2);
		System.out.println(xe3);
	}
}
