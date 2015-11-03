package com.libqa.springboot;

import javax.persistence.*;

/**
 * Created by sujinee on 15. 10. 28..
 */
@Entity
public class Member {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long memberId;

	private int age;

	private String name;
	private String sex;
	private String role;

	@ManyToOne(optional = false)
	@JoinColumn(name = "teamId", nullable = false)// @ManyToOne의 fetch 기본전략은 EAGER이다.
	private Team team;

	public Member(String name, int age, String sex, String role){
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.role = role;
	}

	protected Member() {}

	public Team getTeam() {
		return team;
	}

	public String getName(){
		return name;
	}

	public String getSex(){
		return sex;
	}

	public String getRole(){
		return role;
	}

	public int getAge(){
		return age;
	}

	public void setAge(int age){
		this.age = age;
	}

	public void setTeam(Team team){
		this.team = team;
	}


}
