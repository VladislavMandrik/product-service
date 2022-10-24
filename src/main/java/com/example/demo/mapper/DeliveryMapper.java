package com.example.demo.mapper;

import com.example.demo.model.*;
import org.mapstruct.Mapper;

@Mapper(config = IgnoreMapperConfig.class)
public interface DeliveryMapper {
    DeliveryDTO toDTO(Delivery delivery);
    Delivery fromDTO(DeliveryDTO deliveryDTO);
    ResponseDelivery toResponse(DeliveryDTO deliveryDTO, ProductDTO productDTO, ProviderDTO providerDTO, StoreDTO storeDTO);
}
