package org.example.crm2026.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.crm2026.dao.MemberMapper;
import org.example.crm2026.pojo.Member;
import org.example.crm2026.pojo.search.MemberSearchBean;
import org.example.crm2026.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    private MemberMapper memberMapper;
    @Autowired
    public MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public Page<Member> findAll(Page<Member> page, MemberSearchBean member) {
        QueryWrapper<Member> wrapper = new QueryWrapper<>();

        if (member != null && member.getName() != null && !member.getName().isEmpty()) {
            wrapper.like("name", member.getName());
        }
        return memberMapper.selectPage(page, wrapper);
    }
}
