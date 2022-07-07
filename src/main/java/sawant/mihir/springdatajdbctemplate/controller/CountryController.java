package sawant.mihir.springdatajdbctemplate.controller;

import org.springframework.web.bind.annotation.*;
import sawant.mihir.springdatajdbctemplate.model.Country;
import sawant.mihir.springdatajdbctemplate.repository.CountryRepository;

import java.util.List;

@RestController
public record CountryController(CountryRepository repository) {

    public CountryController(CountryRepository repository){
        this.repository = repository;
    }

    @PostMapping("/country/post")
    public void addCountry(@RequestBody Country country){
        repository.storeCountry(country);
    }

    @GetMapping("/countries/all")
    public List<Country> getAllCountries(){
        return repository.findAllCountries();
    }

    @GetMapping("/country/{id}")
    public Country findById(@PathVariable int id){
        return getAllCountries().stream()
                .filter(country -> country.id() == id)
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Country with id: " + id + " provided does not exists"));

    }

}
