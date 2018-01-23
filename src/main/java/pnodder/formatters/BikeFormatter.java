package pnodder.formatters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import pnodder.dao.BikeDao;
import pnodder.model.Bike;

import javax.sql.DataSource;
import java.text.ParseException;
import java.util.Locale;

public class BikeFormatter implements Formatter<Bike> {
    
    @Autowired
    private BikeDao bikeDao;

    @Override
    public Bike parse(String s, Locale locale) throws ParseException {
        final Integer id = Integer.valueOf(s);
        return this.bikeDao.findById(id);
    }

    @Override
    public String print(Bike bike, Locale locale) {
        return null;
    }
}
