package kr.ed.haebeop.test.transaction;

import kr.ed.haebeop.domain.Emp;
import kr.ed.haebeop.domain.TestVO;
import kr.ed.haebeop.domain.TransVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/transaction/")
public class TransactionController {

    @Autowired
    private TransactionService tranService;
    //<a href="/transaction/addCollection">TEST+EMP 추가</a1>
    //http:localhost:8084/study2_war/transaction/addCollection
    //http:localhost:8084/study2_war/test/addCollection.jsp
    @GetMapping("addCollection")
    public String addCollectionForm(Model model){
        return "/test/addCollection";
    }

    //<form action="/transaction/addCollection" method="post">
    //name=num, title, emp_no, first_name
    @PostMapping("addCollection")
    public String addCollectionPro(@RequestParam TransVO vo, Model model){
        TestVO test = new TestVO();
        test.setNum(vo.getNum());
        test.setTitle(vo.getTitle());

        Emp emp = new Emp();
        emp.setEmp_no(vo.getEmp_no());
        emp.setFirst_name(vo.getFirst_name());

        tranService.addCollection(test, emp);
        return "redirect:/";
    }
}
