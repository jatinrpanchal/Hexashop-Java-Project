package com.univ.DAO;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.univ.DB.DBConnection;
import com.univ.DTO.CustomerDTO;

public class CustomerDAO {
public int insert(CustomerDTO dto)
{
	int x=0;
	try {
	Connection con=DBConnection.getConn();
	PreparedStatement ps= con.prepareStatement
   ("insert into customer(cname,cadd,email,mob,unm,pw) values(?,?,?,?,?,?)");
	ps.setString(1, dto.getCname());
	ps.setString(2, dto.getCadd());
	ps.setString(3, dto.getEmail());
	ps.setLong(4, dto.getMob());
	ps.setString(5, dto.getUnm());
	ps.setString(6,dto.getPw());
	x=ps.executeUpdate();
	}catch(Exception tt)
	{System.out.println(tt); }
	
	return x;
   }
public List loginCheck(String unm,String pw)
{
	List lst=new ArrayList();
	try {
	Connection con1=DBConnection.getConn();
   PreparedStatement ps=	con1.prepareStatement
	("select * from customer where unm=? AND pw=?");
     ps.setString(1, unm);
     ps.setString(2, pw);
    ResultSet rs= ps.executeQuery();
    if(rs.next())
    {
      lst.add(rs.getInt(1));
      lst.add(rs.getString(2));
      lst.add(rs.getString(3));
      lst.add(rs.getString(4));
      lst.add(rs.getLong(5));
      lst.add(rs.getString(6));
      lst.add(rs.getString(7));
    }
     
	}catch(Exception tt)
	{System.out.println(tt);}
	return lst;
}//login Check

public int uploadFile(String fnm,String price,String type,InputStream in)
{
	int x=0;

	int price1=Integer.parseInt(price);
	try {
		Connection con1=DBConnection.getConn();
	   PreparedStatement ps=con1.prepareStatement
		("insert into imagedata(imgname,imgprice,imgtype) values(?,?,?)");
	  ps.setString(1, fnm);
	  ps.setInt(2, price1);
	  ps.setString(3, type);
	 x= ps.executeUpdate();
	 if(x==1)
	 {                
String path="/home/administrator/Desktop/arvn/Hexashop/src/main/webapp/assets/images/"+fnm;
    FileOutputStream fos=new FileOutputStream(path);
     byte bt[]= in.readAllBytes();
	 fos.write(bt);
	 fos.close();
	 }
	   
	}catch(Exception tt)
	{System.out.println(tt);}
	return x;
}


}
