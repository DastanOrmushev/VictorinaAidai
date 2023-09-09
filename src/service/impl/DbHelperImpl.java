package service.impl;

import service.DbHelper;

import java.util.*;

public class DbHelperImpl implements DbHelper {
    Map <String,String> capitalsAndCountries = new HashMap<>();

    List<String> cities = new ArrayList<>();
    List<String> countries = new ArrayList<>();

    @Override
    public void getMap() {
        capitalsAndCountries.put("Кыргызстан","Бишкек");
        capitalsAndCountries.put("Китай","Пекин");
        capitalsAndCountries.put("Казахстан","Астана");
        capitalsAndCountries.put("США","Вашингтон");
        capitalsAndCountries.put("Италия","Рим");
        capitalsAndCountries.put("Испания","Мадрид");
        capitalsAndCountries.put("Канада","Оттава");
        capitalsAndCountries.put("Франция","Париж");
        capitalsAndCountries.put("Норвегия","Осло");
        capitalsAndCountries.put("Турция","Анкара");
        capitalsAndCountries.put("Саудовская Аравия","Эр-Рияд");
        capitalsAndCountries.put("ОАЭ","Абу-Даби");
        capitalsAndCountries.put("Португалия","Лиссабон");
        capitalsAndCountries.put("Япония","Токио");
        capitalsAndCountries.put("Бразилия","Бразилиа");
        capitalsAndCountries.put("Узбекистан","Ташкент");
        capitalsAndCountries.put("Перу","Лима");
        capitalsAndCountries.put("Мадагаскар","Антананариву");
        capitalsAndCountries.put("Марокко","Рабат");
        capitalsAndCountries.put("Чехия","Прага");
        capitalsAndCountries.put("Мексика","Мехико");
        capitalsAndCountries.put("Австралия","Канберра");
        capitalsAndCountries.put("Афганистан","Кабул");
        capitalsAndCountries.put("Индонезия","Джакарта");
        capitalsAndCountries.put("Россия","Москва");

        for (Map.Entry<String,String> item: capitalsAndCountries.entrySet()) {
            cities.add(item.getValue());
            countries.add(item.getKey());
        }

        Collections.shuffle(cities);
        Collections.shuffle(countries);

    }
    @Override
    public HashMap getQuestion() {
        HashMap<String, HashMap<String, Boolean>> result = new HashMap<>();
        String country = countries.get(9);
        countries.remove(country);
        Collections.shuffle(countries);
        String capital = capitalsAndCountries.get(country);

        HashMap<String,Boolean> options = new HashMap<>();

        options.put(capital,true);
        cities.remove(capital);

        for ( int i=0; i<3;i++){
            options.put(cities.get(i),false);
        }
        cities.add(capital);
        result.put(country,options);
        Collections.shuffle(cities);
        Collections.shuffle(countries);
        return result;
    }
}
