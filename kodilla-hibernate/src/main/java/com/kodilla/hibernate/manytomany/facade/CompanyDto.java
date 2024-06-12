package com.kodilla.hibernate.manytomany.facade;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class CompanyDto {
    private final int id;
    private final String name;
    @Setter
    private List<EmployeeDto> employees = new ArrayList<>();
}
