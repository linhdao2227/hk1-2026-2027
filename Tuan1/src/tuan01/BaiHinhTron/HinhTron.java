package tuan01.BaiHinhTron;

public class HinhTron {
	private ToaDo tam;
	private double banKinh;
	public final double PI=3.1416;
	/**
	 * @return the tam
	 */
	public ToaDo getTam() {
		return tam;
	}
	/**
	 * @param tam the tam to set
	 */
	public void setTam(ToaDo tam) {
		this.tam = tam;
	}
	/**
	 * @return the banKinh
	 */
	public double getBanKinh() {
		return banKinh;
	}
	/**
	 * @param banKinh the banKinh to set
	 */
	public void setBanKinh(double banKinh) {
		this.banKinh = banKinh;
	}
	/**
	 * @param tam
	 * @param banKinh
	 */
	public HinhTron(ToaDo tam, double banKinh) {
		super();
		this.tam = tam;
		this.banKinh = banKinh;
	}
	public static void main(String[] args) {
		HinhTron h1 = new HinhTron(new ToaDo("O", 3, 4), 12);
		System.out.println("Thong tin hinh tron");
		System.out.println("Ban kinh la:");
		System.out.println(h1.getBanKinh()); 
		System.out.println("Tam la:" + h1.getTam().getTen()); 
	}
}
