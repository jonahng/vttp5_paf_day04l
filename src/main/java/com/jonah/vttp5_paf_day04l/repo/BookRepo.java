package com.jonah.vttp5_paf_day04l.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.jonah.vttp5_paf_day04l.model.Book;
import com.jonah.vttp5_paf_day04l.utils.Query;

@Repository
public class BookRepo {
    @Autowired
    JdbcTemplate template;

    public Boolean insertBook(Book book){
        //template.update(Query.createBookSQL, book.getTitle(),book.getQuantity());//prepared statement settler 

        KeyHolder keyHolder = new GeneratedKeyHolder(); //this gets the primary key from the created record, so a child record can be made
        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException{
                PreparedStatement ps = con.prepareStatement(Query.createBookSQL, new String[] {"id"});
                ps.setString(1, book.getTitle());
                ps.setInt(2, book.getQuantity());
                return ps;
            }
        };

       int createBookId =  template.update(psc, keyHolder);//the keyholder gets the primary key after the prepared statement is finished
       if(createBookId>0){
        return true;
       }
       return false;

    }

    public List<Book> getAllBookS(){
        List<Book> allBooks = template.query(Query.getBookSQL, BeanPropertyRowMapper.newInstance(Book.class),null);
        if(allBooks.isEmpty()){
            //throw booknotfound exception
        }
        return allBooks;
    }

    public Book getBookById(int bookId){
        Book book =  template.queryForObject(Query.getBookById, BeanPropertyRowMapper.newInstance(Book.class), bookId);
        return book;
    }

    public Boolean updateBook(Book book){
        int bUpdated = template.update(Query.updateBookById, book.getTitle(), book.getQuantity(), book.getId());
        if(bUpdated > 0 ){
            return true;
        }
        return false;
    }

    public Boolean updateBookStatus(Book book){
        int bUpdated = template.update(Query.updateBookStatusById, book.getIsActive(), book.getId());
        if(bUpdated > 0 ){
            return true;
        }
        return false;
    }
}
