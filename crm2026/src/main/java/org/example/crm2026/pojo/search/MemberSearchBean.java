package org.example.crm2026.pojo.search;

import lombok.Getter;
import lombok.Setter;
import org.example.crm2026.pojo.Member;

import java.time.LocalDate;
@Getter
@Setter
public class MemberSearchBean extends Member {
    private LocalDate birthdayFrom;
    private LocalDate birthdayTo;
}
