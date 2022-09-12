package com.app.ezride.service;


import com.app.ezride.pojo.Admin;
import com.app.ezride.pojo.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

public interface IAdminService {

    public void addAdmin(User user);

}
