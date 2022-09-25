package dao;

import dto.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

import static dao.RoleDaoSqls.SELECT_ALL;

@Repository
public class RoleDao {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);

    public RoleDao(DataSource dataSource){
        this.jdbc =new NamedParameterJdbcTemplate(dataSource);
    }
    public List<Role> selectAll(){
        return jdbc.query(SELECT_ALL,Collections.<String, Object>emptyMap(),rowMapper);
    }
}
