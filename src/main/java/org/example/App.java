package org.example;

import org.example.dao.UserDao;
import org.example.entity.Diary;
import org.example.entity.SmartPhone;
import org.example.entity.User;
import org.example.hibernateUtil.HibernateUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        UserDao userDao = new UserDao();

        User user = new User("Murad legenda3","55555", LocalDate.now());
        User user2 = new User("Murad legenda2","11111", LocalDate.now());
        User user3 = new User("Murad legenda3","2222", LocalDate.now());



        List<SmartPhone> smartPhonesList = new ArrayList<>();
        smartPhonesList.add(new SmartPhone("iPhone 12", 895959693, 20000));
        smartPhonesList.add(new SmartPhone("iPhone 15", 45633, 20043400));
        smartPhonesList.add(new SmartPhone("iPhone 114", 4345466, 20045600));
        user.setSmartPhone(smartPhonesList);

        user.setDiary(new Diary(2,10, List.of(4,2,3,3,5)));
        user2.setDiary(new Diary(1,15, List.of(1,3,4,2,5,5)));
        user3.setDiary(new Diary(3,99, List.of(5,5,5,5,5,5)));

        userDao.create(user);
        userDao.create(user2);
        userDao.create(user3);


        HibernateUtil.closeSessionFactory();


    }
}
