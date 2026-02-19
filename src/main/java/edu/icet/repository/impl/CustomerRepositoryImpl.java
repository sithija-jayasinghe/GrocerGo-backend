package edu.icet.repository.impl;

import edu.icet.model.Customer;
import edu.icet.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@RequiredArgsConstructor
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public boolean addCustomer(Customer customer) {
        String sql = "INSERT INTO customer VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.update(sql,
                customer.getId(),
                customer.getTitle(),
                customer.getName(),
                customer.getDOB(),
                customer.getSalary(),
                customer.getAddress(),
                customer.getCity(),
                customer.getProvince(),
                customer.getPostalCode()
        ) > 0;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        String sql = "UPDATE customer SET title=?, name=?, dob=?, salary=?, address=?, city=?, province=?, postal_code=? WHERE id=?";
        return jdbcTemplate.update(sql,
                customer.getTitle(),
                customer.getName(),
                customer.getDOB(),
                customer.getSalary(),
                customer.getAddress(),
                customer.getCity(),
                customer.getProvince(),
                customer.getPostalCode(),
                customer.getId()
        ) > 0;
    }

    @Override
    public boolean deleteCustomer(String id) {
        String sql = "DELETE FROM customer WHERE id=?";
        return jdbcTemplate.update(sql, id) > 0;
    }

    @Override
    public Customer getCustomerById(String id) {
        String sql = "SELECT * FROM customer WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Customer customer = new Customer();
            customer.setId(rs.getString(1));
            customer.setTitle(rs.getString(2));
            customer.setName(rs.getString(3));
            customer.setDOB(rs.getDate(4));
            customer.setSalary(rs.getDouble(5));
            customer.setAddress(rs.getString(6));
            customer.setCity(rs.getString(7));
            customer.setProvince(rs.getString(8));
            customer.setPostalCode(rs.getString(9));
            return customer;
        });
    }

    @Override
    public List<Customer> getAllCustomers() {
        String sql = "SELECT * FROM customer";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Customer customer = new Customer();
            customer.setId(rs.getString(1));
            customer.setTitle(rs.getString(2));
            customer.setName(rs.getString(3));
            customer.setDOB(rs.getDate(4));
            customer.setSalary(rs.getDouble(5));
            customer.setAddress(rs.getString(6));
            customer.setCity(rs.getString(7));
            customer.setProvince(rs.getString(8));
            customer.setPostalCode(rs.getString(9));
            return customer;
        });
    }
}
