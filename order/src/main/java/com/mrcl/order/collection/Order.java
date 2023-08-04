package com.mrcl.order.collection;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "order")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {
    @Id
    private UUID id;
    private Double price;
    private Double weight;
    private List<Address> addressList;
}
