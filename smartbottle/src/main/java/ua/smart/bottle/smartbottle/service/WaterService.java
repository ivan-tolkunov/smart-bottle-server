package ua.smart.bottle.smartbottle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.smart.bottle.smartbottle.model.ChartInfo;
import ua.smart.bottle.smartbottle.model.Water;
import ua.smart.bottle.smartbottle.repository.WaterRepository;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WaterService {

    final WaterRepository waterRepository;

    @Autowired
    public WaterService(WaterRepository waterRepository) {
        this.waterRepository = waterRepository;
    }

    public Water createWater(Double amount) {
        LocalDateTime dateTime = LocalDateTime.now();
        DayOfWeek dayOfWeek = dateTime.getDayOfWeek();

        return waterRepository.save(new Water(calculateLiters(amount), dayOfWeek, dateTime));

    }

    public List<ChartInfo> findAllWaterPerADay() {
        return getWaterForToday().stream()
                .map(water ->
                        new ChartInfo(water.getDateTime().format(DateTimeFormatter.ofPattern("HH:mm")),
                                water.getAmount())
                )
                .collect(Collectors.toList());
    }

    public List<Water> getWaterForToday() {
        LocalDateTime start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        LocalDateTime end = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        return waterRepository.findByDateTimeBetween(start, end);

    }

    public Double getWaterPerDayAmount() {
        DecimalFormat df = new DecimalFormat("0.0");
        df.setRoundingMode(RoundingMode.DOWN);
        return parseDoubleTwoDigits(getWaterForToday()
                .stream()
                .map(Water::getAmount)
                .reduce(0d, Double::sum));

    }

    private double calculateLiters(Double amount) {

        return parseDoubleTwoDigits((Math.PI * Math.pow(3.75, 2) * amount) / 1000);
    }

    private double parseDoubleTwoDigits(double number) {
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.DOWN);
        return Double.parseDouble(df.format(number));
    }

}
