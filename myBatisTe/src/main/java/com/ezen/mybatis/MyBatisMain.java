package com.ezen.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisMain {

   public static void main(String[] args) {
      String resource = "com/ezen/mybatis/mybatis-config.xml";
      InputStream inputStream = null;
      try {
         inputStream = Resources.getResourceAsStream(resource);
         SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
         SqlSession session = sqlSessionFactory.openSession();
      
         BoardMethod mapper = session.getMapper(BoardMethod.class);
         
         BoardVO vo = mapper.selectOne(1);
        System.out.println(vo.toString());
        
       // mapper.deleteBoard(5);
		/*
		 * BoardVO vo3 = new BoardVO(); vo3.setId(10); vo3.setName("손흥민");
		 * vo3.setPhone("111-2222-3333"); vo3.setAddress("영국"); mapper.insertBoard(vo3);
		 */
        vo.setId(4);
        vo.setName("김연아");
        vo.setPhone("111-1111-1111");
        vo.setAddress("얼음왕국");
        
        mapper.updateBoard(vo);
        
        session.commit();
        
        
        System.out.println("-----------------------------------------------");
        
        List<BoardVO> list = mapper.selectAllMember();
        for(BoardVO vo2 : list)
        	System.out.println(vo2.toString());
        
        
            
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

}