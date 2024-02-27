package com.blueyonder.smartcontactmanager.Repository;

import com.blueyonder.smartcontactmanager.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User,Integer> {

}
