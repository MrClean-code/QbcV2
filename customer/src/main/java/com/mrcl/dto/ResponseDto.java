package com.mrcl.dto;

import com.mrcl.model.Customer;
import com.mrcl.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {

    private List<CustomerDto> customer;
}
