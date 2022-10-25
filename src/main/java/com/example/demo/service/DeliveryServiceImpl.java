package com.example.demo.service;

import com.example.demo.exception.DoNotExistsException;
import com.example.demo.exception.ExceptionMessage;
import com.example.demo.mapper.*;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final ProductRepository productRepository;
    private final ProviderRepository providerRepository;
    private final StoreRepository storeRepository;
    private final DeliveryMapper deliveryMapper;
    private final ProductMapper productMapper;
    private final ProviderMapper providerMapper;
    private final StoreMapper storeMapper;

    public Mono<PageSupport<ResponseDelivery>> getAll(Pageable page) {
        return deliveryRepository.findAll()
                .map(deliveryMapper::toDTO)
                .publishOn(Schedulers.boundedElastic())
                .map((DeliveryDTO deliveryDTO) ->
                        deliveryMapper.toResponse
                                (deliveryDTO,
                                        productRepository.findById(deliveryDTO.getProductId())
                                                .map(productMapper::toDTO).block(),
                                        providerRepository.findById(deliveryDTO.getProviderId())
                                                .map(providerMapper::toDTO).block(),
                                        storeRepository.findById(deliveryDTO.getStoreId())
                                                .map(storeMapper::toDTO).block()
                                ))
                .collectList()
                .map(list -> new PageSupport<>(list
                        .stream()
                        .skip(page.getPageNumber() * page.getPageSize())
                        .limit(page.getPageSize())
                        .collect(Collectors.toList()),
                        page.getPageNumber(), page.getPageSize(), list.size()))
                .switchIfEmpty(Mono.empty());
    }

    public Mono<ResponseDelivery> getById(Long id) {
        return deliveryRepository.findById(id)
                .map(deliveryMapper::toDTO)
                .publishOn(Schedulers.boundedElastic())
                .map((DeliveryDTO deliveryDTO) ->
                        deliveryMapper.toResponse
                                (deliveryDTO,
                                        productRepository.findById(deliveryDTO.getProductId())
                                                .map(productMapper::toDTO).block(),
                                        providerRepository.findById(deliveryDTO.getProviderId())
                                                .map(providerMapper::toDTO).block(),
                                        storeRepository.findById(deliveryDTO.getStoreId())
                                                .map(storeMapper::toDTO).block()
                                ));
    }

    public Mono<ResponseRemains> getRemainsByStoreIdAndProductId(RequestRemains requestRemains) {
        return deliveryRepository.findRemainsByStoreIdAndProductId(requestRemains.getStoreId(),
                        requestRemains.getProductId())
                .publishOn(Schedulers.boundedElastic())
                .map(result -> ResponseRemains.builder()
                        .storeDTO(storeRepository.findById(requestRemains.getStoreId())
                                .map(storeMapper::toDTO).block())
                        .productDTO(productRepository.findById(requestRemains.getProductId())
                                .map(productMapper::toDTO).block())
                        .productCount(result)
                        .build());
    }


    public Mono<DeliveryDTO> addOrUpdateDelivery(RequestDelivery requestDelivery) {
        DeliveryDTO deliveryDTO = requestDelivery.getDeliveryDTO();
        ProductDTO productDTO = requestDelivery.getProductDTO();
        Delivery delivery = deliveryMapper.fromDTO(deliveryDTO);
        Product product = productMapper.fromDTO(productDTO);

        return productRepository.findByName(product.getName())
                .switchIfEmpty(Mono.defer(() -> productRepository.save(product)))
                .flatMap(orderedProduct -> deliveryRepository.save(Delivery.builder()
                        .productId(orderedProduct.getId())
                        .deliveryDate(delivery.getDeliveryDate())
                        .productCount(delivery.getProductCount())
                        .price(delivery.getPrice())
                        .providerId(delivery.getProviderId())
                        .storeId(delivery.getStoreId())
                        .build()))
                .map(deliveryMapper::toDTO);
    }

    public Mono<Void> delete(Long id) {
        return deliveryRepository.findById(id)
                .switchIfEmpty(Mono.error(new DoNotExistsException(ExceptionMessage.DO_NOT_EXIST)))
                .flatMap(deliveryRepository::delete);
    }
}
