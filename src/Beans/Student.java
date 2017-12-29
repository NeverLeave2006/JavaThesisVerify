package Beans;

public class Student {
	@Override
	public String toString() {
		return "Student [classNo=" + classNo + ", stuNum=" + stuNum
				+ ", province=" + province + ", category=" + category
				+ ", type=" + type + ", name=" + name + ", password="
				+ password + ", sex=" + sex + ", mayor=" + mayor + ", academy="
				+ academy + ", e_mail=" + e_mail + "]";
	}

	private String classNo;
	private String stuNum;
	private String province;
	private String category;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	private String type;
	private String name;
	private String password;
	
	
	
	public Student(String classNo, String stuNum, String province,
			String category, String type, String name, String password,
			String sex, String mayor, String academy, String e_mail) {
		super();
		this.classNo = classNo;
		this.stuNum = stuNum;
		this.province = province;
		this.category = category;
		this.type = type;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.mayor = mayor;
		this.academy = academy;
		this.e_mail = e_mail;
	}

	private String sex;
	private String mayor;
	private String academy;
	private String e_mail;
	
	public String getClassNo() {
		return classNo;
	}
	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}
	public String getStuNum() {
		return stuNum;
	}
	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMayor() {
		return mayor;
	}
	public void setMayor(String mayor) {
		this.mayor = mayor;
	}
	public String getAcademy() {
		return academy;
	}
	public void setAcademy(String academy) {
		this.academy = academy;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
}
