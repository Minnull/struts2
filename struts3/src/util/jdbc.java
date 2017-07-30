package util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;  
/** 
 * ���ݿ������� 
 * ˵��:��װ�� �޲Σ��вΣ��洢���̵ĵ��� 
 * @author iflytek 
 * 
 */  
public class jdbc {  
  
    /** 
     * ���ݿ����������� 
     */  
    private static final String DRIVER = "com.mysql.jdbc.Driver";  
  
    /** 
     * �����ַ��� 
     */  
    private static final String URLSTR = "jdbc:mysql://localhost:3306/login";  
  
    /** 
     * �û��� 
     */  
    private static final String USERNAME = "root";  
  
    /** 
     * ���� 
     */  
    private static final String USERPASSWORD = "root";  
  
    /** 
     * �������ݿ����Ӷ��� 
     */  
    private Connection connnection = null;  
  
    /** 
     * ����PreparedStatement���� 
     */  
    private PreparedStatement preparedStatement = null;  
      
    /** 
     * ����CallableStatement���� 
     */  
    private CallableStatement callableStatement = null;  
  
    /** 
     * ������������� 
     */  
    private ResultSet resultSet = null;  
  
    static {  
        try {  
            // �������ݿ���������  
            Class.forName(DRIVER);  
        } catch (ClassNotFoundException e) {  
            System.out.println("������������");  
            System.out.println(e.getMessage());  
        }  
    }  
  
    /** 
     * �������ݿ����� 
     * @return ���ݿ����� 
     */  
    public Connection getConnection() {  
        try {  
            // ��ȡ����  
            connnection = DriverManager.getConnection(URLSTR, USERNAME,  
                    USERPASSWORD);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        return connnection;  
    }  
  
    /** 
     * insert update delete SQL����ִ�е�ͳһ���� 
     * @param sql SQL��� 
     * @param params �������飬��û�в�����Ϊnull 
     * @return ��Ӱ������� 
     */  
    public int executeUpdate(String sql, Object[] params) {  
        // ��Ӱ�������  
        int affectedLine = 0;  
          
        try {  
            // �������  
            connnection = this.getConnection();  
            // ����SQL   
            preparedStatement = connnection.prepareStatement(sql);  
              
            // ������ֵ  
            if (params != null) {  
                for (int i = 0; i < params.length; i++) {  
                    preparedStatement.setObject(i + 1, params[i]);  
                }  
            }  
              
            // ִ��  
            affectedLine = preparedStatement.executeUpdate();  
  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        } finally {  
            // �ͷ���Դ  
            closeAll();  
        }  
        return affectedLine;  
    }  
  
    /** 
     * SQL ��ѯ����ѯ���ֱ�ӷ���ResultSet�� 
     * @param sql SQL��� 
     * @param params �������飬��û�в�����Ϊnull 
     * @return ����� 
     */  
    private ResultSet executeQueryRS(String sql, Object[] params) {  
        try {  
            // �������  
            connnection = this.getConnection();  
              
            // ����SQL  
            preparedStatement = connnection.prepareStatement(sql);  
              
            // ������ֵ  
            if (params != null) {  
                for (int i = 0; i < params.length; i++) {  
                    preparedStatement.setObject(i + 1, params[i]);  
                }  
            }  
              
            // ִ��  
            resultSet = preparedStatement.executeQuery();  
  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }   
  
        return resultSet;  
    }  
      
    /** 
     * SQL ��ѯ����ѯ�����һ��һ�� 
     * @param sql SQL��� 
     * @param params �������飬��û�в�����Ϊnull 
     * @return ����� 
     */  
    public Object executeQuerySingle(String sql, Object[] params) {  
        Object object = null;  
        try {  
            // �������  
            connnection = this.getConnection();  
              
            // ����SQL  
            preparedStatement = connnection.prepareStatement(sql);  
              
            // ������ֵ  
            if (params != null) {  
                for (int i = 0; i < params.length; i++) {  
                    preparedStatement.setObject(i + 1, params[i]);  
                }  
            }  
              
            // ִ��  
            resultSet = preparedStatement.executeQuery();  
  
            if(resultSet.next()) {  
                object = resultSet.getObject(1);  
            }  
              
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        } finally {  
            closeAll();  
        }  
  
        return object;  
    }  
  
    /** 
     * ��ȡ������������������List�� 
     *  
     * @param sql 
     *            SQL��� 
     * @return List 
     *                       ����� 
     */  
    public List<Object> excuteQuery(String sql, Object[] params) {  
        // ִ��SQL��ý����  
        ResultSet rs = executeQueryRS(sql, params);  
          
        // ����ResultSetMetaData����  
        ResultSetMetaData rsmd = null;  
          
        // ���������  
        int columnCount = 0;  
        try {  
            rsmd = rs.getMetaData();  
              
            // ��ý��������  
            columnCount = rsmd.getColumnCount();  
        } catch (SQLException e1) {  
            System.out.println(e1.getMessage());  
        }  
  
        // ����List  
        List<Object> list = new ArrayList<Object>();  
  
        try {  
            // ��ResultSet�Ľ�����浽List��  
            while (rs.next()) {  
                Map<String, Object> map = new HashMap<String, Object>();  
                for (int i = 1; i <= columnCount; i++) {  
                    map.put(rsmd.getColumnLabel(i), rs.getObject(i));  
                }  
                list.add(map);  
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        } finally {  
            // �ر�������Դ  
            closeAll();  
        }  
  
        return list;  
    }  
      
    /** 
     * �洢���̴���һ����������ķ��� 
     * @param sql �洢������� 
     * @param params �������� 
     * @param outParamPos �������λ�� 
     * @param SqlType ����������� 
     * @return ���������ֵ 
     */  
    public Object excuteQuery(String sql, Object[] params,int outParamPos, int SqlType) {  
        Object object = null;  
        connnection = this.getConnection();  
        try {  
            // ���ô洢����  
            callableStatement = connnection.prepareCall(sql);  
              
            // ��������ֵ  
            if(params != null) {  
                for(int i = 0; i < params.length; i++) {  
                    callableStatement.setObject(i + 1, params[i]);  
                }  
            }  
              
            // ע���������  
            callableStatement.registerOutParameter(outParamPos, SqlType);  
              
            // ִ��  
            callableStatement.execute();  
              
            // �õ��������  
            object = callableStatement.getObject(outParamPos);  
              
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        } finally {  
            // �ͷ���Դ  
            closeAll();  
        }  
          
        return object;  
    }  
  
    /** 
     * �ر�������Դ 
     */  
    private void closeAll() {  
        // �رս��������  
        if (resultSet != null) {  
            try {  
                resultSet.close();  
            } catch (SQLException e) {  
                System.out.println(e.getMessage());  
            }  
        }  
  
        // �ر�PreparedStatement����  
        if (preparedStatement != null) {  
            try {  
                preparedStatement.close();  
            } catch (SQLException e) {  
                System.out.println(e.getMessage());  
            }  
        }  
          
        // �ر�CallableStatement ����  
        if (callableStatement != null) {  
            try {  
                callableStatement.close();  
            } catch (SQLException e) {  
                System.out.println(e.getMessage());  
            }  
        }  
  
        // �ر�Connection ����  
        if (connnection != null) {  
            try {  
                connnection.close();  
            } catch (SQLException e) {  
                System.out.println(e.getMessage());  
            }  
        }     
    }  
}  