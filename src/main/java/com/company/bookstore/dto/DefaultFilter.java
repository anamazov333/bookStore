package com.company.bookstore.dto;

import com.company.bookstore.enumeration.StatusType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.StringUtils;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class DefaultFilter {

    private String search;
    private String sort; // asc or desc
    private String field; // by default is id
    private Integer status; // belongsTo statusType
    private Integer uStatus; // user can modify this status used in some entities not all
    private StatusType statusType; // each entity has statusType - data_status
    private Integer page;
    private Integer size;

    public String getSearch(){
        if(StringUtils.hasText(this.search)) return this.search;
        return "";
    }

    public String getSort(){
        if(!StringUtils.hasText(this.sort) || this.sort.equals("desc")) return "desc";
        if(this.sort.equals("asc")) return "asc";
        return "desc";
    }

    public String getField(){
        if(!StringUtils.hasText(this.field)) return "id";
        return this.field;
    }

    public Integer getPage(){
        if(this.page == null || this.page < 0) return 0;
        return this.page;
    }

    public Integer getSize(){
        if(this.size == null || this.size < 0) return 5;
        return this.size;
    }

    public StatusType getStatusType(){
        return StatusType.getById(this.status);
    }

}
