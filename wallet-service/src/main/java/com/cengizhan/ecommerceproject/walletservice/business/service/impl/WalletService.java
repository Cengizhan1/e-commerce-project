package com.cengizhan.ecommerceproject.walletservice.business.service.impl;

import com.cengizhan.ecommerceproject.walletservice.bean.ModelMapperBean;
import com.cengizhan.ecommerceproject.walletservice.business.dto.WalletDto;
import com.cengizhan.ecommerceproject.walletservice.business.service.IWalletService;
import com.cengizhan.ecommerceproject.walletservice.data.entity.WalletEntity;
import com.cengizhan.ecommerceproject.walletservice.data.repository.IWalletRepository;
import com.cengizhan.ecommerceproject.walletservice.exception.CustomException;
import com.cengizhan.ecommerceproject.walletservice.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Log4j2
@Service
public class WalletService implements IWalletService<WalletDto, WalletEntity> {

    private final ModelMapperBean modelMapperBean;
    private final IWalletRepository iWalletRepository;
    @Override
    public WalletDto entityToDto(WalletEntity walletEntity) {
        return modelMapperBean.modelMapperMethod().map(walletEntity,WalletDto.class);
    }

    @Override
    public WalletEntity dtoToEntity(WalletDto walletDto) {
        return  modelMapperBean.modelMapperMethod().map(walletDto,WalletEntity.class);
    }

    @Override
    public WalletDto walletServiceCreate(WalletDto walletDto) {
        if (walletDto != null) {
            WalletEntity walletEntity = dtoToEntity(walletDto);
            iWalletRepository.save(walletEntity);
            walletDto.setId(walletEntity.getId());
        } else {
            throw new NullPointerException("WalletDto null veri");
        }
        return walletDto;
    }

    @Override
    public WalletDto walletServiceFindById(Long id) {
        WalletEntity findWalletEntity = null;
        if (id != null) {
            findWalletEntity = iWalletRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(id + " nolu id yoktur"));
        } else {
            throw new CustomException("İd null olarak geldi");
        }
        return entityToDto(findWalletEntity);
    }

    @Override
    public WalletDto walletServiceFindByUserId(Integer userId) {
        WalletEntity findWalletEntity = null;
        if (userId != null) {
            findWalletEntity = iWalletRepository.findByUserId(userId)
                    .orElseThrow(() -> new ResourceNotFoundException(userId + " nolu id yoktur"));
        } else {
            throw new CustomException("İd null olarak geldi");
        }
        return entityToDto(findWalletEntity);
    }

    @Override
    public WalletDto wallerServiceBalanceUpdate(Integer userId, Float amount) {
        WalletDto walletDto = walletServiceFindByUserId(userId);
        if (walletDto != null) {
            WalletEntity walletEntity = dtoToEntity(walletDto);
            walletEntity.setBalance(walletEntity.getBalance() + amount);
            iWalletRepository.save(walletEntity);
            walletDto.setBalance(walletEntity.getBalance());
            return entityToDto(walletEntity);
        } else {
            throw new NullPointerException("WalletDto null veri");
        }
    }
}
