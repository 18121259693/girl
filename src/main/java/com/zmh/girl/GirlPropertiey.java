package com.zmh.girl;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@PropertySource("application-prod.yml")
@ConfigurationProperties(prefix = "girl")
public class GirlPropertiey {
    private String cupSize;
    private int age;

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "GirlPropertiey{" +
                "cupSize='" + cupSize + '\'' +
                ", age=" + age +
                '}';
    }
}
