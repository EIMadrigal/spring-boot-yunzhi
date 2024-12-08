package com.example.yunzhi;

import com.example.yunzhi.model.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("teacher")
public class TeacherController {

    private final static Logger logger = LoggerFactory.getLogger(TeacherController.class.getName());

    @Autowired
    JdbcTemplate jdbcTemplate;

    @CrossOrigin(origins = "*")
    @GetMapping
    public List<Teacher> getAll() {

        List<Teacher> teachers = new ArrayList<>();

        RowCallbackHandler rowCallbackHandler = new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                logger.info("Processed result: " + rs.toString());

                Teacher teacher = new Teacher();
                teacher.setId(rs.getLong("id"));
                teacher.setName(rs.getString("name"));
                teacher.setUsername(rs.getString("username"));
                teacher.setEmail(rs.getString("email"));
                teacher.setGender(rs.getBoolean("sex"));
                teacher.setCreateTime(rs.getTimestamp("create_time").toLocalDateTime().atZone(ZoneId.of("Asia" +
                        "/Shanghai")));
                teacher.setUpdateTime(rs.getTimestamp("update_time").toLocalDateTime().atZone(ZoneId.of("Asia" +
                        "/Shanghai")));

                teachers.add(teacher);
            }
        };

        String query = "select id, name, username, email, sex, create_time, update_time from teacher";

        jdbcTemplate.query(query, rowCallbackHandler);
        return teachers;
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public void save(@RequestBody Teacher teacher) {
        logger.info("trigger save method");
        String sql = String.format("insert into teacher (name, username, email, sex) values ('%s', '%s', '%s', %s)",
                teacher.getName(), teacher.getUsername(), teacher.getEmail(), teacher.getGender().compareTo(false));
        logger.info(sql);
        jdbcTemplate.execute(sql);
    }
}
