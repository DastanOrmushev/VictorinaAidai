package service.impl;

import service.DbHelper;
import service.QuizService;

import java.sql.SQLOutput;
import java.util.*;

public class QuizServiceImpl implements QuizService {

    DbHelper dbHelper = new DbHelperImpl();
    Scanner scanner = new Scanner(System.in);
    @Override
    public void start() {
        dbHelper.getMap();
        int correctAnswer = 0;


        for (int i =0; i< 5; i++) {
            HashMap<String,HashMap<String,Boolean>> option = dbHelper.getQuestion();

            ArrayList<String> cities = new ArrayList<>();
            for (Map.Entry<String,HashMap<String,Boolean>> item: option.entrySet()){
                System.out.println("\tВопрос №"+(i+1)+"\nУгадайте столицу страны: "+item.getKey());
                for (Map.Entry<String,Boolean> city: item.getValue().entrySet()){
                    cities.add(city.getKey());

                }
                Collections.shuffle(cities);
                System.out.println("Варианты ответов: ");
                for(String capitals: cities){
                    System.out.println(capitals);

                }
                String answer = scanner.next();

//                HashMap<String,Boolean>capitalAndAnswer = item.getValue();
//                Boolean corrctAnswer = capitalAndAnswer.get(answer);
                //TODO Обработать ошибку

                if(item.getValue().get(answer)){
                    correctAnswer++;
                }

            }

        }
        int result = correctAnswer * 100 / 5;
        System.out.println("Правильных ответов "+correctAnswer);
        System.out.println("Процент правильных ответов "+result);

    }
}
