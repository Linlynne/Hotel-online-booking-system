package com.example.hotelbookingsystem.config;

import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.hotelbookingsystem.entity.Address;
import com.example.hotelbookingsystem.entity.Reservation;
import com.example.hotelbookingsystem.entity.Role;
import com.example.hotelbookingsystem.entity.Room;
import com.example.hotelbookingsystem.entity.RoomType;
import com.example.hotelbookingsystem.entity.User;
import com.example.hotelbookingsystem.repository.AddressRepository;
import com.example.hotelbookingsystem.repository.ReservationRepository;
import com.example.hotelbookingsystem.repository.RoleRepository;
import com.example.hotelbookingsystem.repository.RoomRepository;
import com.example.hotelbookingsystem.repository.RoomTypeRepository;
import com.example.hotelbookingsystem.repository.UserRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Configuration
public class DBDataConfig {

    @Autowired
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public DBDataConfig(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	@Bean
    CommandLineRunner loadData(RoomRepository roomRepository, RoomTypeRepository roomTypeRepository, UserRepository userRepository,
    		ReservationRepository reservationRepository) {
    	String password = bCryptPasswordEncoder.encode("123456");
        return args -> {
 
        	RoomType roomType1= new RoomType("Standard");
        	RoomType roomType2= new RoomType("Double");
        	RoomType roomType3= new RoomType("Triple");
        	RoomType roomType4= new RoomType("Queen");
        	RoomType roomType5= new RoomType("King");
        	roomTypeRepository.saveAll(List.of(roomType1, roomType2, roomType3,roomType4,roomType5));
            Room room1 = new Room("101",roomType1, "Good review", 139, null);
            Room room2 = new Room("102",roomType2, "Big window", 159, null);
            Room room3 = new Room("103",roomType3,"Good Price", 199, null);
            Room room4 = new Room("104",roomType4, "Comfortable", 159, null);
            Room room5 = new Room("105",roomType5, "Big bed", 169, null);
            Room room6 = new Room("106",roomType1, "Good Review ", 109, null);
            Room room7 = new Room("107",roomType2, "Big window", 159, null);
            Room room8 = new Room("108",roomType3, "Good Price", 199, null);
            Room room9 = new Room("109",roomType1, "Good review", 139, null);
            Room room10 = new Room("110",roomType2, "Bid bed", 169, null);
            roomRepository.saveAll(List.of(room1, room2, room3,room4,room5,room6,room7,room8,room9,room10));
        	Role adminRole = new Role("admin");
        	Role clientRole = new Role("client");
        	Address address = new Address("1 main st","Montreal", "QC","M1M1M1","Canada");
			User adminUser1 = new User("lynneadmin", password,"lynnelin2019@gmail.com","5141111111",address,adminRole);
        	User adminUser = new User("Dmitriadmin", password,"lynnelin2019@gmail.com","5141111111",address,adminRole);
        	User clientUser = new User("Lynne", password,"lynnelin2019@gmail.com","5142222222",address,clientRole);
			User clientUser1 = new User("Dmitri", password,"lynnelin2019@gmail.com","5142222222",address,clientRole);
			User clientUser2 = new User("Lily", password,"lynnelin2019@gmail.com","5142222222",address,clientRole);
			User clientUser3 = new User("Alice", password,"lynnelin2019@gmail.com","5142222222",address,clientRole);

			userRepository.saveAll(List.of(adminUser,adminUser1, clientUser,clientUser1,clientUser2,clientUser3));
        	Reservation reservation1 = new Reservation(
        			new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-18"),
        			new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-22"),
        			room1.getPrice()*4,
        			"",clientUser,room1);
        	Reservation reservation2 = new Reservation(
        			new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-28"),
        			new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-30"),
        			room1.getPrice()*2,
        			"",clientUser1,room1);
        	Reservation reservation4 = new Reservation(
        			new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-05"),
        			new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-10"),
        			room1.getPrice()*5,
        			"",clientUser2,room1);
        	Reservation reservation3 = new Reservation(
        			new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-18"),
        			new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-20"),
        			room1.getPrice()*2,
        			"",clientUser3,room2);
        	reservationRepository.saveAll(List.of(reservation1, reservation2, reservation4,reservation3));
        };
    }
}
