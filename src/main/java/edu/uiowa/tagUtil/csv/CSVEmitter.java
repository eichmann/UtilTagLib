package edu.uiowa.tagUtil.csv;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;

import javax.naming.InitialContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SuppressWarnings("serial")
public class CSVEmitter extends TagSupport {
	private static final Log log = LogFactory.getLog(CSVEmitter.class);

	protected DataSource theDataSource = null;
	protected Connection theConnection = null;
	String dataSource = null;
	String schema = null;
	String table = null;

	public int doStartTag() throws JspException {
		log.info("dataSource: " + dataSource + "\tschema: " + schema + "\ttable: " + table);
		try {
			theConnection = getConnection();
			DatabaseMetaData metadata = theConnection.getMetaData();
			ResultSet resultSet = metadata.getColumns(null, schema, table, null);
			boolean first = true;
			while (resultSet.next()) {
				String name = resultSet.getString("COLUMN_NAME");
				String type = resultSet.getString("TYPE_NAME");
				int size = resultSet.getInt("COLUMN_SIZE");
				log.info("\tcolumn name: [" + name + "]; type: [" + type + "]; size: [" + size + "]");
				pageContext.getOut().print((first ? "" : ",") + name);
				first = false;
			}
			pageContext.getOut().print("\n");
			
			PreparedStatement stmt = theConnection.prepareStatement("select * from " + schema + "." + table);
			ResultSet rs = stmt.executeQuery();
			ResultSetMetaData metars = rs.getMetaData();
			while (rs.next()) {
				for (int i = 1; i <= metars.getColumnCount(); i++) {
					switch (metars.getColumnType(i)) {
					case Types.INTEGER:
					case Types.BIGINT:
					case Types.SMALLINT:
					case Types.TINYINT:
						pageContext.getOut().print(rs.getInt(i));
						break;
					case Types.DOUBLE:
						pageContext.getOut().print(rs.getDouble(i));
						break;
					case Types.FLOAT:
						pageContext.getOut().print(rs.getFloat(i));
						break;
					default:
						pageContext.getOut().print("\"" + rs.getString(i) + "\"");							
					}
					if (i < metars.getColumnCount())
						pageContext.getOut().print(",");
				}
				pageContext.getOut().print("\n");
			}
		} catch (SQLException | IOException e) {
			log.error("Error in database initialization", e);
		}
		return SKIP_PAGE;
	}
	
	public int doEndTag() throws JspException {
		clearServiceState();
		return super.doEndTag();
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	private void clearServiceState() throws JspTagException {
		this.dataSource = null;
		this.schema = null;
		this.table = null;
		freeConnection();
	}

	public DataSource getDataSourceInstance() {
		if (theDataSource == null)
			try {
				theDataSource = (DataSource) new InitialContext().lookup("java:/comp/env/jdbc/" + getDataSource());
			} catch (Exception e) {
				log.error("Error in database initialization", e);
			}

		return theDataSource;
	}

	public Connection getConnection() throws SQLException {
		if (theConnection == null)
			theConnection = getDataSourceInstance().getConnection();
		return theConnection;
	}

	public void freeConnection() throws JspTagException {
		try {
			if (theConnection != null)
				theConnection.close();
			theConnection = null;
		} catch (SQLException e) {
			log.error("JDBC error freeing connection", e);
			theConnection = null;
			throw new JspTagException("Error: JDBC error freeing connection");
		}
	}
}
