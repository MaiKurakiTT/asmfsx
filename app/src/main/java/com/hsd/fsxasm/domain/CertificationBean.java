package com.hsd.fsxasm.domain;import org.xutils.http.annotation.HttpResponse;import com.hsd.fsxasm.parser.CertificationParser;@HttpResponse(parser = CertificationParser.class)public class CertificationBean extends BaseBean {	// 学号	private String student_number;	// 密码	private String student_password;		// 验证码	private String verificationCode;		// 真实姓名	private String student_realName;	// 学校	private String student_schoolName;		public String getStudent_realName() {		return student_realName;	}	public void setStudent_realName(String student_realName) {		this.student_realName = student_realName;	}	public String getStudent_number() {		return student_number;	}	public String getStudent_password() {		return student_password;	}	public void setStudent_number(String student_number) {		this.student_number = student_number;	}	public void setStudent_password(String student_password) {		this.student_password = student_password;	}	public String getVerificationCode() {		return verificationCode;	}	public String getStudent_schoolName() {		return student_schoolName;	}	public void setVerificationCode(String verificationCode) {		this.verificationCode = verificationCode;	}	public void setStudent_schoolName(String student_schoolName) {		this.student_schoolName = student_schoolName;	}	}