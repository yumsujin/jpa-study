package com.libqa.springboot;

import javax.persistence.*;

import java.util.*;

/**
 * Created by sujinee on 15. 10. 28..
 */
@Entity
public class Team {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long teamId;

	private String teamName;

//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, mappedBy = "team")
	// CascadeType.ALL 일 때와 FetchType.LAZY일 때 에러가 뜨는데 원인 모름.
	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "team", fetch = FetchType.EAGER) // @OneToMany의 fetch 기본전략은 LAZY이다.
	private Collection<Member> members;


	public Team(String teamName){
		this.teamName = teamName;
	}
	protected Team() {}

	public Collection<Member> getMember() {
		if (members == null) {
			members = new ArrayList<Member>();
		}
		return members;
	}

	public void setMember(Collection<Member> member) {
		this.members = member;
	}

	public void addMember(Member member) {
		Collection<Member> members = getMember();
		members.add(member);
	}

	public void setTeamName(String teamName){
		this.teamName = teamName;
	}


	public void printTeamInfo(){
		System.out.println("Team Name : "+ teamName);
		System.out.println("Team Member");
		for(Member member : members){
			System.out.println("Member Info : "+ member.getName()+", " + member.getAge() + ", "
				+ member.getSex() + ", " + member.getRole());
		}
	}
}
