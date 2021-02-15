package com.example.secondproject.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.secondproject.BR;

public class Person extends BaseObservable {
    private String name;
    private String age;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getAge() {
        return age;
    }
    public void setAge(String age){
        this.age = age;
        notifyPropertyChanged(BR.age);
    }
}
