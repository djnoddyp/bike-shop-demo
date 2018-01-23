package pnodder.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import pnodder.model.Bike;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BikeDao implements GenericDao {

    private NamedParameterJdbcTemplate parameterJdbcTemplate;
    private JdbcTemplate jdbcTemplate;

    public BikeDao(DataSource dataSource) {
        this.parameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final class BikeMapper implements RowMapper<Bike> {
        @Override
        public Bike mapRow(ResultSet rs, int rowNum) throws SQLException {
            Bike bike = new Bike();
            bike.setMake(rs.getString("make"));
            bike.setModel(rs.getString("model"));
            bike.setPrice(rs.getInt("price"));
            return bike;
        }
    }

    @Override
    public List<Bike> findAll() {
        String sql = "SELECT * FROM bike";
        return jdbcTemplate.query(sql, new BikeMapper());
    }

    public Bike findByMake(String make) {
        String sql = "SELECT * FROM bike WHERE make = :make";
        SqlParameterSource parameterSource = new MapSqlParameterSource("make", make);
        return this.parameterJdbcTemplate.queryForObject(sql, parameterSource, new BikeMapper());
    }

    @Override
    public Bike findById(Integer id) {
        String sql = "SELECT * FROM bike WHERE id = :id";
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        return this.parameterJdbcTemplate.queryForObject(sql, parameterSource, new BikeMapper());
    }
}
