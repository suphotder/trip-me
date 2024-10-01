package com.example.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.server.entity.TripEntity;
import com.example.server.repository.TripRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("trips")
public class TripController {
    private final TripRepository tripRepository;

    @GetMapping()
    public String getTrip() {
        TripEntity tripEntity1 = new TripEntity();
        tripEntity1.setTitle("คู่มือเที่ยวเกาะช้าง กิน เที่ยว พักที่ไหนดี? อ่านจบครบที่เดียว!");
        tripEntity1.setDescription(
                "เริ่มจากเพื่อนอยากไปเขาคิชฌกูฏ หลังจากดูรายการทีวี จึงทำให้เกิดทริปนี้ขึ้นแบบเร่งด่วน โดยเดินทางด้วยรถ บขส. ไปยังจันทบุรี และการเดินทางหลักในการเที่ยวคือมอเตอร์ไซค์เช่า");
        tripEntity1.setUrl("https://www.wongnai.com/trips/travel-koh-chang");

        tripRepository.save(tripEntity1);
        return "Get Trip";
    }
}