package ua.lviv.iot.model.dal.dao.implementation;

import ua.lviv.iot.model.dal.dao.GeneralDAO;
import ua.lviv.iot.model.entity.Address;

public class AddressDAO extends GeneralDAO<Address> {
    public AddressDAO(){
        super(Address.class);
    }
}
