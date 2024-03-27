package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Address implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String provinceName;
	private int provinceCode;
	
	public Address() {
	}

	public Address(String provinceName, int provinceCode) {
		this.provinceName = provinceName;
		this.provinceCode = provinceCode;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public int getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(int provinceCode) {
		this.provinceCode = provinceCode;
	}

	@Override
	public String toString() {
		return "Address [provinceName=" + provinceName + ", provinceCode=" + provinceCode + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(provinceCode, provinceName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return provinceCode == other.provinceCode && Objects.equals(provinceName, other.provinceName);
	}
	
	public static ArrayList<Address> getProvList(){
		String provArr[] = {"An Giang",
				"Bà Rịa – Vũng Tàu",
				"Bạc Liêu",
				"Bắc Giang",
				"Bắc Kạn",
				"Bắc Ninh",
				"Bến Tre",
				"Bình Dương",
				"Bình Định",
				"Bình Phước",
				"Bình Thuận",
				"Cà Mau",
				"Cao Bằng",
				"Cần Thơ",
				"Đà Nẵng",
				"Đắk Lắk",
				"Đắk Nông",
				"Điện Biên",
				"Đồng Nai",
				"Đồng Tháp",
				"Gia Lai",
				"Hà Giang",
				"Hà Nam",
				"Hà Nội",
				"Hà Tĩnh",
				"Hải Dương",
				"Hải Phòng",
				"Hậu Giang",
				"Hòa Bình",
				"Hưng Yên",
				"Kiên Giang",
				"Kon Tum",
				"Khánh Hòa",
				"Lai Châu",
				"Lạng Sơn",
				"Lào Cai",
				"Lâm Đồng",
				"Long An",
				"Nam Định",
				"Ninh Bình",
				"Ninh Thuận",
				"Nghệ An",
				"Phú Thọ",
				"Phú Yên",
				"Quảng Bình",
				"Quảng Nam",
				"Quảng Ninh",
				"Quảng Ngãi",
				"Quảng Trị",
				"Sóc Trăng",
				"Sơn La",
				"Tây Ninh",
				"Tiền Giang",
				"Tuyên Quang",
				"Thái Bình",
				"Thái Nguyên",
				"Thanh Hóa",
				"Thành phố Hồ Chí Minh",
				"Thừa Thiên Huế",
				"Trà Vinh",
				"Vĩnh Long",
				"Vĩnh Phúc",
				"Yên Bái"};
		
		ArrayList<Address> provList = new ArrayList<Address>();
		int i = 1;
		for (String string : provArr) {
			Address prov = new Address(string, i);
			provList.add(prov);
		}
		return provList;
	}
	
	public static Address getTinhbyID(int provID) {
		return Address.getProvList().get(provID);
	}

	public static Address getTinhbyTen(String provName) {
		ArrayList<Address> provList = Address.getProvList();
		for (Address prov : provList) {
			if(prov.getProvinceName().equals(provName)) {
				return prov;
			}
		}
		return null;
	}
}
