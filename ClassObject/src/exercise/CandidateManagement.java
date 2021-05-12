package exercise;

import java.util.ArrayList;
import java.util.List;

public class CandidateManagement {
	private static List<Candidate> candidates = new ArrayList<Candidate>();
	
	public List<Candidate> createCandidate(){
		
		Candidate candidate1 = new Candidate(1,"Tien","Nam","18/05/1999","tien@gmail",9.0);
		Candidate candidate2 = new Candidate(2,"Tien","Nam","18/05/1999","tien@gmail",9.0);
		Candidate candidate3 = new Candidate(3,"Tien","Nam","18/05/1999","tien@gmail",9.0);
		Candidate candidate4 = new Candidate(4,"Tien","Nam","18/05/1999","tien@gmail",9.0);
		
		candidates.add(candidate1);
		candidates.add(candidate2);
		candidates.add(candidate3);
		candidates.add(candidate4);
		
		return candidates;
		
	}
	
	public void display(){
		createCandidate();		
		for (Candidate candidate : candidates) {
			System.out.println(candidate);
		}
		
	}
	
	public static void main(String[] args) {
		CandidateManagement candidateManagement = new CandidateManagement();
		candidateManagement.display();
	}

}
