package sawant.mihir.springdatajdbctemplate.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import sawant.mihir.springdatajdbctemplate.model.Country;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class CountryRepository {
    private final JdbcTemplate jdbcTemplate;

    public CountryRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void storeCountry(Country country){
        String sql = "INSERT INTO country(name, code) VALUES (?, ?)";
        jdbcTemplate.update(sql, country.name(), country.code());
    }

    public List<Country> findAllCountries(){
        String sql = "SELECT * FROM country";

        RowMapper<Country> countryRowMapper = (rs, rowNum) -> new Country(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("code"));

        return jdbcTemplate.query(sql, countryRowMapper);
    }
}
