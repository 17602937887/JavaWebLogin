package cn.Demo.ajax;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class jackson {
    @Test
    public void test() throws IOException {
        Person tom = new Person("Tom", "23", "man", new Date());
        Person sir = new Person("Sir", "45", "woman", new Date());
        Person Jack = new Person("Jack", "18", "man", new Date());
        ObjectMapper mapper = new ObjectMapper();
        List<Person> person = new ArrayList<>();
        person.add(sir);
        person.add(tom);
        person.add(Jack);

        Map<String, Object> map = new HashMap<>();
        map.put("name", "chenHang");
        map.put("age", "23");
        map.put("gender", "man");
        map.put("birthday", new Date());

        String json = mapper.writeValueAsString(map);

        Person a = mapper.readValue(json, Person.class);
        System.out.println(a);
    }
}
