package com.example.secondproject.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

public class Product extends BaseObservable {
        private String name;
        private String password;
        private String email;

        public Product(String name, String password, String email){
            this.name = name;
            this.email = email;
            this.password = password;
        }
        @Bindable
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
            notifyPropertyChanged(BR.name);
        }
        @Bindable
        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
            notifyPropertyChanged(BR.password);
        }
        @Bindable
        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
            notifyPropertyChanged(BR.email);
        }
    }

