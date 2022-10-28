package com.bbuhha;

import org.springframework.stereotype.Component;

//в скобках указываем id bean'a
//можно id не указывать, тогда default bean id = имя класса, но с прописной первой буквой
//в данном случае id = id = cat
//FavoriteSong -> id = favoriteSong
//SQLtext -> id = SQLtext (если 2 заглавные в начале идут подряд, то не меняется)
@Component("catBean")
public class Cat implements Pet{
    public Cat() {
        System.out.println("Cat bean created");
    }
    @Override
    public void say() {
        System.out.println("Meow-meow");
    }
}
