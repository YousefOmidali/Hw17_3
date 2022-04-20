package com.example.hw17_3;

import com.example.hw17_3.Entity.Good;
import com.example.hw17_3.Service.GoodService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "GoodServlet", value = "/good")
public class GoodsServlet extends HttpServlet {
    GoodService goodService = new GoodService();
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var jsonString = new String(request.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        var objectMapper = new ObjectMapper();
        Good good = objectMapper.readValue(jsonString, Good.class);
        var goodAfterSearch = goodService.findById(good.getId());
        System.out.println(goodAfterSearch);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var jsonString = new String(request.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        var objectMapper = new ObjectMapper();
        Good good = objectMapper.readValue(jsonString, Good.class);
        goodService.save(good);
        System.out.println(good);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var jsonString = new String(req.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        var objectMapper = new ObjectMapper();
        Good good = objectMapper.readValue(jsonString, Good.class);
        goodService.update(good);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var jsonString = new String(req.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        var objectMapper = new ObjectMapper();
        Good good = objectMapper.readValue(jsonString, Good.class);
        goodService.deleteById(good.getId());
    }
}
