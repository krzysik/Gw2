package com.nauka.Nauka.controller;

import com.nauka.Nauka.model.Character;
import com.nauka.Nauka.model.Crafting;
import com.nauka.Nauka.model.Equipment;
import com.nauka.Nauka.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class Gw2Controller {

    @GetMapping("/AllCharacterInfo")
    public Character getAllCharacterInfo() {
        String url = "https://api.guildwars2.com/v2/characters/Pollocka?access_token=685E0020-4B78-F747-88A6-323B1A3661F1E15F3CD4-EDAE-4049-99D0-C86CC4EE9954";
        RestTemplate restTemplate = new RestTemplate();
        Character character = restTemplate.getForObject(url, Character.class);

        return character;

    }

    @CrossOrigin
    @GetMapping("/AllCharacters{apiKey}")
    public List<String> getAllCharacters(@RequestParam(value = "apiKey") String apiKey) {
        String url = "https://api.guildwars2.com/v2/characters?access_token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        List<String> result = restTemplate.getForObject(url, List.class);
        return result;

    }

    @CrossOrigin
    @GetMapping("/BasicCharacterInfo{character}{apiKey}")
    public List<Character> getBasicCharacterInfo(@RequestParam(value = "character") String character, @RequestParam(value = "apiKey") String apiKey) {
        String url = "https://api.guildwars2.com/v2/characters/" + character + "?access_token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        Character cha = restTemplate.getForObject(url, Character.class);
        Character c1 = new Character(cha.getName(), cha.getRace(), cha.getGender(), cha.getProfession(), cha.getLevel(), cha.getDeaths());
        return Arrays.asList(c1);
    }

    @GetMapping("/craftingLevels")
    public List<Crafting> getCraftingLevels() {
        String url = "https://api.guildwars2.com/v2/characters/Pollocka?access_token=685E0020-4B78-F747-88A6-323B1A3661F1E15F3CD4-EDAE-4049-99D0-C86CC4EE9954";
        RestTemplate restTemplate = new RestTemplate();
        Character character = restTemplate.getForObject(url, Character.class);
        return character.getCrafting();


    }

    @GetMapping("/AllEq")
    public List<Item> getEquipment() throws NullPointerException{
        List<Item> items = new ArrayList<>();
        String url = "https://api.guildwars2.com/v2/characters/Pollocka?access_token=685E0020-4B78-F747-88A6-323B1A3661F1E15F3CD4-EDAE-4049-99D0-C86CC4EE9954";
        RestTemplate restTemplate = new RestTemplate();
        Character eq = restTemplate.getForObject(url, Character.class);
        List<Equipment> eqs = eq.getEquipment();

        for(int i = 0 ; i<eqs.size(); i++){
                items.add(getItem(eqs.get(i).getId()));
        }

        return items;


    }

    @GetMapping("/Item{id}")
    public Item getItem(@RequestParam(value = "id") int id)
    {
        String url="https://api.guildwars2.com/v2/items/"+id;
        RestTemplate restTemplate = new RestTemplate();
        Item it = restTemplate.getForObject(url,Item.class);
        return it;
    }

}























