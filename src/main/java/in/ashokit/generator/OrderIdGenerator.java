package in.ashokit.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class OrderIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        String prefix = "OD";

        String suffix = "";

        try (Connection con = session.getJdbcConnectionAccess().obtainConnection()) 
        {
            // Ensure the sequence is properly fetched
            String sql = "SELECT order_id_seq.NEXTVAL FROM dual";
            
            try (PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) 
            {
            	
                if (rs.next())
                {
                    long sequenceValue = rs.getLong(1);
                    suffix = String.valueOf(sequenceValue);
                }
            }
        } 
        catch (Exception e) 
        {
        	e.printStackTrace();
        }

        return prefix + suffix;
    }
}
