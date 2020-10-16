package com.wjy.mapper;

import com.wjy.domain.Address;

import java.util.List;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/6 21:28
 * @Description:
 */
public interface AddressMapper {
    Address queryAddressById(Integer addressId);

    List<Address> queryAddressByUserId(Integer userId);

    int updateAddress(Address saveAddr);

    int deleteAddress(Address address);

    int insertAddress(Address insertAddr);
}
