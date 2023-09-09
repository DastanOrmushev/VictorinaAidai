package service.impl;

import service.DbHelper;
import service.QuizService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class QuizServiceImpl implements QuizService {

    DbHelper dbHelper = new DbHelperImpl();
    Scanner scanner = new Scanner(System.in);
    @Override
    public void start() {
        dbHelper.getMap();
        int correctAnswer = 0;
        int 

        for (int i =0; i< 5; i++) {
            HashMap<String,HashMap<String,Boolean>> option = dbHelper.getQuestion();
            for (Map.Entry<String,HashMap<String,Boolean>> item: option.entrySet()){
                System.out.println("Угадайте столицу страны: "+item.getKey());
            }

        }

    }
}
