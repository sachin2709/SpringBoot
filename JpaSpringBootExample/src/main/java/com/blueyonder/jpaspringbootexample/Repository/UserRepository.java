package com.blueyonder.jpaspringbootexample.Repository;

import com.blueyonder.jpaspringbootexample.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {

    public List<User> findByName(String name);
    public List<User> findByNameIsLikeIgnoreCase(String name);

    public List<User> findByNameIsStartingWith(String name);

    public List<User> findByNameStartingWithAndEmailContaining(String name, String email);
    public List<User> findByNameStartingWithAndEmailLike(String name, String email);

    //  -------------------- JPQL ---------------------------------------------
    @Query("select u From users u")  //for running your own custom query for any function ....i have used users as table name because my entity'
    // name is users . I have mentioned it at @Entity("users")
    public List<User> getAllUser();


    @Query("select u FROM users u WHERE u.name=:n")
    public List<User> getUserByName(@Param("n") String  name);

    @Query("select u FROM users u WHERE u.name=:n and u.tech=:t")
    public List<User> getUserByNameAndCity(@Param("n") String  name , @Param("t")String tech);


    //  -------------------- native query (based on database that you are using)   ---------------------------------------------
    @Query(value = "select * FROM users",nativeQuery = true)
    public List<User> getUsers();




}
