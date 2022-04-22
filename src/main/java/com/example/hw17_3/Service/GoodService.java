package com.example.hw17_3.Service;

import com.example.hw17_3.Entity.Good;
import com.example.hw17_3.Repository.GoodRepository;

public class GoodService {
    GoodRepository goodRepository = new GoodRepository();

    public void save(Good good) {
        goodRepository.save(good);
    }

    public void delete(Good good) {
        goodRepository.delete(good);
    }

    public void update(Good good) {
        goodRepository.update(good);
    }

    public Good findById(Integer id) {
        return goodRepository.findById(id);
    }
}
