package com.example.rentcar.repository;

import com.example.rentcar.Entity.CarEntity;
import com.example.rentcar.Entity.OrderEntity;
import com.example.rentcar.Entity.UserEntity;
import com.example.rentcar.model.Brand;
import com.example.rentcar.model.CarColour;
import com.example.rentcar.model.CarType;
import com.example.rentcar.model.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class DAO {


    private CarRepository carRepository;
    private UserRepository userRepository;
    private OrderRepository orderRepository;
    private PasswordEncoder passwordEncoder;

    public DAO(CarRepository carRepository, UserRepository userRepository, OrderRepository orderRepository, PasswordEncoder passwordEncoder) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired


    @EventListener(ApplicationReadyEvent.class)
    public void createMockDataBases() {
        this.userRepository.deleteAll();
        CarEntity carEntity1 = CarEntity.builder().brand(Brand.AUDI).model("A4").carColour(CarColour.BLACK).id(1L)
                .mileage(10000).price(100).carType(CarType.COMBI).vin("121453iu111").enginePower(200)
                .imagePath("/resources/static/images/AUDI.png").build();
        CarEntity carEntity2 = CarEntity.builder().brand(Brand.BMW).model("X3").carColour(CarColour.RED).id(2L)
                .mileage(12000).price(200).carType(CarType.SUV).vin("121153iu111").enginePower(150).imagePath("/resources/static/images/BMW.png").build();
        CarEntity carEntity3 = CarEntity.builder().brand(Brand.OPEL).model("TRAFFIC").carColour(CarColour.WHITE).id(3L)
                .mileage(12500).price(300).carType(CarType.BUS).vin("235153iu1d11").enginePower(160).imagePath("/resources/static/images/OPEL.png").build();
        CarEntity carEntity4 = CarEntity.builder().brand(Brand.PORSCHE).model("911").carColour(CarColour.WHITE).id(4L)
                .mileage(7800).price(1500).carType(CarType.SPORT).vin("7438753iu1d11").enginePower(400).imagePath("/resources/static/images/PORSCHE.png").build();
        CarEntity carEntity5 = CarEntity.builder().brand(Brand.FIAT).model("TIPO").carColour(CarColour.WHITE).id(5L)
                .mileage(9500).price(120).carType(CarType.SEDAN).vin("7444753iu1d11").enginePower(110).imagePath("/resources/static/images/tipo.png").build();
        CarEntity carEntity6 = CarEntity.builder().brand(Brand.MERCEDES).model("VITO").carColour(CarColour.GREY).id(6L)
                .mileage(45000).price(300).carType(CarType.BUS).vin("1444753iu1d11").enginePower(150).imagePath("/resources/static/images/MERCEDES.png").build();

        carRepository.save(carEntity1);
        carRepository.save(carEntity2);
        carRepository.save(carEntity3);
        carRepository.save(carEntity4);
        carRepository.save(carEntity5);
        carRepository.save(carEntity6);

        this.userRepository.deleteAll();

        UserEntity userEntity1 = UserEntity.builder().login("janek").password(passwordEncoder.encode("janek")).street("Łowicka 1").city("Skierniewice").postCode("90-000").phoneNumber("+48 900900900")
                .email("janek@wp.pl").firstName("Jan").lastName("Kot").roles("USER").permissions("").actived(1).build();
        UserEntity disactivedUser = UserEntity.builder().login("maria").password(passwordEncoder.encode("maria")).street("Prosta 12").city("Pabianice").postCode("91-000").phoneNumber("+48 600999900")
                .email("janek@wp.pl").firstName("Maria").lastName("Łopacińska").roles("USER").permissions("").actived(0).build();
        UserEntity userEntity2 = UserEntity.builder().login("bartek").password(passwordEncoder.encode("bartek")).street("Pucka").city("Kraków").postCode("60-120").phoneNumber("+48 800900900")
                .email("bartek@wp.pl").firstName("Bartosz").lastName("Bala").roles("USER").permissions("").actived(1).build();
        UserEntity admin = UserEntity.builder().login("admin").firstName("ADMIN").password(passwordEncoder.encode("admin1")).roles("ADMIN").permissions("ACCESS_TEST1,ACCESS_TES2").actived(1).build();
        UserEntity employee = UserEntity.builder().login("tomek").firstName("Tomasz").lastName("Wójcik").email("tomek@rentcar.com").phoneNumber("+48602604056").password(passwordEncoder.encode("tomek1")).roles("EMPLOYEE").permissions("ACCESS_TEST1").actived(1).build();
        //save to db
        userRepository.save(userEntity1);
        userRepository.save(userEntity2);
        userRepository.save(admin);
        userRepository.save(employee);
        userRepository.save(disactivedUser);
        this.orderRepository.deleteAll();
        OrderEntity orderEntity1 = OrderEntity.builder().dateOfOrder(LocalDate.now().minusDays(6)).dateOfStartRentCar(LocalDate.now().minusDays(5)).dateOfFinishRentCar(LocalDate.now().minusDays(3))
                .carEntity(carEntity2).userEntity(userEntity1).additionalInformation("I nead automatical gearbox").orderCost(BigDecimal.valueOf(500.5)).orderCompleted(true).orderStatus(OrderStatus.COMPLETED).build();
        OrderEntity orderEntity2 = OrderEntity.builder().dateOfOrder(LocalDate.now().minusDays(20)).dateOfStartRentCar(LocalDate.now().minusDays(15)).dateOfFinishRentCar(LocalDate.now().minusDays(12))
                .carEntity(carEntity6).userEntity(userEntity2).additionalInformation("I nead 9 seats in bus").orderCost(BigDecimal.valueOf(1000)).orderCompleted(true).orderStatus(OrderStatus.COMPLETED).build();
        OrderEntity orderEntity3 = OrderEntity.builder().dateOfOrder(LocalDate.now().minusDays(3)).dateOfStartRentCar(LocalDate.now().minusDays(2)).dateOfFinishRentCar(LocalDate.now().plusDays(7))
                .carEntity(carEntity6).userEntity(userEntity2).additionalInformation("I nead 9 seats in bus").orderCost(BigDecimal.valueOf(1200)).orderStatus(OrderStatus.INPROGRESS).build();

        orderRepository.save(orderEntity1);
        orderRepository.save(orderEntity2);
        orderRepository.save(orderEntity3);

    }
}
