package com.situ.crm2026.model.search;

import com.situ.crm2026.model.Member;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MemberSearchBean extends Member {
    private LocalDate birthdayFrom;
    private LocalDate birthdayTo;
}
