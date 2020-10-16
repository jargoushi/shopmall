package com.wjy.service.Impl;

import com.wjy.domain.Address;
import com.wjy.mapper.AddressMapper;
import com.wjy.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/6 21:28
 * @Description:
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    public Address queryAddressById(Integer addressId) {
        return addressMapper.queryAddressById(addressId);
    }

    public List<Address> queryAddressByUserId(Integer userId) {
        return addressMapper.queryAddressByUserId(userId);
    }

    public boolean updateAddress(Address saveAddr) {
        return addressMapper.updateAddress(saveAddr) > 0;
    }

    public boolean deleteAddress(Address address) {
        return addressMapper.deleteAddress(address) > 0;
    }

    public boolean insertAddress(Address insertAddr) {
        return addressMapper.insertAddress(insertAddr) > 0;
    }
}
