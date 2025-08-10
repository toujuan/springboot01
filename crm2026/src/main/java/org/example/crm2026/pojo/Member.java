package org.example.crm2026.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;
import org.example.crm2026.util.AuditEntity;

import java.time.LocalDate;

@Getter
@Setter
@TableName("t_member")
public class Member extends AuditEntity {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String phone;
    @TableField(condition = SqlCondition.LIKE)
    private String name;
    private String pinyin;
    private LocalDate birthday;
}
