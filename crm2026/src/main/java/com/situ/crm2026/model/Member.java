package com.situ.crm2026.model;

import com.baomidou.mybatisplus.annotation.*;
import com.situ.crm2026.util.AuditEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * 会员
 */
@TableName("t_member")
@Getter
@Setter
public class Member extends AuditEntity {
    @TableId(type = IdType.AUTO)
    private Integer id;

    @NotBlank(message = "手机号不可为空")
    @Pattern(regexp = "^\\d{11}$", message = "手机号必须是11位")
    @TableField(condition = SqlCondition.LIKE, whereStrategy = FieldStrategy.NOT_EMPTY)
    private String phone;

    private String password;

    @NotBlank(message = "会员姓名不可为空")
    @TableField(condition = SqlCondition.LIKE, whereStrategy = FieldStrategy.NOT_EMPTY)
    private String name;

    private String pinyin;

    @NotBlank(message = "会员性别不可为空")
    @Pattern(regexp = "^[男,女]$", message = "性别只能为男或女")
    @TableField(whereStrategy = FieldStrategy.NOT_EMPTY)
    private String sex;

    private LocalDate birthday;

    @TableField(condition = SqlCondition.LIKE, whereStrategy = FieldStrategy.NOT_EMPTY)
    private String email;

    @TableField(condition = SqlCondition.LIKE, whereStrategy = FieldStrategy.NOT_EMPTY)
    private String wechat;

    private String description;

    //头像
    @TableField("portrait")
    private String avatar;
}
