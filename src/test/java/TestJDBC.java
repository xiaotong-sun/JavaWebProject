import com.example.book.domain.BookNumber;
import com.example.book.utils.JDBCUtils;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestJDBC {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Test
    public void test(){
        String sql = "select max(bid) as 'maxBid' from book";
        System.out.println(template.queryForObject(sql, new BeanPropertyRowMapper<>(BookNumber.class)));

    }

}
