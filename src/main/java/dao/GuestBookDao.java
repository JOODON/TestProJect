package dao;

import dto.GuestBook;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static dao.GuestBookDaoSqls.*;
@Repository
//해당객체에 빈을 생성해주겠다
public class GuestBookDao {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper<GuestBook> rowMapper = BeanPropertyRowMapper.newInstance(GuestBook.class);

    public GuestBookDao(DataSource dataSource){
        this.jdbc=new NamedParameterJdbcTemplate(dataSource);
        this.insertAction=new SimpleJdbcInsert(dataSource)
                .withTableName("guestbook")
                .usingGeneratedKeyColumns("id");
    }

    public List<GuestBook> selectAll(Integer start,Integer limit){
        Map<String,Integer> params=new HashMap<>();
        params.put("start",start);
        params.put("limit",limit);
        return jdbc.query(SELECT_PAGING,params,rowMapper);
    }

    public Long insert(GuestBook guestBook){
        SqlParameterSource params=new BeanPropertySqlParameterSource(guestBook);
        return insertAction.executeAndReturnKey(params).longValue();
    }

    public int deleteById(Long id){
        Map<String,?> params= Collections.singletonMap("id",id);
        return jdbc.update(DELETE_BY_ID,params);
    }

    public int selectCount(){
        return jdbc.queryForObject(SELECT_COUNT,Collections.<String, Object>emptyMap(),Integer.class);
    }
}
