package org.example.crm2026.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.crm2026.dao.MemberMapper;
import org.example.crm2026.pojo.Member;
import org.example.crm2026.pojo.search.MemberSearchBean;
import org.example.crm2026.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    private MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/list")
    public Page<Member> list(
            @RequestParam(defaultValue = "2") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize,
            MemberSearchBean msb) {

        Page<Member> page = new Page<>(pageNum, pageSize);
        //page=this.memberService.findAll(page,msb);
        //System.out.println(page.getTotal());
        //return page;
        return memberService.findAll(page, msb);

    }


//    @PostMapping("/add")
//    public Member Add(){
//        Member m1 = new Member();
//        //m1.setId(1004);
//        m1.setPhone("12345678901");
//        m1.setName("张三");
//        m1.setPinyin("zhangsan");
//        memberMapper.insert(m1);
//        return m1;
//    }
}

