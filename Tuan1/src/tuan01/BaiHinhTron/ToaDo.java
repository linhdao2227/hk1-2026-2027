package tuan01.BaiHinhTron;

public class ToaDo {
    private String ten;
    private double x;
    private double y;
	/**
	 * @return the ten
	 */
	public String getTen() {
		return ten;
	}
	/**
	 * @param ten the ten to set
	 */
	public void setTen(String ten) {
		this.ten = ten;
	}
	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}
	/**
	 * @param ten
	 * @param x
	 * @param y
	 */
	public ToaDo(String ten, double x, double y) {
		this.ten = ten;
		this.x = x;
		this.y = y;
	}
	
	public ToaDo() {
		super();
	} 
} 
