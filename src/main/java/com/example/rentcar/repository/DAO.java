package com.example.rentcar.repository;

import com.example.rentcar.Entity.CarEntity;
import com.example.rentcar.Entity.UserEntity;
import com.example.rentcar.model.CarColour;
import com.example.rentcar.model.CarType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DAO {


    private CarRepository carRepository;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DAO(CarRepository carRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired


    @EventListener(ApplicationReadyEvent.class)
    public void createMockDataBases() {
        CarEntity carEntity1 = CarEntity.builder().brand("AUDI").model("A4").carColour(CarColour.BLACK).id(1L)
                .millage(10000).price(100).carType(CarType.COMBI).vin("121453iu111").power(200)
                .imagePath("/resources/static/images/AudiA4.png").build();
        CarEntity carEntity2 = CarEntity.builder().brand("BMW").model("X3").carColour(CarColour.RED).id(2L)
                .millage(12000).price(200).carType(CarType.SUV).vin("121153iu111").power(150).imagePath("/resources/static/images/bmwX3.png").build();
        CarEntity carEntity3 = CarEntity.builder().brand("OPEL").model("TRAFFIC").carColour(CarColour.WHITE).id(3L)
                .millage(12500).price(300).carType(CarType.BUS).vin("235153iu1d11").power(160).imagePath("/resources/static/images/opel.png").build();
        carRepository.save(carEntity1);
        carRepository.save(carEntity2);
        carRepository.save(carEntity3);

this.userRepository.deleteAll();

        UserEntity userEntity = UserEntity.builder().login("janek").password(passwordEncoder.encode("janek")).street("Łowicka 1").city("Skierniewice").postCode("90-000").phoneNumber("+48 900900900")
                .email("janek@wp.pl").firstName("Jan").lastName("Kot").roles("USER").permissions("").actived(1).build();
        UserEntity admin = UserEntity.builder().login("admin").password(passwordEncoder.encode("admin1")).roles("ADMIN").permissions("ACCESS_TEST1,ACCESS_TES2").actived(1).build();
        UserEntity employee = UserEntity.builder().login("menager").password(passwordEncoder.encode("menager1")).roles("MANAGER").permissions("ACCESS_TEST1").actived(1).build();
        //save to db
        userRepository.save(userEntity);
        userRepository.save(admin);
        userRepository.save(employee);
    }
}
