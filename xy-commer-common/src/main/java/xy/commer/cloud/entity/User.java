package xy.commer.cloud.entity;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public long id;
	public String uname;
	public String pwd;
	public long ctime;
	public String phone;
	public String info;
	public String img;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public long getCtime() {
		return ctime;
	}

	public void setCtime(long ctime) {
		this.ctime = ctime;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public User() {
	}

	public User(long id, String uname, String pwd, long ctime, String phone, String info, String img) {
		super();
		this.id = id;
		this.uname = uname;
		this.pwd = pwd;
		this.ctime = ctime;
		this.phone = phone;
		this.info = info;
		this.img = img;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + ", pwd=" + pwd + ", ctime=" + ctime + ", phone=" + phone
				+ ", info=" + info + ", img=" + img + "]";
	}

}
