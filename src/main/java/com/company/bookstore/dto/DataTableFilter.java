package com.company.bookstore.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DataTableFilter {
    @NotNull(message = "PageNo has to be present")
    private Integer pageNo=0;
    @NotNull(message = "PageSize has to be present")
    private Integer pageSize=10;
    @NotNull(message = "ColumnNumber has to be present")
    private Integer sortColumnNumber=0;
    @NotNull(message = "FilterValue has to be present")
    private String searchFilterValue="";
}
