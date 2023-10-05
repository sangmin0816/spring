package kr.ed.haebeop.test.transaction;

import kr.ed.haebeop.domain.Emp;
import kr.ed.haebeop.domain.TestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository tranRepository;

    public void addCollection(TestVO test, Emp emp){
        tranRepository.addCollection(test, emp);
    }
}
