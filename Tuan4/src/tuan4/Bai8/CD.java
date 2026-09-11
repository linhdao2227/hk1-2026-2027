/**
 * 
 */
package tuan4.Bai8;

/**
 * Bai tap tuan4, Bai8,
 */
public class CD {
	/**
	 * khai bao thuoc tinh
	 */
	private String maCD;
	private String tuaCD;
	private String caSy;
	private int soBaiHat;
	private float giaThanh;
	
	/**
	 * dong goi va rang buoc +get +set
	 */
	/**
	 * @return the maCD
	 */
	public String getMaCD() {
		return maCD;
	}
	/**
	 * @param maCD the maCD to set
	 */
	public void setMaCD(String maCD) {
		this.maCD = maCD;
	}
	/**
	 * @return the tuaCD
	 */
	public String getTuaCD() {
		return tuaCD;
	}
	/**
	 * @param tuaCD the tuaCD to set
	 */
	public void setTuaCD(String tuaCD) {
		this.tuaCD = tuaCD;
	}
	/**
	 * @return the caSy
	 */
	public String getCaSy() {
		return caSy;
	}
	/**
	 * @param caSy the caSy to set
	 */
	public void setCaSy(String caSy) {
		this.caSy = caSy;
	}
	/**
	 * @return the soBaiHat
	 */
	public int getSoBaiHat() {
		return soBaiHat;
	}
	/**
	 * @param soBaiHat the soBaiHat to set
	 * @throws Exception 
	 */
	public void setSoBaiHat(int soBaiHat) throws Exception {
		if (soBaiHat > 0) {
		    this.soBaiHat = soBaiHat;
		} else {
			throw new Exception("so bai hat lon hon 0");
		}
	}
	/**
	 * @return the giaThanh
	 */
	public float getGiaThanh() {
		return giaThanh;
	}
	/**
	 * @param giaThanh the giaThanh to set
	 */
	public void setGiaThanh(float giaThanh) {
		this.giaThanh = giaThanh;
	}
	
	/**
	 *Ham tao constructer
	 */
	
	/**
	 * @param maCD
	 * @param tuaCD
	 * @param caSy
	 * @param soBaiHat
	 * @param giaThanh
	 */
	public CD(String maCD, String tuaCD, String caSy, int soBai, float giaThanh) {
		this.maCD = maCD;
		this.tuaCD = tuaCD;
		this.caSy = caSy;
		if (soBai > 0) {
		    this.soBai = soHat;
		} else {
			throw new Exception("so bai hat lon hon 0");
		}
		
		this.giaThanh = giaThanh;
	}
	
	public CD() {
		
			}
	
	
	

}
