package com.example.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.Content;
import com.example.model.Status;
import com.example.model.Type;

@Repository
public class ContentJdbcTemplateRepository {
	
	private final JdbcTemplate jdbcTemplate;

	public ContentJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Content> getAllContent() {
		String sql = "SELECT * FROM Content";
		return jdbcTemplate.query(sql, ContentJdbcTemplateRepository::mapRow);
	}
	
	public void createContent(String title, String desc, String status, String contentType, String URL) {
        String sql = "INSERT INTO Content (title, desc, status, content_type, date_created, URL) VALUES (?, ?, ?, ?, NOW(), ?)";
        jdbcTemplate.update(sql, title, desc, status, contentType, URL);
    }

    public void updateContent(int id, String title, String desc, String status, String contentType, String URL) {
        String sql = "UPDATE Content SET title=?, desc=?, status=?, content_type=?, date_updated=NOW(), url=? WHERE id=?";
        jdbcTemplate.update(sql, title, desc, status, contentType, URL, id);
    }

    public void deleteContent(int id) {
        String sql = "DELETE FROM Content WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    public Content getContent(int id) {
        String sql = "SELECT * FROM Content WHERE id=?";
        return jdbcTemplate.queryForObject(sql, ContentJdbcTemplateRepository::mapRow, id);
    }
	
	private static Content mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return new Content(rs.getInt("id"),
				rs.getString("title"),
				rs.getString("desc"),
				Status.valueOf(rs.getString("status")),
				Type.valueOf(rs.getString("content_type")),
				rs.getObject("date_created", LocalDateTime.class),
				rs.getObject("date_updated", LocalDateTime.class),
				rs.getString("url"));
	}
}
