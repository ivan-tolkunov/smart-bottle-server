package ua.smart.bottle.smartbottle.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.smart.bottle.smartbottle.model.ChartInfo;
import ua.smart.bottle.smartbottle.model.Water;
import ua.smart.bottle.smartbottle.service.WaterService;

import java.util.List;

@RestController
@RequestMapping("/data")
public class APIController {

    final WaterService waterService;

    @Autowired
    public APIController(WaterService waterService) {
        this.waterService = waterService;
    }
    @GetMapping("/get")
    public List<Water> getWaterData() {
        return waterService.getWaterForToday();
    }

    @GetMapping("/get-amount")
    public Double getWaterAmountData() {
        return waterService.getWaterPerDayAmount();
    }

    @GetMapping("/get-data-per-day")
    public List<ChartInfo> getWaterDataPerDay() {
        return waterService.findAllWaterPerADay();
    }
    @PostMapping("/insert")
    public Water insertWaterAmount(@RequestBody String amount) {
        return waterService.createWater(Double.parseDouble(amount));
    }
}
