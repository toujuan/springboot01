package org.example.crm2026.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
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

    public Page<Member> findAll(Page<Member> page, MemberSearchBean member) {

        return memberMapper.findAll(page, member);
    }

    @Override
    public boolean add(Member member) {
        return memberMapper.insert(member)==1;
    }

    @Override
    public int delete(List<Integer> ids) {
        return memberMapper.deleteByIds(ids);
    }

    @Override
    public int gai(Member member) {

        return memberMapper.updateById(member);
    }


}
