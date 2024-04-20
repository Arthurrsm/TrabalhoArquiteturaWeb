package com.example.ClimaApi.service;

import com.example.ClimaApi.model.ClimaApiEntity;
import com.example.ClimaApi.repository.ClimaApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Service
public class ClimaApiService {

    @Autowired
    private ClimaApiRepository climaApiRepository;

    public String preverTempo() {
        String dadosMeteorologicos = "";
        String apiUrl = "https://apiadvisor.climatempo.com.br/api/v1/anl/synoptic/locale/BR?token=a8ea70fe82c0bc4874bd3618e2d21ed0";


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            dadosMeteorologicos = responseEntity.getBody();
        } else {
            dadosMeteorologicos = "Falha ao obter dados meteorológicos. Código de status: " + responseEntity.getStatusCode();
        }
        inserirDados(dadosMeteorologicos);
        return dadosMeteorologicos;
    }

    public void inserirDados(String dadosMeteorologicos) {
        try {
            JSONArray jsonArray = new JSONArray(dadosMeteorologicos);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                String country = jsonObj.getString("country");
                String date = jsonObj.getString("date");
                String text = jsonObj.getString("text");
                ClimaApiEntity clima = new ClimaApiEntity();
                clima.setPais(country);
                clima.setDate(date);
                clima.setText(text);
                climaApiRepository.save(clima);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
