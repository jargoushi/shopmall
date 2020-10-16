package com.wjy.service;

import com.wjy.domain.Address;

import java.util.List;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/6 21:27
 * @Description:
 */
public interface AddressService {

    Address queryAddressById(Integer addressId);

    List<Address> queryAddressByUserId(Integer userId);

    boolean updateAddress(Address saveAddr);

    boolean deleteAddress(Address address);

    boolean insertAddress(Address insertAddr);
}
