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
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class Gw2Controller {

    @GetMapping("/AllCharacterInfo")
    public Character getAllCharacterInfo(@RequestParam(value = "characterName") String characterName,@RequestParam(value ="apiKey") String apiKey) {
        String url = "https://api.guildwars2.com/v2/characters/"+characterName+"?access_token="+apiKey;
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(url, Character.class);

    }

    @CrossOrigin
    @GetMapping("/AllCharacters{apiKey}")
    public List<String> getAllCharacters(@RequestParam(value = "apiKey") String apiKey) {
        String url = "https://api.guildwars2.com/v2/characters?access_token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, List.class);

    }

    @CrossOrigin
    @GetMapping("/BasicCharacterInfo{character}{apiKey}")
    public List<Character> getBasicCharacterInfo(@RequestParam(value = "characterName") String characterName, @RequestParam(value = "apiKey") String apiKey) {
        String url = "https://api.guildwars2.com/v2/characters/" + characterName + "?access_token=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        Character cha = restTemplate.getForObject(url, Character.class);
        assert cha != null;
        Character c1 = new Character(cha.getName(), cha.getRace(), cha.getGender(), cha.getProfession(), cha.getLevel(), cha.getDeaths());
        return Collections.singletonList(c1);
    }

    @GetMapping("/craftingLevels")
    public List<Crafting> getCraftingLevels(@RequestParam(value = "characterName") String characterName, @RequestParam(value = "apiKey") String apiKey) {
        String url = "https://api.guildwars2.com/v2/characters/"+characterName+"?access_token="+apiKey;
        RestTemplate restTemplate = new RestTemplate();
        Character character = restTemplate.getForObject(url, Character.class);
        assert character != null;
        return character.getCrafting();


    }

    @GetMapping("/AllEq")
    public List<Item> getEquipment(@RequestParam(value = "characterName") String characterName, @RequestParam(value = "apiKey") String apiKey){
        List<Item> items = new ArrayList<>();
        String url = "https://api.guildwars2.com/v2/characters/"+characterName+"?access_token="+apiKey;
        RestTemplate restTemplate = new RestTemplate();
        Character eq = restTemplate.getForObject(url, Character.class);
        assert eq != null;
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
        return restTemplate.getForObject(url,Item.class);
    }
    @GetMapping("/Mounts")
    public List<String> getMounts(@RequestParam(value = "apiKey") String apiKey){
        String url ="https://api.guildwars2.com/v2/account/mounts/types?access_token="+apiKey;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url,List.class);
    }

}























