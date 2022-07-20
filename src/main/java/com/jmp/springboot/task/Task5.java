package com.jmp.springboot.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task5 {
    private static BigDecimal exchangeRate = BigDecimal.valueOf(23000);

    private static final Logger LOGGER = LoggerFactory.getLogger(Task5.class);

    public static void main(String[] args) throws InterruptedException {
        User user1 = new User();
        user1.setId(1l);
        user1.setUSD(BigDecimal.valueOf(1000));
        user1.setVND(BigDecimal.valueOf(0));

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Runnable runnable = () -> {
            try {
                exchangeUSDToVND(user1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        executorService.submit(runnable);
        executorService.submit(runnable);
        executorService.submit(runnable);
    }

    private static void exchangeUSDToVND(User user) throws InterruptedException {
        synchronized (user) {
            Thread.sleep(3000);

            LOGGER.info("Exchange rate = " + exchangeRate);
            LOGGER.info("Before exchange");
            LOGGER.info("USD = " + user.getUSD());
            LOGGER.info("VND = " + user.getVND());

            BigDecimal oldVND = user.getVND();
            BigDecimal VND = exchangeRate.multiply(user.getUSD());
            user.setUSD(BigDecimal.ZERO);
            user.setVND(VND.add(oldVND));
            LOGGER.info("After exchange");
            LOGGER.info("USD = " + user.getUSD());
            LOGGER.info("VND = " + user.getVND());
            LOGGER.info("---------------------------");
        }
    }
}
