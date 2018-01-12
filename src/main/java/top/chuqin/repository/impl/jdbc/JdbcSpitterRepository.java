package top.chuqin.repository.impl.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;
import top.chuqin.domian.Spitter;
import top.chuqin.repository.SpitterRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wengchuqin on 2018/1/12.
 */
@Component
public class JdbcSpitterRepository implements SpitterRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public long count() {
        return jdbcTemplate.queryForObject("select count(id) from Spitter", Long.class);
    }

    @Override
    public Spitter save(Spitter spitter) {
        long id = insertSpitterAndReturnId(spitter);
        return new Spitter(id, spitter.getUsername(), spitter.getPassword(), spitter.getFullName(), spitter.getEmail());
    }

    private long insertSpitterAndReturnId(Spitter spitter) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("Spitter");
        jdbcInsert.setGeneratedKeyName("id");
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("username", spitter.getUsername());
        args.put("password", spitter.getPassword());
        args.put("fullname", spitter.getFullName());
        args.put("email", spitter.getEmail());
        long spitterId = jdbcInsert.executeAndReturnKey(args).longValue();
        return spitterId;
    }

    @Override
    public Spitter findOne(long id) {
        return jdbcTemplate.queryForObject(
                "select id, username, password, fullname, email from Spitter where id=?", new SpitterRowMapper(), id);
    }

    private static final class SpitterRowMapper implements RowMapper<Spitter> {
        public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
            long id = rs.getLong("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String fullName = rs.getString("fullname");
            String email = rs.getString("email");
            return new Spitter(id, username, password, fullName, email);
        }
    }

    @Override
    public Spitter findByUsername(String username) {
        return null;
    }

    @Override
    public List<Spitter> findAll() {
        return null;
    }
}
