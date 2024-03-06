package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestVo;

@Repository
public class GuestbookDao {

   // 전체가져오기
   @Autowired
   private SqlSession sqlSession;


   public List<GuestVo> guestRead() {
      System.out.println("GuestbookDao.guestRead()");
      
       List<GuestVo> guestList=sqlSession.selectList("guestbook.select");

      return guestList;
   }
   
   public int guestWrite(GuestVo guestVo) {
	   System.out.println("GuestbookDao.guestWrite()");
	   int count = sqlSession.insert("guestbook.insert",guestVo);
	   
	   return count;
   }
  
   public int delete(GuestVo guestVo) {
	   System.out.println("GuestbookDao.delete()");
	   
	   int count=sqlSession.delete("guestbook.delete", guestVo);
		System.out.println(count);
		return count;
   }
   

}