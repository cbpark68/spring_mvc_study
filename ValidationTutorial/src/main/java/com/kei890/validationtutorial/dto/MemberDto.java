package com.kei890.validationtutorial.dto;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.stereotype.Component;

@Component
public class MemberDto {
	
	int no;
	
	@NotNull
	@Size(min=1, max=30)
	String id;
	
	@NotNull
	@Size(min=8, max=30 , message="비밀번호 오류!")
	String pw;
	
	public MemberDto() {
		// TODO Auto-generated constructor stub
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id : " + getId() + "\n pw :" + getPw();
	}

}
