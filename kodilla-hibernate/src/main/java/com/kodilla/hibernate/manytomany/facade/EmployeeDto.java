package com.kodilla.hibernate.manytomany.facade;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class EmployeeDto {
    private final int id;
    private final String firstName;
    private final String lastName;
    @Setter
    private List<CompanyDto> companies = new ArrayList<>();
}
