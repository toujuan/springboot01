package org.example.crm2026.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.crm2026.pojo.Member;
import org.example.crm2026.pojo.search.MemberSearchBean;
import org.springframework.stereotype.Service;


public interface MemberService {
    Page<Member> findAll(Page<Member> page, MemberSearchBean msb);

}
