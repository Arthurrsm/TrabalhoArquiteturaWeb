package com.example.Rest_ApiFipe.service;

import com.example.Rest_ApiFipe.model.RestApiFipeEntity;
import com.example.Rest_ApiFipe.repository.RestApiFipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Service
public class RestApiFipeService {
    @Autowired
    private RestApiFipeRepository restApiFipeRepository;
    public String consultarMarcas() {
        String dadosFipe = "";
        String apiUrl = "https://parallelum.com.br/fipe/api/v1/carros/marcas";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            dadosFipe = responseEntity.getBody();
        } else {
            dadosFipe = "Falha ao obter dados meteorológicos. Código de status: " + responseEntity.getStatusCode();
        }
        inserirDados(dadosFipe);
        return dadosFipe;
    }

    public void inserirDados(String dadosFipe) {
        try {
            JSONArray jsonArray = new JSONArray(dadosFipe);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                String nome = jsonObj.getString("nome");
                RestApiFipeEntity fipe = new RestApiFipeEntity();
                fipe.setMarca(nome);
                restApiFipeRepository.save(fipe);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

