package spring;

import java.util.Date;

public class Member {
	private Long id;
	private String email;
	private String password;
	private String name;
	private Date registerDate;
	public Member(String email, String password,
			String name, Date registerDate) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDate = registerDate;
	}
	public void setId(Long id) { this.id = id; }
	public Long getId() { return this.id; }
	public String getEmail() { return this.email; }
	public String getPassword() { return this.password; }
	public String getName() { return this.name; }
	public Date getRegisterDate() { return this.registerDate; }
	public void changePassword(String oldPassword, String newPassword){
		if (!this.password.equals(oldPassword))
			throw new IdPasswordNotMatchingException();
		this.password = newPassword;
	}
}
