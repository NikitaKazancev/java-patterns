package com.example.pw18.phones;

import com.example.pw18.manufactures.Manufacture;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MyPhoneRepo {

	private final JdbcTemplate jdbcTemplate;
	private final RowMapper<Phone> phoneRawMapper;
	private final RowMapper<Manufacture> manufactureRowMapper;
	@PersistenceContext
	private EntityManager entityManager;

	public MyPhoneRepo(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		phoneRawMapper =
			new BeanPropertyRowMapper<>(Phone.class);
		manufactureRowMapper =
			new BeanPropertyRowMapper<>(Manufacture.class);
	}

	public Phone findById(Long id) {
		String sql = "SELECT * FROM phones WHERE id = ?";
		Phone phone = jdbcTemplate
			.query(sql, phoneRawMapper, id)
			.get(0);

		phone.setManufactures(getManufactureByPhoneId(id));
		return phone;
	}

	private List<Manufacture> getManufactureByPhoneId(
		Long id
	) {
		String sql =
			"SELECT m.name, m.address, m.id FROM manufactures m " +
			"WHERE m.phone_id = ?";

		return jdbcTemplate.query(
			sql,
				manufactureRowMapper,
			id
		);
	}

	public List<Phone> findByFilters(
			String name, String creationYear
	) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Phone> criteriaQuery = builder.createQuery(Phone.class);
		Root<Phone> phoneRoot = criteriaQuery.from(Phone.class);

		Predicate predicate = builder.conjunction();

		if (name != null && !name.isEmpty()) {
			predicate = builder.and(predicate, builder.like(phoneRoot.get("name"), name));
		}
		if (creationYear != null && !creationYear.isEmpty()) {
			predicate = builder.and(predicate, builder.like(phoneRoot.get("creationYear"), creationYear));
		}

		criteriaQuery.select(phoneRoot).orderBy(builder.asc(phoneRoot.get("name")));

		criteriaQuery.where(predicate);
		return entityManager.createQuery(criteriaQuery).getResultList();
	}
}
