package com.result.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.result.model.StudentResult;
import com.result.repository.ResultRepository;

@Service
public class ResultService {

	@Autowired
	ResultRepository resultRepository;

	public List<StudentResult> getscore() {
		List<StudentResult> score = (List<StudentResult>) resultRepository.findAll();
		return score;
	}

	public StudentResult update(StudentResult studresult) {
		// TODO Auto-generated method stub

		StudentResult stud = resultRepository.findFirstByRegno(studresult.getRegno());
		if (stud != null) {
			stud.setName(studresult.getName());
			stud.setRegno(studresult.getRegno());
			stud.setMark1(studresult.getMark1());
			stud.setMark2(studresult.getMark2());
			stud.setMark3(studresult.getMark3());
			stud.setMark4(studresult.getMark4());
			stud.setMark5(studresult.getMark5());
			stud.setTotal(studresult.getMark1() + studresult.getMark2() + studresult.getMark3() + studresult.getMark4()
					+ studresult.getMark5());
			stud.setAverage(studresult.getTotal() / 5);
			if (studresult.getMark1() > 35 && studresult.getMark2() > 35 && studresult.getMark3() > 35
					&& studresult.getMark4() > 35 && studresult.getMark5() > 35) {
				stud.setResult("pass");
			} else
				stud.setResult("fail");

			return this.resultRepository.save(stud);
		} else {

			return null;
		}
	}

	public StudentResult saveresult(StudentResult studresult) throws Exception {
		if (resultRepository.existsByRegno(studresult.getRegno())) {
			throw new Exception("already exists");
		} else

			studresult.setTotal(studresult.getMark1() + studresult.getMark2() + studresult.getMark3()
					+ studresult.getMark4() + studresult.getMark5());
		studresult.setAverage(studresult.getTotal() / 5);
		if (studresult.getMark1() > 35 && studresult.getMark2() > 35 && studresult.getMark3() > 35
				&& studresult.getMark4() > 35 && studresult.getMark5() > 35) {
			studresult.setResult("pass");
		} else
			studresult.setResult("fail");

		return resultRepository.save(studresult);

	}

	public Boolean deleteresult(int regno) {
		List<StudentResult> stud = resultRepository.findAllByRegno(regno);
		resultRepository.deleteAll(stud);
		if (resultRepository.findByRegno(regno) == null) {
			return true;
		} else

			return false;
	}

	public ResponseEntity<StudentResult> getresultbyregno(int regno) {
		StudentResult stud = resultRepository.findFirstByRegno(regno);
		return ResponseEntity.ok().body(stud);

	}

}
