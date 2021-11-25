package ua.lviv.iot.dal.dao.implementation;

import ua.lviv.iot.dal.dao.GeneralDAO;
import ua.lviv.iot.model.entity.Address;

public class AddressDAO extends GeneralDAO<Address, Integer> {
    public AddressDAO(){
        super(Address.class);
    }
}
