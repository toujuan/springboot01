package org.example.crm2026.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.crm2026.pojo.Member;
import org.example.crm2026.pojo.search.MemberSearchBean;
import org.example.crm2026.service.MemberService;
import org.example.crm2026.service.impl.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {
    private MemberService memberService;
    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/list")
    public Page<Member> list2(@RequestParam(defaultValue = "1") int pageNum,
                              @RequestParam(defaultValue = "10") int pageSize,
                              MemberSearchBean msb){
        Page<Member> page = new Page<>(pageNum, pageSize);
        return memberService.findAll(page, msb);
    }
    @PostMapping("/add")
    public boolean add(@RequestBody Member member){

//        boolean result = memberService.add(member);
//        return result;
        return memberService.add(member);
    }
    @DeleteMapping("/delete")
    public int delete(@RequestBody Integer[] ids){
        return memberService.delete(List.of(ids));
    }
    @PutMapping("/update")
    public int update(@RequestBody Member member){
        return memberService.gai(member);
    }
}
