package org.example.crm2026.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.example.crm2026.pojo.Member;
import org.example.crm2026.pojo.search.MemberSearchBean;
@Mapper
public interface MemberMapper extends BaseMapper<Member> {
        default Page<Member> findAll(Page<Member> page, MemberSearchBean msb){
        LambdaQueryWrapper<Member> qw= Wrappers.lambdaQuery(msb);
        if(msb.getBirthdayFrom()!=null){
            qw.ge(Member::getBirthday,msb.getBirthdayFrom());
        }
        if(msb.getBirthdayTo()!=null){
            qw.le(Member::getBirthday,msb.getBirthdayTo());
        }
        return selectPage(page,qw);
    }
}
