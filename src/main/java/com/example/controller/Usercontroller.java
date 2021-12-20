package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.User;
import com.example.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class Usercontroller 
{
	@Autowired
	UserRepository repo;
	
	//@RequestMapping("/")
	//First method to print data in key value pair by JSON method
	//@ResponseBody
    //public List<User> getUser()
    //{
   // 	return repo.findAll();
    //}
	
	//Second method to print data in key value pair by JSON method it return status also
	@GetMapping("/")
	public ResponseEntity<List<User>> getUser()
	{
		return new ResponseEntity<List<User>>(repo.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/userid/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") int userid)
	{
		return new ResponseEntity<User>(repo.findByUserid(userid), HttpStatus.OK);
	}
	
	@GetMapping("/username/{name}")
	public ResponseEntity<User> getUser(@PathVariable("name") String username)
	{
		return new ResponseEntity<User>(repo.findByUsername(username), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Void> addUser(@RequestBody  User user)
	{
		repo.save(user);
		return new ResponseEntity<Void> (HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Void> updateUser(@RequestBody  User user)
	{
		repo.save(user);
		return new ResponseEntity<Void> (HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{userid}")
	public ResponseEntity<Void> deleteUser(@PathVariable("userid") int userid)
	{
		User u = new User();
		u.setUserid(userid);
		repo.delete(u);
		return new ResponseEntity<Void> (HttpStatus.OK);
	}
}
