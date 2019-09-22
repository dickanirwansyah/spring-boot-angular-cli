package com.rnd.backendspring.config.util.uuid;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class GeneratorId {

    public static final String generateId() {
        Date currentDate = new Date();
        String simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd").format(currentDate);
        return "cat-"+simpleDateFormat+"-"+UUID.randomUUID().toString().substring(8);
    }

}
