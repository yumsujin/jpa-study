package com.libqa.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	CustomerRepository CustomerRepository;

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	TeamRepository teamRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Override
	public void run(String... strings) throws Exception {
		Member member1 = new Member("sujin", 27, "female", "developer");
		Member member2 = new Member("ggaggachi", 27, "male", "developer");
		Member member3 = new Member("lapin", 27, "male", "developer");

		Member findMember = memberRepository.findOne(1L);

		System.out.println("member is : " + memberRepository.count());

		Team bali = new Team("bali");

		bali.addMember(member1);
		bali.addMember(member2);
		bali.addMember(member3);
		teamRepository.save(bali);

		member1.setTeam(bali);
		member2.setTeam(bali);
		member3.setTeam(bali);

		memberRepository.save(member1);
		memberRepository.save(member2);
		memberRepository.save(member3);

		bali.printTeamInfo();

		Member selectedMember = memberRepository.findByName("sujin").get(0);
		selectedMember.setAge(28);
		memberRepository.save(selectedMember);

		Team selectedTeam = teamRepository.findOne(1L);
		System.out.println("Team Member size : " + selectedTeam.getMember().size());
		selectedTeam.printTeamInfo();
		memberRepository.delete(selectedMember);

		Team selectedMemberTeam = selectedMember.getTeam();
		selectedMemberTeam.setTeamName("Black Mountain Island");
		teamRepository.save(selectedMemberTeam);

		Team selectedTeam2 = teamRepository.findOne(1L);
		System.out.println("Team Member size : " + selectedTeam2.getMember().size());
		selectedTeam2.printTeamInfo();


	}


}
