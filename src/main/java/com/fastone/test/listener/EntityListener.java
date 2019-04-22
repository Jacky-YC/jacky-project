package com.fastone.test.listener;

import com.fastone.test.domain.User;

import javax.persistence.PrePersist;
import java.util.Date;

public class EntityListener {

    @PrePersist
    public void prePersist(Object o){
        if (o instanceof User) {
            User user = (User)o;
            user.setCreateAt(new Date());
            user.setCreateBy(17600037713L);
        }

        System.out.println(o instanceof User);

    }

}
