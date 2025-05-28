package com.gowtham.ecom.ecom_app.repos;

import com.gowtham.ecom.ecom_app.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users ,Integer> {

}
