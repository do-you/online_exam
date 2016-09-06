package zhou.onlineexam;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;


/**
 * 执行所有的数据库增删改查操作
 * @author stalley
 *
 */
public class CommonDAO {
	
	private Connection conn;
	
	public void setConn(Connection conn){
		this.conn = conn;
	}
	
	/**
	 * 执行增删改的sql
	 * @return int 影响数据库的行数
	 * insert into userinfo (username,password) value(?,?)   "admin","123"
	 */
	public int executeUpdate(String sql,Object...params){
		/*
		 * 1：有效的防止sql注入，但不是绝对的安全，
		 * 2：提高数据库的综合效率 
		 *   可以将sql语句的结构保存到数据库缓存中，当再次执行该结构的sql语句就可以直接执行缓存中的sql
		 *   从而提高数据库的效率
		 */
		PreparedStatement pstm = null;
		try {
			//找个车，负责向数据发送SQL语句
			pstm = conn.prepareStatement(sql);
			
			//给sql语句中的占位符赋值
			for(int i = 0 ; i < params.length ; i++){
				pstm.setObject(i+1, params[i]);
			}
			//发送执行sql语句
			int i = pstm.executeUpdate(); //这里的sql就不能再试sql语句的结构体，必须具体到某一个sql语句
			//影响数据库的行数
			return i;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage(),e);
		}
		finally{
			DBHelper.close(null, pstm, null);
		}
	}
	
	public int count(String sql,Object...params){
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			//找个车，负责向数据发送SQL语句
			pstm = conn.prepareStatement(sql);
			//给sql语句中的占位符赋值
			for(int i = 0 ; i < params.length ; i++){
				pstm.setObject(i+1, params[i]);
			}
			//发送执行sql语句
			rs = pstm.executeQuery(); //这里的sql就不能再试sql语句的结构体，必须具体到某一个sql语句
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage(),e);
		}
		finally{
			DBHelper.close(rs, pstm, null);
		}
		return 0;
	}
	
	
	/**
	 * 执行查询的sql语句
	 */
	public <T> List<T> executeQuery(String sql,Class<T> clazz,Object...params){
		//集合保存查询结果
		List<T> data = new ArrayList<T>();
		PreparedStatement pstm = null;
		//结果集，负责获取查询结果
		ResultSet rs = null;
		try {
			
			//实例化PreparedStatement对象
			pstm = conn.prepareStatement(sql);
			//设置参数
			for(int i = 0 ; i < params.length ; i++){
				pstm.setObject(i+1, params[i]);
			}
			//发送并执行sql语句
			rs = pstm.executeQuery();
			
			//获取结果集的元数据对象
			ResultSetMetaData rsmd = rs.getMetaData();
			
			//从元数据中获取结果集列的数量
			int count = rsmd.getColumnCount();
			
			//创建一个String类型泛型集合，用来保存结果集中的列名
			List<String> columns = new ArrayList<String>(count);
			
			for(int i = 0 ; i< count ;i++){
				columns.add(rsmd.getColumnLabel(i+1));
			}
			
			
			//从缓存中获取set 方法
			List<SetBean> setList = CacheBean.cache.get(clazz.getName());
			if(setList == null){
				setList = new ArrayList<SetBean>();
				Method [] ms = clazz.getMethods();
				//筛选所有的set方法
				for(Method m : ms){
					if(m.getName().startsWith("set")){
						SetBean s = new SetBean();
						s.setSetMethod(m);
						s.setParameterType(m.getParameterTypes()[0]);
						setList.add(s);
					}
				}
				CacheBean.cache.put(clazz.getName(), setList);
			}
			
			
			//从结果集中获取数据
			//判断有没有下一条数据
			while(rs.next()){
				//通过字节码创建对象
				T t = clazz.newInstance();
				
				for(String columnName : columns){
					//如果 "set" + 列名 和 我们拿到的方法名相同，说明，数据和实体类的属性对应
					for(SetBean m : setList){
						if(("set" + columnName) .equalsIgnoreCase(m.getSetMethod().getName())){
							//获取方法的参数类型
							Class ptype = m.getParameterType();
							//判断参数的类型，如果参数是Integer 就以int类型获取数据
							if(ptype == Integer.class){
								m.getSetMethod().invoke(t, rs.getInt(columnName));
							}
							else if(ptype == Long.class){
								m.getSetMethod().invoke(t, rs.getLong(columnName));
							}
							//小数
							else if(ptype == Double.class){
								m.getSetMethod().invoke(t, rs.getDouble(columnName));
							}
							else if(ptype == Date.class){
								m.getSetMethod().invoke(t, rs.getDate(columnName));
							}
							else if(ptype == String.class){
								m.getSetMethod().invoke(t, rs.getString(columnName));
							}
							else if(ptype == Boolean.class){
								m.getSetMethod().invoke(t, rs.getBoolean(columnName));
							}
						}
					}
				}
				data.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage(),e);
		}
		finally{
			DBHelper.close(rs, pstm, null);
		}
		return data;
	} 
	
	
	public static void main(String[] args) {
		CommonDAO dao = new CommonDAO();
		/*int i = dao.executeUpdate("insert into userinfo (username,password) value(?,?)","karen","123456");
		int j = dao.executeUpdate("delete from userinfo where id = ? ",2);
		int k = dao.executeUpdate("update userinfo set password = ?","karen123");
		
		System.out.println(i);
		System.out.println(j);
		System.out.println(k);*/
		
//		List<Map<String,Object>> data = dao.executeQuery("select username as uname , password as pwd from userinfo");
//		
//		System.out.println(data);
		
		
		
		
		
//		String sql = "select * from userInfo";
		
//		List<User> userList = dao.executeQuery(sql, User.class);
//		
//		for(User u : userList){
//			System.out.println(u.getId() + "\t" + u.getUsername() + "\t" + u.getPassword()); 
//		}
//		

		
		String sql = "select id,orderNo,cusName from orderInfo";
		List<Order> orderList = dao.executeQuery(sql, Order.class);
		for(Order o : orderList){
			System.out.println(o.getId() + "\t" + o.getOrderNo() + "\t" + o.getCusName());
		}
		
	}
}
